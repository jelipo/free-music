package Music.ctrl;

import Music.pojo.MainFormPojo;
import Music.service.GetJsonService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

@Controller
public class GetJsonCtrl {

    @Resource(name = "Music/service/GetJsonService")
    private GetJsonService getJsonService;

    @ResponseBody
    @RequestMapping({"/searchjson.do"})
    public Map getJson(@ModelAttribute("MainFormPojo") MainFormPojo form) {
        Map result= getJsonService.getFormatJson(form);
        return result;
    }

    @ResponseBody
    @RequestMapping({"/getPristineJson.do"})
    public JSONObject getPristineJson(@ModelAttribute("MainFormPojo") MainFormPojo form) throws UnsupportedEncodingException {
        String json= getJsonService.getPristineJson(form);
        return JSONObject.parseObject(json);
    }
}
