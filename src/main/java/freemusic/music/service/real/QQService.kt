package freemusic.music.service.real

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONArray
import freemusic.music.pojo.SearchParams
import freemusic.music.pojo.qq.QQPojo
import freemusic.music.pojo.qq.Singer
import freemusic.tool.HttpTool
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.net.URLEncoder
import java.util.ArrayList
import kotlin.collections.HashMap

@Service
class QQService : MusicServices {

    @Value("\${search.pagesize}")
    private lateinit var pagesize: String

    @Autowired
    private lateinit var httpTool: HttpTool

    override fun getFormatJson(mainFormPojo: SearchParams): ArrayList<*> {
        val pristineJson = getSearchResult(mainFormPojo)
        val jsonList: JSONArray = JSON.parseObject(pristineJson).getJSONObject("data").getJSONObject("song").getJSONArray("list")
        val array = ArrayList<HashMap<String, Any>>()
        jsonList.forEach {
            val map = HashMap<String, Any>()
            val single: QQPojo = JSON.parseObject(it.toString(), QQPojo::class.java)
            val singerList = single.singer
            val singer = StringBuilder()
            for (aSingerList: Singer in singerList) singer.append(aSingerList.name).append(" ")
            map["singer"] = singer
            map["name"] = single.songname
            map["album"] = single.albumname
            map["s128"] = if (single.size128 == 0) "" else single.songmid
            map["s320"] = if (single.size320 == 0) "" else single.songmid
            map["sogg"] = if (single.sizeogg == 0) "" else single.songmid
            map["SQ"] = ""
            //把小于10的秒数前面加个“0”
            val seconds = single.interval % 60
            val secStr = if (seconds < 10) "0" + seconds.toString() else seconds.toString()
            map["time"] = (single.interval / 60).toString() + ":" + secStr
            map["mv"] = if (single.vid == "") "" else single.vid
            array.add(map)
        }
        return array
    }

    override fun getSearchResult(mainFormPojo: SearchParams): String {
        val keyword: String = URLEncoder.encode(mainFormPojo.keyword, "utf-8")
        val url = "https://c.y.qq.com/soso/fcgi-bin/client_search_cp?p=${mainFormPojo.page}&n=$pagesize&w=$keyword"
        //val url = "http://soso.music.qq.com/fcgi-bin/search_cp?aggr=0&catZhida=0&lossless=1&sem=1&w=$keyword&n=$pagesize&t=0&p=${mainFormPojo.page}&remoteplace=sizer.yqqlist.song&g_tk=5381&loginUin=0&hostUin=0&format=jsonp&inCharset=GB2312&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0"
        var result = this.httpTool.getJsonResultWithGet(url)
        result = result.substring(result.indexOf("(") + 1, result.lastIndexOf(")"))
        return result
    }
}