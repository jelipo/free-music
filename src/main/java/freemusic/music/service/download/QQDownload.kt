package freemusic.music.service.download

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.qq.TencentMvData
import freemusic.tool.HttpTool
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap

@Service
class QQDownload : MusicDownloadService {

    @Autowired
    private lateinit var httpTool: HttpTool

    @Autowired
    private lateinit var httpClient: OkHttpClient

    private val vHeaders = Headers.of(
            "User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1",
            "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
            "Connection", "keep-alive",
            "Accept-Charset", "UTF-8,*;q=0.5",
            "Accept-Language", "en-US,en;q=0.8",
            "referer", "http://y.qq.com"
    )

    override fun getDownloadUrl(id: String, quality: String): String {
        val guid = Math.round(Math.random() * (10000000000 - 1000000000) + 1000000000)
        val key = getKey(guid, id)
        return when (quality) {
            "s128" -> "http://dl.stream.qqmusic.qq.com/M500$id.mp3?vkey=$key&guid=$guid&fromtag=30"
            "sogg" -> "http://dl.stream.qqmusic.qq.com/O600$id.ogg?vkey=$key&guid=$guid&fromtag=50"
            "s320" -> "http://dl.stream.qqmusic.qq.com/M800$id.mp3?vkey=$key&guid=$guid&uin=1044154167&fromtag=30"
            else -> ""
        }
    }

    override fun getMvUrl(id: String, quality: String): String {
        val sendUrl = "http://vv.video.qq.com/getinfo?vid=$id&platform=11&charge=1&otype=json"
        val request = Request.Builder().url(sendUrl)
                .addHeader("Cookie", "__remember_me=true; MUSIC_U=5f9d910d66cb2440037d1c68e6972ebb9f15308b56bfeaa4545d34fbabf71e0f36b9357ab7f474595690d369e01fbb9741049cea1c6bb9b6; __csrf=8ea789fbbf78b50e6b64b5ebbb786176; os=uwp; osver=10.0.10586.318; appver=1.2.1; deviceId=0e4f13d2d2ccbbf31806327bd4724043")
                .build()
        val response = httpClient.newCall(request).execute()
        val html = response.body()!!.string()
        return mv(id, html)
    }

    override fun getImgUrl(id: String, quality: String): String = ""

    private fun mv(id: String, html: String): String {
        val jsonStr = html.substring(0, html.length - 1)
                .replace("QZOutputJson=", "")
        val tencentMvData = JSON.parseObject(jsonStr, TencentMvData::class.java)
        val fi = tencentMvData.fl.fi
        val dic: MutableMap<String, Int> = HashMap()
        fi.forEach { dic[it.name] = it.id }
        val mvID: Int = when (fi.size) {
            4 -> dic["fhd"]!!
            3 -> dic["shd"]!!
            2 -> dic["hd"]!!
            else -> dic["sd"]!!
        }
        val vkey = getVkey(mvID, id)
        val fn = "$id.p" + (mvID - 10000) + ".1.mp4"
        return tencentMvData.vl.vi!![0].ul!!.ui!![0].url + fn + "?vkey=$vkey"
    }

    private fun getKey(guid: Long, mid: String): String {
        val url =
                "http://c.y.qq.com/base/fcgi-bin/fcg_music_express_mobile3.fcg?g_tk=0&" +
                        "loginUin=[uin]&hostUin=0&format=json&inCharset=utf8&outCharset=utf-8&notice=0&platform=yqq&" +
                        "needNewCode=0&cid=205361747&uin=1044154167&songmid=$mid&filename=M800$mid.mp3&" +
                        "guid=${guid}"
        //val url = "http://base.music.qq.com/fcgi-bin/fcg_musicexpress.fcg?guid=$guid&format=json&json=3"

        val request = Request.Builder().headers(vHeaders).url(url).build()
        val response: Response = httpClient.newCall(request).execute()
        if (!response.isSuccessful) return ""
        val html = response.body()!!.string()

        //val jsonStr = html.substring(html.indexOf("(") + 1, html.lastIndexOf(")"))
        val json = JSONObject.parseObject(html)
        return json.getJSONObject("data").getJSONArray("items").getJSONObject(0).getString("vkey")
    }

    private fun getVkey(id: Int, videoId: String): String {
        val fn = videoId + ".p" + (id - 10000) + ".1.mp4"
        val url = "http://vv.video.qq.com/getkey?format=$id&otype=json&vid=$videoId&platform=11&charge=1&filename=$fn"
        var html = httpTool.getJsonResultWithGet(url)
        if (html.isEmpty()) return ""
        html = html.substring(0, html.length - 1).replace("QZOutputJson=", "")
        val json = JSONObject.parseObject(html)
        return json.getString("key")
    }


}