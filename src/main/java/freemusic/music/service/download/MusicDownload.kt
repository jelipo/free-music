package freemusic.music.service.download

interface MusicDownload {
    fun getDownloadUrl(id: String, quality: String): String

    fun getMvUrl(id: String, quality: String): String

    fun getImgUrl(id: String, quality: String): String
}