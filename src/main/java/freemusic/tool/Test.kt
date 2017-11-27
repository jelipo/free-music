package freemusic.tool

import com.alibaba.fastjson.annotation.JSONField

data class Test(
        @JSONField(name = "Name")
        var name: String = ""
)