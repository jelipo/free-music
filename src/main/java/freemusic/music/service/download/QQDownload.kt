package freemusic.music.service.download

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.qq.TencentMvData
import freemusic.tool.HttpTool
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap

@Service
class QQDownload : MusicDownload {

    @Autowired
    private val httpTool: HttpTool = HttpTool()

    @Autowired
    private val httpClient: OkHttpClient = OkHttpClient()

    override fun getDownloadUrl(id: String, quality: String): String {
        val nowTime = System.currentTimeMillis()
        val guid = Random(nowTime).nextLong()
        val key = getKey(nowTime, guid)
        return when (quality) {
            "s128" -> "http://ws.stream.qqmusic.qq.com/M500$id.mp3?vkey=$key&guid=$guid&fromtag=0"
            "sogg" -> "http://ws.stream.qqmusic.qq.com/O600$id.ogg?vkey=$key&guid=$guid&fromtag=50"
            "s320" -> "http://ws.stream.qqmusic.qq.com/M800$id.mp3?vkey=$key&guid=$guid&fromtag=50"
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
        val jsonStr = html.substring(0, html.length - 1).replace("QZOutputJson=", "")
        val tencentMvData = JSON.parseObject(jsonStr, TencentMvData::class.java)
        val fi = tencentMvData.fl.fi
        val dic: MutableMap<String, Int> = HashMap()
        fi.forEach { dic.put(it.name, it.id) }
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

    private fun getKey(nowTime: Long, guid: Long): String {
        val url = "http://base.music.qq.com/fcgi-bin/fcg_musicexpress.fcg?json=3&guid=" + guid
        val html = httpTool.getJsonResultWithGet(url)
        val jsonStr = html.substring(html.indexOf("(") + 1, html.lastIndexOf(")"))
        val json = JSONObject.parseObject(jsonStr)
        return json.getString("key")
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