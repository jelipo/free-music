package Music.ctrl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Music.pojo.MainFormPojo;
@Controller
public class WebCtrl {


	@RequestMapping({ "/MainSearch.do" })
	public String MainSearch(@ModelAttribute("MainFormPojo") MainFormPojo form, RedirectAttributes redirect) {
		redirect.addAttribute("keyword", form.getKeyword());
		redirect.addAttribute("type", form.getType());
		redirect.addAttribute("page", form.getPage());
		return "redirect:search.do";
	}

	@RequestMapping({ "/search.do" })
	public String searear(@ModelAttribute("MainFormPojo") MainFormPojo form, Model model)throws Exception {
		model.addAttribute("type", form.getType());
		model.addAttribute("keyword",form.getKeyword());
		model.addAttribute("page",form.getPage());
		return "search";
	}
	
	
	@RequestMapping({ "/wap/" })
	public String index1(HttpServletRequest request) {
		return "wapindex";
	}

	@RequestMapping({ "/wap/MainSearch.do" })
	public String WapMainSearch(@ModelAttribute("IndexForm") MainFormPojo form, RedirectAttributes redirect) {
		redirect.addAttribute("keyword", form.getKeyword().replace(" ", "%20"));
		redirect.addAttribute("type", form.getType());
		redirect.addAttribute("page", form.getPage());
		return "redirect:search.do";
	}

	@RequestMapping({ "/wap/search.do" })
	public String wapsearch(@ModelAttribute("IndexForm") MainFormPojo form, Model model)throws Exception {
		model.addAttribute("type", form.getType());
		model.addAttribute("keyword",form.getKeyword());
		model.addAttribute("page",form.getPage());
		return "wap/wapsearch";
	}
	
}
