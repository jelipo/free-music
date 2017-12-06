package freemusic.music.service.real

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.MainFormPojo
import freemusic.music.pojo.wy.Ar
import freemusic.music.pojo.wy.Wy
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.ArrayList
import kotlin.collections.HashMap

@Service
class WyService : MusicServices {

    @Value("\${search.pagesize}")
    private val pageSize: Int = 0

    override fun getFormatJson(mainFormPojo: MainFormPojo): ArrayList<*> {
        val searchResult = getSearchResult(mainFormPojo)
        val jsonResult = JSONObject.parseObject(searchResult).getJSONObject("result")
        if (jsonResult.getInteger("songCount") == 0) {
            return ArrayList<Any>()
        }
        val jsonList = jsonResult.getJSONArray("songs")
        val array = ArrayList<Any>()
        for (i in jsonList.indices) {
            val single = JSON.parseObject(jsonList[i].toString(), Wy::class.java)
            val map = HashMap<String, Any>()
            map.put("name", single.name!!)
            map.put("singer",getSingers(single.ar!!))
            map.put("album", single.al!!.name!!)
            map.put("s128", "")
            map.put("sogg", "")
            map.put("s320", single.id)
            map.put("SQ", "")
            val seconds = single.dt / 1000 % 60
            val secStr = if (seconds < 10) "0" + seconds.toString() else seconds.toString()
            map.put("time", (single.dt / 1000 / 60).toString() + ":" + secStr)
            map.put("mv", single.mv)
            array.add(map)
        }
        return array
    }

    override fun getSearchResult(mainFormPojo: MainFormPojo): String {
        val key = mainFormPojo.keyword
        val page = Integer.valueOf(mainFormPojo.page)
        val text = "{\"s\":\"$key\",\"type\":1,\"offset\":" + (page - 1) * pageSize + ",\"limit\":$pageSize,\"total\":true}"
        return NetUtil.GetEncHtml("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=", text, true)
    }

    private fun getSingers(singerList: List<Ar>): String {
        var singer = ""
        singerList.forEach {
            singer = it.name + " "
        }
        return singer
    }

}