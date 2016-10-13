package Music.ctrl;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import Music.impl.HtmlList;
import Music.impl.Pristine2NormJson;
import Music.pojo.MainFormPojo;

@Controller
public class GetJsonCtrl {
	
	@Resource(name="Music/HtmlList")
	private HtmlList htmllist;
	@Resource(name="Music/Pristine2Norm")
	private Pristine2NormJson pristine2NormJson;
	
	@ResponseBody
	@RequestMapping({ "/searchjson" })
	public JSONObject getJson(@ModelAttribute("MainFormPojo") MainFormPojo form){
		JSONObject pristineJson=htmllist.getPristineJson(form);
		System.out.println(pristineJson);
		JSONObject normJson=pristine2NormJson.getNormJson(pristineJson, form);
		return normJson;
	}
	@ResponseBody
	@RequestMapping({ "/getPristineJson" })
	public JSONObject getPristineJson(@ModelAttribute("MainFormPojo") MainFormPojo form){
		JSONObject pristineJson=htmllist.getPristineJson(form);
		return pristineJson;
	}
}
