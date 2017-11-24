package freemusic.music.ctrl;

import com.alibaba.fastjson.JSONObject;
import freemusic.music.pojo.MainFormPojo;
import freemusic.music.service.GetJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
public class GetJsonCtrl {

    @Autowired
    private GetJsonService getJsonService;

    @ResponseBody
    @GetMapping({"/searchjson.do"})
    public Map getJson(@ModelAttribute("MainFormPojo") MainFormPojo form) {
        Map result = getJsonService.getFormatJson(form);
        return result;
    }

    @ResponseBody
    @GetMapping({"/getPristineJson.do"})
    public JSONObject getPristineJson(@ModelAttribute("MainFormPojo") MainFormPojo form) throws UnsupportedEncodingException {
        String json = getJsonService.getPristineJson(form);
        return JSONObject.parseObject(json);
    }
}
