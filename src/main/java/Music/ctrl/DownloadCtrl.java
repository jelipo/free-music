package Music.ctrl;

import Music.service.DownloadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class DownloadCtrl {
	
	@Resource(name="Music/DownloadService")
	private DownloadService downloadService;

	@RequestMapping("/downloadurl.do")
	private String downloadurl(@RequestParam String type,@RequestParam String id, @RequestParam String quality){
		String url=downloadService.getDownloadUrl(type,quality,id);
		if (url.equals("")){
			return "Sorry";
		}
		return "redirect:" + url;
	}
}
