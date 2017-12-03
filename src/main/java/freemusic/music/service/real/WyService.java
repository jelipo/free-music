package freemusic.music.service.real;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemusic.music.pojo.MainFormPojo;
import freemusic.music.pojo.wy.Ar;
import freemusic.music.pojo.wy.Wy;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WyService implements MusicServices {

    @Value("${search.pagesize}")
    private int pagesize;

    @Override
    public ArrayList getFormatJson(@NotNull MainFormPojo form) {
        String searchResult = getSearchResult(form);
        JSONObject jsonResult = JSONObject.parseObject(searchResult).getJSONObject("result");
        if (jsonResult.getInteger("songCount") == 0) {
            return new ArrayList(0);
        }
        JSONArray jsonList = jsonResult.getJSONArray("songs");
        List<Wy> list = JSONArray.parseArray(jsonList.toJSONString(), Wy.class);
        ArrayList array = new ArrayList(list.size());
        for (Wy single : list) {
            JSONObject json = new JSONObject();
            json.put("name", single.getName());
            List<Ar> singerList = single.getAr();
            String singer = null;
            for (int a = 0; a < singerList.size(); a++) {
                singer = singerList.get(a).getName() + " ";
            }
            json.put("singer", singer);
            json.put("album", single.getAl().getName());
            json.put("s128", 0);
            json.put("sogg", 0);
            json.put("s320", single.getId());
            json.put("SQ", 0);
            int seconds = (single.getDt() / 1000) % 60;
            String secStr = seconds < 10 ? "0" + String.valueOf(seconds) : String.valueOf(seconds);
            json.put("time", (single.getDt() / 1000) / 60 + ":" + secStr);
            json.put("mv", single.getMv());
            array.add(json);
        }
        return array;
    }

    @Override
    public String getSearchResult(@NotNull MainFormPojo form) {
        String key = form.getKeyword();
        int page = Integer.valueOf(form.getPage());
        String text = "{\"s\":\"" + key + "\",\"type\":1,\"offset\":" + (page - 1) * pagesize + ",\"limit\":" + pagesize + ",\"total\":true}";
        String s = null;
        s = NetUtil.GetEncHtml("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=", text, true);
        return s;
    }

}
