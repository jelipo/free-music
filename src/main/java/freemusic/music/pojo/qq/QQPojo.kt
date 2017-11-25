package freemusic.music.pojo.qq

data class QQPojo(
        var size128: Int = 0,
        var size320: Int = 0,
        var sizeape: Int = 0,
        var sizeflac: Int = 0,
        var sizeogg: Int = 0,
        var songid: Int = 0,
        var singer: List<Singer> = ArrayList(),
        var songmid: String = "",
        var songname: String = "",
        var songname_hilight: String = "",
        var vid: String = "",
        var strMediaMid: String = "",
        var albumname: String? = ""
)