package freemusic.music.service

import freemusic.music.pojo.MainFormPojo
import freemusic.music.service.real.KgService
import freemusic.music.service.real.MusicServices
import freemusic.music.service.real.QQService
import freemusic.music.service.real.WyService
import freemusic.util.PackingResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetJsonService{

    fun getFormatJson(mainFormPojo: MainFormPojo): Map<*, *> {
        val musicService = getService(mainFormPojo.type)
        val array = musicService!!.getFormatJson(mainFormPojo)
        return PackingResult.toSuccessMap(array)
    }

    fun getPristineJson(mainFormPojo: MainFormPojo): String {
        val musicService = getService(mainFormPojo.type)
        return musicService!!.getSearchResult(mainFormPojo)
    }

    private fun getService(type: String): MusicServices? {
        var musicService: MusicServices? = null
        when (type) {
            "1" -> musicService = this.qqService
            "2" -> musicService = this.wyService
            "3" -> musicService = this.kgService
        }
        return musicService
    }

    @Autowired
    private val qqService: QQService? = null

    @Autowired
    private val kgService: KgService? = null

    @Autowired
    private val wyService: WyService? = null
}