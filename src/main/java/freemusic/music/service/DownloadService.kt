package freemusic.music.service

import freemusic.music.service.download.KgDownload
import freemusic.music.service.download.MusicDownload
import freemusic.music.service.download.QQDownload
import freemusic.music.service.download.WyDownload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DownloadService {

    fun getDownloadUrl(type: String, quality: String, id: String): String {
        val musicDownload = getService(type)
        return musicDownload.getDownloadUrl(id, quality)
    }

    fun getMvUrl(type: String, quality: String, id: String): String {
        val musicDownload = getService(type)
        return musicDownload.getMvUrl(id, quality)
    }


    private fun getService(type: String): MusicDownload {
        return when (type) {
            "1" -> qqDownload
            "2" -> wyDownload
            "3" -> kgDownload
            else -> qqDownload
        }
    }

    @Autowired
    private val qqDownload: QQDownload = QQDownload()

    @Autowired
    private val kgDownload: KgDownload = KgDownload()

    @Autowired
    private val wyDownload: WyDownload = WyDownload()
}