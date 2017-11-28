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
import java.io.UnsupportedEncodingException
import java.net.URLEncoder

@Service
class KgService : MusicServices {

    @Value("\${search.pagesize}")
    private val pagesize: String? = null

    @Autowired
    private val httpClient: HttpTool? = null

    override fun getFormatJson(mainFormPojo: MainFormPojo): ArrayList<*> {
        val pristineJson = getSearchResult(mainFormPojo)
        val list: JSONArray = JSONObject.parseObject(pristineJson).getJSONObject("data").getJSONArray("lists")
        val array = ArrayList<HashMap<String, Any>>()
        for (i in list.indices) {
            val single: Kg = JSON.parseObject(list[i].toString(), Kg::class.java)
            var hashMap = HashMap<String, Any>()
            hashMap.put("name", replaceEm(single.songName))
            hashMap.put("singer", replaceEm(single.singerName))
            hashMap.put("album", replaceEm(single.albumName))
            hashMap.put("s128", if (single.fileHash.replace("0", "") == "") 0 else single.fileHash)
            hashMap.put("s320", if (single.hqFileHash.replace("0", "") == "") 0 else single.fileHash)
            hashMap.put("sogg", 0)
            hashMap.put("SQ", single.sqFileHash)
            //把小于10的秒数前面加个“0”
            val seconds = single.hqDuration % 60
            val secStr = if (seconds < 10) "0" + seconds.toString() else seconds.toString()
            hashMap.put("time", Integer.toString(single.hqDuration / 60) + ":" + secStr)
            hashMap.put("mv", single.mvHash)
            array.add(hashMap)
        }
        return array
    }

    fun replaceEm(text: String): String {
        return text.replace("<em>", "").replace("</em>", "")
    }

    override fun getSearchResult(mainFormPojo: MainFormPojo): String {
        var keyword: String? = null
        try {
            keyword = URLEncoder.encode(mainFormPojo.keyword, "utf-8")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }

        val url = ("http://songsearch.kugou.com/song_search_v2?"
                + "keyword=$keyword&page=${mainFormPojo.page}&pagesize=$pagesize&filter=0&bitrate=0&isfuzzy=0&"
                + "tag=em&inputtype=2&platform=PcFilter&userid=&clientver=8060&iscorrection=3")
        return httpClient!!.getJsonResultWithGet(url)
    }
    


}