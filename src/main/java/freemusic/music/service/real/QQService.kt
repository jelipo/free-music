package freemusic.music.service.real

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.MainFormPojo
import freemusic.music.pojo.kg.Kg
import freemusic.music.pojo.qq.QQPojo
import freemusic.music.pojo.qq.Singer
import freemusic.tool.HttpTool
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.util.ArrayList

class QQService : MusicServices {

    @Value("\${search.pagesize}")
    private val pagesize: String? = null

    @Autowired
    private val httpTool: HttpTool? = null

    override fun getFormatJson(mainFormPojo: MainFormPojo): ArrayList<*> {
        val pristineJson = getSearchResult(mainFormPojo)
        val jsonList = JSON.parseObject(pristineJson).getJSONObject("data").getJSONObject("song").getJSONArray("list")
        val list = jsonList.toJavaList(QQPojo::class.java)
        val array = ArrayList<Any>()
        for (i in list.indices) {
            val map = HashMap<String, Any>()
            val single: QQPojo = JSON.parseObject(list[i].toString(), QQPojo::class.java)
            val singerList = single.singer
            val singer = StringBuilder()
            for (aSingerList: Singer in singerList) {
                singer.append(aSingerList.name).append(" ")
            }
            map.put("singer", singer)
            map.put("name", single.songname)
            map.put("album", single.albumname)
            map.put("s128", if (single.size128 == 0) 0 else single.songmid)
            map.put("s320", if (single.size320 == 0) 0 else single.songmid)
            map.put("sogg", if (single.sizeogg == 0) 0 else single.songmid)
            map.put("SQ", 0)
            //把小于10的秒数前面加个“0”
            val seconds = single.interval % 60
            val secStr = if (seconds < 10) "0" + seconds.toString() else seconds.toString()
            map.put("time", (single.interval / 60).toString() + ":" + secStr)
            map.put("mv", if (single.vid.equals("")) 0 else single.vid)
            array.add(map)
        }
        return array
    }

    override fun getSearchResult(mainFormPojo: MainFormPojo): String {
        var keyword: String? = null
        try {
            keyword = URLEncoder.encode(mainFormPojo.keyword, "utf-8")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        val url = ("http://soso.music.qq.com/fcgi-bin/search_cp?aggr=0&catZhida=0&lossless=1&sem=1&w=$keyword&n=$pagesize" +
                "&t=0&p=${mainFormPojo.page}&remoteplace=sizer.yqqlist.song&g_tk=5381&loginUin=0&hostUin=0&format=jsonp" +
                "&inCharset=GB2312&outCharset=utf-8&notice=0&platform=yqq&needNewCode=0")
        var result = this.httpTool!!.getJsonResultWithGet(url)
        result = result.substring(result.indexOf("(") + 1, result.lastIndexOf(")"))
        return result
    }

}