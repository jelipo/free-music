package Music.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import Tool.Service.SendHttpGet;
import Tool.imp.SendHttp;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import Music.impl.Download;
import Music.pojo.DownloadPojo;

@Controller
public class DownloadCtrl {
	
	@Resource(name="Music/Download")
	private Download download;
	@RequestMapping("downloadurl")
	private String downloadurl(@ModelAttribute("DownloadPojo") DownloadPojo pojo,HttpServletRequest request){
		String url=download.getRealUrl(pojo);
		return "redirect:" + url;
	}
}
