package freemusic.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackingResult {

    public static Map toSuccessMap(List list) {
        Map result = new HashMap();
        result.put("resultCode", 200);
        result.put("data", list);
        return result;
    }

    public static Map toSuccessMap(Map map) {
        Map result = new HashMap();
        result.put("resultCode", 200);
        result.put("data", map);
        return result;
    }

    public static Map toSuccessMap(JSONObject json) {
        Map result = new HashMap();
        result.put("resultCode", 200);
        result.put("data", json);
        return result;
    }

    public static Map toSuccessMap() {
        Map result = new HashMap();
        result.put("resultCode", 200);
        return result;
    }

    public static Map toSuccessMap(JSONArray jsonArray) {
        Map result = new HashMap();
        result.put("resultCode", 200);
        result.put("data", jsonArray);
        return result;
    }

    public static Map toWorngMap(String detailed) {
        Map result = new HashMap();
        result.put("resultCode", 500);
        result.put("wrong", detailed);
        return result;
    }


}
