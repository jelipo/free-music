package freemusic.music.service.download

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.wy.NeteaseLostSong
import freemusic.music.service.real.NetUtil
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.security.MessageDigest
import java.util.*
import kotlin.experimental.xor

@Service
class WyDownload : MusicDownloadService {

    @Autowired
    private val httpClient: OkHttpClient? = null

    override fun getDownloadUrl(id: String, quality: String): String {
        val realQuality = "320000"
        val text = "{\"ids\":[\"$id\"],\"br\":$realQuality,\"csrf_token\":\"\"}"
        val html: String = NetUtil.getEncHtml("http://music.163.com/weapi/song/enhance/player/url?csrf_token=", text, true)
        val json = JSON.parseObject(html)
        return if (json.getJSONArray("data").getJSONObject(0).getInteger("code") == 200) {
            json.getJSONArray("data").getJSONObject(0).getString("url")
        } else {
            getLostPlayUrl(id, realQuality)
        }
    }

    override fun getMvUrl(id: String, quality: String): String {
        val sendUrl = "http://music.163.com/api/song/mv?id=$id&type=mp4"
        val request = Request.Builder().url(sendUrl)
                .addHeader("Cookie", "__remember_me=true; MUSIC_U=5f9d910d66cb2440037d1c68e6972ebb9f15308b56bfeaa4545d34fbabf71e0f36b9357ab7f474595690d369e01fbb9741049cea1c6bb9b6; __csrf=8ea789fbbf78b50e6b64b5ebbb786176; os=uwp; osver=10.0.10586.318; appver=1.2.1; deviceId=0e4f13d2d2ccbbf31806327bd4724043")
                .build()
        val response = httpClient!!.newCall(request).execute()
        val html = response!!.body()!!.string()
        val json = JSONObject.parseObject(html)
        val array = json.getJSONArray("mvs")
        val map = HashMap<Int, JSONObject>()
        val arraySize = array.size
        val arr = IntArray(arraySize)
        for (i in 0 until arraySize) {
            val single = array.getJSONObject(i)
            arr[i] = single.getInteger("br")!!
            map[arr[i]] = single
        }
        Arrays.sort(arr)
        val bigJson = map[arr[arraySize - 1]]
        return bigJson!!.getString("mvurl")
    }

    override fun getImgUrl(id: String, quality: String): String = ""

    fun getLostPlayUrl(id: String, quality: String): String {
        val albumId = getLostAlbumId(id)
        try {
            val s = NetUtil.getHtmlContent("http://music.163.com/api/album/$albumId", true)
            val lostsong: NeteaseLostSong = JSON.parseObject(s, NeteaseLostSong::class.java)
            val songs = lostsong.album!!.songs!!
            for (song: NeteaseLostSong.AlbumBeanX.SongsBean in songs) {
                if (song.id == Integer.parseInt(id)) {
                    val dfsId: String
                    when (quality) {
                        "320000" -> {
                            dfsId = if (song.hMusic == null) {
                                if (song.mMusic == null) {
                                    return song.mp3Url!!
                                }
                                song.mMusic!!.dfsId.toString()
                            } else {
                                song.mMusic!!.dfsId.toString()
                            }
                            return getUrlBySid(dfsId)
                        }
                        "192000" ->
                            return if (song.mMusic == null) {
                                song.mMusic!!
                            } else {
                                dfsId = song.mMusic!!.dfsId.toString()
                                getUrlBySid(dfsId)
                            }
                        else -> return song.mp3Url!!
                    }
                }
            }
            return ""
        } catch (e: Exception) {
            return ""
        }

    }

    private fun getLostAlbumId(id: String): String? {
        val text = "[{\"id\":\"$id\"}]"
        val map = mapOf("c" to text)
        val s = NetUtil.postData("http://music.163.com/api/v3/song/detail", map)
        val albumId = JSON.parseObject(s).getJSONArray("songs").getJSONObject(0).getJSONObject("al").getInteger("id")!!
        return albumId.toString()
    }

    private fun getUrlBySid(dfsId: String): String {
        val encryptPath = getEncryptId(dfsId)
        return "http://m2.music.126.net/$encryptPath/$dfsId.mp3"
    }

    private fun getEncryptId(id: String): String {
        val byte1 = "3go8&$8*3*3h0k(2)2".toByteArray()
        val byte2 = id.toByteArray()
        val byte1Length = byte1.size
        for (i in byte2.indices) {
            val tmp = byte1[i % byte1Length]
            byte2[i] = (byte2[i] xor tmp)
        }
        val md5: MessageDigest = MessageDigest.getInstance("MD5")
        val md5Bytes = md5.digest(byte2)
        var retval = String(Base64.getDecoder().decode(md5Bytes))
        retval = retval.replace('/', '_')
        retval = retval.replace('+', '-')
        return retval
    }
}