package music.ctrl;

import music.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadCtrl {

    @Autowired
    private DownloadService downloadService;

    @GetMapping("/downloadurl.do")
    public String downloadurl(@RequestParam String type, @RequestParam String id, @RequestParam String quality) {
        String url = downloadService.getDownloadUrl(type, quality, id);
        if (url.equals("")) {
            return "Sorry";
        }
        return "redirect:" + url;
    }

    @GetMapping("/getmvurl.do")
    public String getMv(@RequestParam String type, @RequestParam String id, @RequestParam String quality) {
        String url = downloadService.getMvUrl(type, quality, id);
        if (url.equals("")) {
            return "Sorry";
        }
        return "redirect:" + url;
    }
}
