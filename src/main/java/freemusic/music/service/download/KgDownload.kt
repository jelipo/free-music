package freemusic.music.service.download

import com.alibaba.fastjson.JSONObject
import freemusic.tool.HttpTool
import org.apache.commons.codec.digest.DigestUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KgDownload : MusicDownload {

    @Autowired
    private var httpTool: HttpTool = HttpTool()

    override fun getDownloadUrl(id: String, quality: String): String {
        val key = DigestUtils.md5Hex(id + "kgcloud")
        val url = "http://trackercdn.kugou.com/i/?key=$key&cmd=4&acceptMp3=1&hash=$id&pid=1"
        val result = httpTool!!.getJsonResultWithGet(url)
        if (result.contains("Bad key") || result.contains("The Resource Needs to be Paid")) return ""
        val json = JSONObject.parseObject(result)
        return json.getString("url")
    }

    override fun getMvUrl(id: String, quality: String): String {
        val key = DigestUtils.md5Hex(id + "kugoumvcloud")
        val result = httpTool!!.getJsonResultWithGet("http://trackermv.kugou.com/interface/index?cmd=100&pid=6&ext=mp4&hash=$id&quality=-1&key=$key&backupdomain=1")
        if (result.contains("Bad key") || result.contains("The Resource Needs to be Paid")) return ""
        val mvData = JSONObject.parseObject(result).getJSONObject("mvdata")
        return getMvUrl(mvData)
    }

    override fun getImgUrl(id: String, quality: String): String = ""

    private fun getMvUrl(mvData: JSONObject): String {
        val sq = mvData.getJSONObject("sq").getString("downurl")
        val hd = mvData.getJSONObject("hd").getString("downurl")
        val sd = mvData.getJSONObject("sd").getString("downurl")
        val le = mvData.getJSONObject("le").getString("downurl")
        return when {
            mvData.getJSONObject("sq").getString("downurl") != null -> sq
            mvData.getJSONObject("hd").getString("downurl") != null -> hd
            mvData.getJSONObject("sd").getString("downurl") != null -> sd
            mvData.getJSONObject("le").getString("downurl") != null -> le
            else -> ""
        }
    }
}