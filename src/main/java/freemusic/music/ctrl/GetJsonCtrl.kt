package freemusic.music.ctrl

import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.SearchParams
import freemusic.music.service.FormatService
import freemusic.util.PackingResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class GetJsonCtrl {

    @Autowired
    lateinit var formatService: FormatService

    @GetMapping("/searchjson.do")
    fun getJson(@ModelAttribute("SearchParams") form: SearchParams): Map<*, *> =
            PackingResult.toSuccessMap(formatService.getFormatArray(form))

    @GetMapping("/getPristineJson.do")
    fun getPristineJson(@ModelAttribute("SearchParams") form: SearchParams): JSONObject {
        val json: String = formatService.getPristineJson(form)
        return JSONObject.parseObject(json)
    }
}