package Music.service.download;

import HttpCore.SendGet;
import Tool.HttpTool;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("Music/service/download/KgDownload")
public class KgDownload implements MusicDownload {

    @Resource(name = "Tool/HttpTool")
    private HttpTool httpClient;

    @Override
    public String getDownloadUrl(String id, String quality) {

        String key = DigestUtils.md5Hex(id+"kgcloud");
        SendGet get=new SendGet("http://trackercdn.kugou.com/i/?"
                + "key="+key+"&cmd=4&acceptMp3=1&"
                + "hash="+id+"&pid=1", "utf-8");
        String result=get.send();
        if (result.contains("Bad key") || result.contains("The Resource Needs to be Paid")) {
            return "";
        }
        JSONObject json= JSON.parseObject(get.send());
        return json.getString("url");
    }
}
