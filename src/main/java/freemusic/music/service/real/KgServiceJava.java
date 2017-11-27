package freemusic.music.service.real;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import freemusic.music.pojo.MainFormPojo;
import freemusic.music.pojo.kg.Kg;
import freemusic.tool.HttpTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class KgServiceJava implements MusicServices {

    @Value("${search.pagesize}")
    private String pagesize;

    @Autowired
    private HttpTool httpClient;


    @Override
    public ArrayList getFormatJson(MainFormPojo form) {
        String pristineJson = getSearchResult(form);
        JSONArray list = JSONObject.parseObject(pristineJson).getJSONObject("data").getJSONArray("lists");
        ArrayList array = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            JSONObject json = new JSONObject();
            Kg single = list.getJSONObject(i).toJavaObject(Kg.class);
            json.put("name", single.getSongName().replace("<em>", "").replace("</em>", ""));
            json.put("singer", single.getSingerName().replace("<em>", "").replace("</em>", ""));
            json.put("album", single.getAlbumName().replace("<em>", "").replace("</em>", ""));
            json.put("s128", single.getFileHash().replace("0", "").equals("") ? 0 : single.getFileHash());
            json.put("s320", single.getHqFileHash().replace("0", "").equals("") ? 0 : single.getFileHash());
            json.put("sogg", 0);
            json.put("SQ", single.getSqFileHash());
            //把小于10的秒数前面加个“0”
            int seconds = single.getHqDuration() % 60;
            String secStr = seconds < 10 ? "0" + String.valueOf(seconds) : String.valueOf(seconds);
            json.put("time", Integer.toString(single.getHqDuration() / 60) + ":" + secStr);
            json.put("mv", single.getMvHash());
            array.add(json);
        }
        return array;

    }

    @Override
    public String getSearchResult(MainFormPojo form) {
        String keyword = null;
        try {
            keyword = URLEncoder.encode(form.getKeyword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://songsearch.kugou.com/song_search_v2?"
                + "keyword=" + keyword + "&page=" + form.getPage() + "&pagesize=" + pagesize + "&filter=0&bitrate=0&isfuzzy=0&"
                + "tag=em&inputtype=2&platform=PcFilter&userid=&clientver=8060&iscorrection=3";
        return httpClient.getJsonResultWithGet(url);
    }
}
