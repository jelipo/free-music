package freemusic.music.service

import freemusic.music.pojo.MainFormPojo
import freemusic.music.service.real.KgService
import freemusic.music.service.real.MusicServices
import freemusic.music.service.real.QQService
import freemusic.music.service.real.WyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FormatService {

    fun getFormatArray(mainFormPojo: MainFormPojo): ArrayList<*> {
        val musicService = getService(mainFormPojo.type)
        return musicService.getFormatJson(mainFormPojo)
    }

    fun getPristineJson(mainFormPojo: MainFormPojo): String {
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
    private val qqService: QQService = QQService()

    @Autowired
    private val kgService: KgService = KgService()

    @Autowired
    private val wyService: WyService = WyService()
}