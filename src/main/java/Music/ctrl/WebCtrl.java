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

	@RequestMapping({ "/" })
	public String index(HttpServletRequest request) {
		String ua = request.getHeader("User-Agent");
		int isMobile=0;
		String[] list={"Mobile","mobile","Phone","Android","phone","android"};
		for(int i=0;i<list.length;i++){
			if(ua.contains(list[i])){
				isMobile=1;
				break;
			}
		}
		if (isMobile==0) {
			return "index";
		}else{
			return "wap/wapindex";
		}
		
	}
	@RequestMapping({ "/MainSearch" })
	public String MainSearch(@ModelAttribute("MainFormPojo") MainFormPojo form, RedirectAttributes redirect) {
		redirect.addAttribute("keyword", form.getKeyword());
		redirect.addAttribute("musictype", form.getMusictype());
		redirect.addAttribute("page", form.getPage());
		return "redirect:search";
	}

	@RequestMapping({ "/search" })
	public String searear(@ModelAttribute("MainFormPojo") MainFormPojo form, Model model)throws Exception {
		model.addAttribute("musictype", form.getMusictype());
		model.addAttribute("keyword",form.getKeyword());
		model.addAttribute("page",form.getPage());
		return "search";
	}
	
	
	@RequestMapping({ "/wap/" })
	public String index1(HttpServletRequest request) {
		return "wapindex";
	}

	@RequestMapping({ "/wap/MainSearch" })
	public String WapMainSearch(@ModelAttribute("IndexForm") MainFormPojo form, RedirectAttributes redirect) {
		redirect.addAttribute("keyword", form.getKeyword().replace(" ", "%20"));
		redirect.addAttribute("musictype", form.getMusictype());
		redirect.addAttribute("page", form.getPage());
		return "redirect:search";
	}

	@RequestMapping({ "/wap/search" })
	public String wapsearch(@ModelAttribute("IndexForm") MainFormPojo form, Model model)throws Exception {
		model.addAttribute("musictype", form.getMusictype());
		model.addAttribute("keyword",form.getKeyword());
		model.addAttribute("page",form.getPage());
		return "wap/wapsearch";
	}
	
}
