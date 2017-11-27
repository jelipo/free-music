package freemusic.music.pojo.wy

import com.alibaba.fastjson.annotation.JSONField

data class Wy(
        var ar: List<Ar>? = null,
        var al: Al? = null,
        var l: L? = null, var cp: Int = 0,
        var mv: Int = 0,
        var cf: String? = null,
        var dt: Int = 0,
        var h: H? = null,
        var m: M? = null,
        var name: String? = null,
        var id: Int = 0,
        var privilege: Privilege? = null
)