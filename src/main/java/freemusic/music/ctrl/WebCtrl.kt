package freemusic.music.ctrl

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class WebCtrl {

    @GetMapping("/", "/index")
    fun index(): String = "index"
}