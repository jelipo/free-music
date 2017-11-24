package freemusic.music.ctrl

import freemusic.music.pojo.MainFormPojo
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class WebCtrl {

    @GetMapping("/MainSearch.do")
    fun mainSearch(@ModelAttribute("MainFormPojo") form: MainFormPojo, redirect: RedirectAttributes): String {
        redirect.addAttribute("keyword", form.keyword)
        redirect.addAttribute("type", form.type)
        redirect.addAttribute("page", form.page)
        return "redirect:search.do"
    }

    @GetMapping("/search.do")
    fun searear(@ModelAttribute("MainFormPojo") form: MainFormPojo, model: Model): String {
        model.addAttribute("type", form.type)
        model.addAttribute("keyword", form.keyword)
        model.addAttribute("page", form.page)
        return "search"
    }
}