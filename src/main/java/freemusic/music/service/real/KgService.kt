package freemusic.music.service.real

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.MainFormPojo
import freemusic.music.pojo.kg.Kg
import freemusic.tool.HttpTool
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.net.URLEncoder

@Service
class KgService : MusicServices {

    @Value("\${search.pagesize}")
    private lateinit var pagesize: String

    @Autowired
    private lateinit var httpClient: HttpTool

    override fun getFormatJson(mainFormPojo: MainFormPojo): ArrayList<*> {
        val pristineJson = getSearchResult(mainFormPojo)
        val list: JSONArray = JSONObject.parseObject(pristineJson).getJSONObject("data").getJSONArray("lists")
        val array = ArrayList<Any>()
        list.indices.map { JSON.parseObject(list[it].toString(), Kg::class.java) }.mapTo(array) { mapPackage(it) }
        return array
    }

    fun mapPackage(single: Kg): HashMap<String, *> {
        val hashMap = HashMap<String, Any>()
        hashMap["name"] = replaceEm(single.songName)
        hashMap["singer"] = replaceEm(single.singerName)
        hashMap["album"] = replaceEm(single.albumName)
        hashMap["s128"] = if (single.fileHash.replace("0", "") == "") "" else single.fileHash
        hashMap["s320"] = if (single.hqFileHash.replace("0", "") == "") "" else single.fileHash
        hashMap["sogg"] = ""
        hashMap["SQ"] = if (single.sqFileHash.replace("0", "").isEmpty()) "" else single.sqFileHash
        //把小于10的秒数前面加个“0”
        val duration = if (single.hqDuration == 0) single.duration else single.hqDuration
        val seconds = duration % 60
        val secStr = if (seconds < 10) "0" + seconds.toString() else seconds.toString()
        hashMap["time"] = Integer.toString(duration / 60) + ":" + secStr
        hashMap["mv"] = if (single.mvHash.isEmpty()) "" else single.mvHash
        return hashMap
    }

    fun replaceEm(text: String): String {
        return text.replace("<em>", "").replace("</em>", "")
    }

    override fun getSearchResult(mainFormPojo: MainFormPojo): String {
        val keyword: String = URLEncoder.encode(mainFormPojo.keyword, "utf-8")
        val url = "http://songsearch.kugou.com/song_search_v2?" +
                "keyword=$keyword&page=${mainFormPojo.page}&pagesize=$pagesize&filter=0&bitrate=0&isfuzzy=0&" +
                "tag=em&inputtype=2&platform=PcFilter&userid=&clientver=8060&iscorrection=3"
        return httpClient.getJsonResultWithGet(url)
    }
}