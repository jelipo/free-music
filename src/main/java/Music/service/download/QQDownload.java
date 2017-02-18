package Music.service.download;

import Tool.HttpTool;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service("Music/service/download/QQDownload")
public class QQDownload implements MusicDownload {
    @Resource(name = "Tool/HttpTool")
    private HttpTool httpTool;

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

    private String getKey(long nowTime, long guid) {
        String url = "http://base.music.qq.com/fcgi-bin/fcg_musicexpress.fcg?json=3&guid=" + guid;
        String html = httpTool.getJsonResultWithGet(url);
        String jsonStr = html.substring(html.indexOf("(") + 1, html.lastIndexOf(")"));
        JSONObject json = JSONObject.parseObject(jsonStr);
        return json.getString("key");
    }

}
