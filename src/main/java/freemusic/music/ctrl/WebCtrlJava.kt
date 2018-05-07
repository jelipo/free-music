package freemusic.music.ctrl

import freemusic.music.pojo.MainFormPojo
import freemusic.music.service.FormatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class WebCtrlJava {
    @Autowired
    private val formatService: FormatService? = null

    @GetMapping("/MainSearch.do")
    fun mainSearch(@ModelAttribute("MainFormPojo") form: MainFormPojo, redirect: RedirectAttributes): String {
        redirect.addAttribute("keyword", form.keyword)
        redirect.addAttribute("type", form.type)
        redirect.addAttribute("page", form.page)
        return "redirect:search.do"
    }

    @GetMapping("/search.do")
    fun search(@ModelAttribute("MainFormPojo") form: MainFormPojo): ModelAndView {
        val modelAndView = ModelAndView("search")
        modelAndView.addObject("type", form.type)
        modelAndView.addObject("keyword", form.keyword)
        modelAndView.addObject("page", form.page)
        val formatArray = formatService!!.getFormatArray(form)
        modelAndView.addObject("datas", formatArray)
        return modelAndView
    }

    @GetMapping("/searchPart.do")
    fun part(@ModelAttribute("MainFormPojo") form: MainFormPojo): ModelAndView {
        val modelAndView = ModelAndView("fragment::singleItem")
        modelAndView.addObject("type", form.type)
        modelAndView.addObject("page", form.page)
        val formatArray = formatService!!.getFormatArray(form)
        modelAndView.addObject("datas", formatArray)
        return modelAndView
    }
}