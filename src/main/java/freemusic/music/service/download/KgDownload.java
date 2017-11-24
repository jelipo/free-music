package freemusic.music.service.download;

import freemusic.tool.HttpTool;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KgDownload implements MusicDownload {

    @Autowired
    private HttpTool httpTool;

    @Override
    public String getDownloadUrl(String id, String quality) {
        String key = DigestUtils.md5Hex(id + "kgcloud");
        String result = httpTool.getJsonResultWithGet("http://trackercdn.kugou.com/i/?key=" + key + "&cmd=4&acceptMp3=1&hash=" + id + "&pid=1");
        if (result.contains("Bad key") || result.contains("The Resource Needs to be Paid")) {
            return "";
        }
        JSONObject json = JSONObject.parseObject(result);
        return json.getString("url");
    }


    @Override
    public String getMvUrl(String id, String quality) {

        String key = DigestUtils.md5Hex(id + "kugoumvcloud");
        String result = httpTool.getJsonResultWithGet("http://trackermv.kugou.com/interface/index?cmd=100&pid=6&ext=mp4&hash=" + id + "&quality=-1&key=" + key + "&backupdomain=1");
        if (result.contains("Bad key") || result.contains("The Resource Needs to be Paid")) {
            return "";
        }
        JSONObject mvData = JSONObject.parseObject(result).getJSONObject("mvdata");
        String mvurl;
        if((mvurl = mvData.getJSONObject("sq").getString("downurl")) !=null){
            return mvurl;
        }else if((mvurl = mvData.getJSONObject("hd").getString("downurl")) !=null){
            return mvurl;
        }else if((mvurl = mvData.getJSONObject("sd").getString("downurl")) !=null){
            return mvurl;
        }else if((mvurl = mvData.getJSONObject("le").getString("downurl")) !=null) {
            return mvurl;
        }
        return "";
    }

    @Override
    public String getImgUrl(String id, String quality) {
        return null;
    }

    private String getUrl(String id, String quality) {
        return "";
    }
}
