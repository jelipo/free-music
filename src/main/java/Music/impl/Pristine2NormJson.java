package Music.impl;

import com.alibaba.fastjson.JSONObject;

import Music.pojo.MainFormPojo;

public interface Pristine2NormJson {
	public JSONObject getNormJson(JSONObject pristion, MainFormPojo form);
}
