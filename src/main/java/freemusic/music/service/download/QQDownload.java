package freemusic.music.service.download;

import freemusic.music.pojo.qq.TencentMvData;
import freemusic.tool.HttpTool;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class QQDownload implements MusicDownload {
    @Autowired
    private HttpTool httpTool;

    @Autowired
    private OkHttpClient httpClient;

    @Override
    public String getDownloadUrl(String id, String quality) {
        long nowTime = System.currentTimeMillis();
        long guid = new Random(nowTime).nextLong();
        String key = getKey(nowTime, guid);
        String url = null;
        if (quality.equals("s128")) {
            url = "http://ws.stream.qqmusic.qq.com/M500" + id + ".mp3?vkey=" + key + "&guid=" + guid + "&fromtag=0";
        } else if (quality.equals("sogg")) {
            url = "http://ws.stream.qqmusic.qq.com/O600" + id + ".ogg?vkey=" + key + "&guid=" + guid + "&fromtag=50";
        } else if (quality.equals("s320")) {
            url = "http://ws.stream.qqmusic.qq.com/M800" + id + ".mp3?vkey=" + key + "&guid=" + guid + "&fromtag=50";
        }
        return url;
    }

    @Override
    public String getMvUrl(String id, String quality) {
        String sendUrl = "http://vv.video.qq.com/getinfo?vid=" + id + "&platform=11&charge=1&otype=json";
        Request request = new Request.Builder().url(sendUrl)
                .addHeader("Cookie", "__remember_me=true; MUSIC_U=5f9d910d66cb2440037d1c68e6972ebb9f15308b56bfeaa4545d34fbabf71e0f36b9357ab7f474595690d369e01fbb9741049cea1c6bb9b6; __csrf=8ea789fbbf78b50e6b64b5ebbb786176; os=uwp; osver=10.0.10586.318; appver=1.2.1; deviceId=0e4f13d2d2ccbbf31806327bd4724043")
                .build();
        try {
            Response response = httpClient.newCall(request).execute();
            String html = response.body().string();
            return mv(id, html);
        } catch (IOException e) {
            return "";
        }
    }

    private String mv(String id, String html) {
        html = html.substring(0, html.length() - 1).replace("QZOutputJson=", "");
        TencentMvData tencentMvData = JSON.parseObject(html, TencentMvData.class);
        if (tencentMvData.getFl() == null) {
            return "";
        }
        List<TencentMvData.FlBean.FiBean> fi = tencentMvData.getFl().getFi();
        HashMap<String, Integer> dic = new HashMap<>();
        int count = fi.size();
        for (TencentMvData.FlBean.FiBean fiBean : fi) {
            dic.put(fiBean.getName(), fiBean.getId());
        }
        int mvID;
        JSONObject json = JSONObject.parseObject(html);
        JSONArray array = json.getJSONObject("fl").getJSONArray("fi");
        switch (count) {
            case 4:
                mvID = dic.get("fhd");
                break;
            case 3:
                mvID = dic.get("shd");

                break;
            case 2:
                mvID = dic.get("hd");
                break;
            default:
                mvID = dic.get("sd");
                break;
        }
        String vkey = GetVkey(mvID, id);
        String fn = id + ".p" + (mvID - 10000) + ".1.mp4";
        return tencentMvData.getVl().getVi().get(0).getUl().getUi().get(0).getUrl() + fn + "?vkey=" + vkey;

    }

    @Override
    public String getImgUrl(String id, String quality) {
        return null;
    }

    private String getKey(long nowTime, long guid) {
        String url = "http://base.music.qq.com/fcgi-bin/fcg_musicexpress.fcg?json=3&guid=" + guid;
        String html = httpTool.getJsonResultWithGet(url);
        String jsonStr = html.substring(html.indexOf("(") + 1, html.lastIndexOf(")"));
        JSONObject json = JSONObject.parseObject(jsonStr);
        return json.getString("key");
    }

    private String GetVkey(int id, String videoId) {
        try {
            String fn = videoId + ".p" + (id - 10000) + ".1.mp4";
            String url = "http://vv.video.qq.com/getkey?format=" + id + "&otype=json&vid=" + videoId +
                    "&platform=11&charge=1&filename=" + fn;

            String html = httpTool.getJsonResultWithGet(url);
            if (html.isEmpty()) {
                return "";
            }
            html = html.substring(0, html.length() - 1).replace("QZOutputJson=", "");
            JSONObject json = JSONObject.parseObject(html);
            return json.getString("key");
        } catch (Exception e) {
            return "";
        }
    }

}
