package freemusic.music.ctrl;

import freemusic.music.pojo.MainFormPojo;
import freemusic.music.service.FormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class WebCtrlJava {

    @Autowired
    private FormatService formatService;

    @GetMapping("/MainSearch.do")
    public String mainSearch(@ModelAttribute("MainFormPojo") MainFormPojo form, RedirectAttributes redirect) {
        redirect.addAttribute("keyword", form.getKeyword());
        redirect.addAttribute("type", form.getType());
        redirect.addAttribute("page", form.getPage());
        return "redirect:search.do";
    }

    @GetMapping("/search.do")
    public ModelAndView search(@ModelAttribute("MainFormPojo") MainFormPojo form) {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("type", form.getType());
        modelAndView.addObject("keyword", form.getKeyword());
        modelAndView.addObject("page", form.getPage());
        ArrayList<?> formatArray = formatService.getFormatArray(form);
        modelAndView.addObject("datas", formatArray);
        return modelAndView;
    }

    @GetMapping("/searchPart.do")
    public ModelAndView part(@ModelAttribute("MainFormPojo") MainFormPojo form) {
        ModelAndView modelAndView = new ModelAndView("fragment::singleItem");
        modelAndView.addObject("type", form.getType());
        modelAndView.addObject("page", form.getPage());
        ArrayList<?> formatArray = formatService.getFormatArray(form);
        modelAndView.addObject("datas", formatArray);
        return modelAndView;
    }
}
