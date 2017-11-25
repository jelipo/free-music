package freemusic.music.ctrl

import com.alibaba.fastjson.JSONObject
import freemusic.music.pojo.MainFormPojo

import freemusic.music.service.GetJsonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RestController

@RestController
class GetJsonCtrl {

    @Autowired
    lateinit var getJsonService: GetJsonService

    @GetMapping("/searchjson.do")
    fun getJson(@ModelAttribute("MainFormPojo") form: MainFormPojo): MutableMap<Any?, Any?>? =
            getJsonService.getFormatJson(form)


    @GetMapping("/getPristineJson.do")
    fun getPristineJson(@ModelAttribute("MainFormPojo") form: MainFormPojo): JSONObject {
        val json: String = getJsonService.getPristineJson(form)
        return JSONObject.parseObject(json)
    }
}

