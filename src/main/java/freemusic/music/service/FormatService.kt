package freemusic.music.service

import freemusic.music.pojo.SearchParams
import freemusic.music.service.real.KgService
import freemusic.music.service.real.MusicServices
import freemusic.music.service.real.QQService
import freemusic.music.service.real.WyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormatService {

    fun getFormatArray(mainFormPojo: SearchParams): ArrayList<*> {
        val musicService = getService(mainFormPojo.type)
        return musicService.getFormatJson(mainFormPojo)
    }

    fun getPristineJson(mainFormPojo: SearchParams): String {
        val musicService = getService(mainFormPojo.type)
        return musicService.getSearchResult(mainFormPojo)
    }

    private fun getService(type: String): MusicServices {
        return when (type) {
            "1" -> qqService
            "2" -> wyService
            "3" -> kgService
            else -> qqService
        }
    }

    @Autowired
    private lateinit var qqService: QQService

    @Autowired
    private lateinit var kgService: KgService

    @Autowired
    private lateinit var wyService: WyService
}