package Music.service.real;

import Music.pojo.MainFormPojo;
import Music.pojo.kg.Kg;
import Tool.HttpTool;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Service("Music/service/real/KgService")
public class KgService implements MusicServices {

    @Value("#{config['search.pagesize']}")
    private String pagesize;

    @Resource(name = "Tool/HttpTool")
    private HttpTool httpClient;


    @Override
    public JSONArray getFormatJson(MainFormPojo form) {
        String pristineJson=getSearchResult(form);
        JSONArray list =JSONObject.parseObject(pristineJson).getJSONObject("data").getJSONArray("lists");
        List<Kg> kg=list.toJavaList(Kg.class);
        JSONArray array=new JSONArray();
        for(int i=0;i<kg.size();i++){
            JSONObject json=new JSONObject();
            Kg single=kg.get(i);
            json.put("name",single.getSongName().replace("<em>", "").replace("</em>", ""));
            json.put("singer",single.getSingerName().replace("<em>", "").replace("</em>", ""));
            json.put("album",single.getAlbumName().replace("<em>", "").replace("</em>", ""));
            json.put("s128",single.getFileHash().replace("0","").equals("")?0:single.getFileHash());
            json.put("s320",single.getHQFileHash().replace("0","").equals("")?0:single.getFileHash());
            json.put("sogg",0);
            json.put("SQ",single.getSQFileHash());
            json.put("time",Integer.toString(single.getHQDuration()/60)+":"+single.getHQDuration()%60);
            json.put("mv",single.getMvHash());
            array.add(json);
        }
        return array;

    }

    @Override
    public String getSearchResult(MainFormPojo form) {
        String keyword = null;
        try {
            keyword= URLEncoder.encode(form.getKeyword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "http://songsearch.kugou.com/song_search_v2?"
                + "keyword="+keyword+"&page="+form.getPage()+"&pagesize="+pagesize+"&filter=0&bitrate=0&isfuzzy=0&"
                + "tag=em&inputtype=2&platform=PcFilter&userid=&clientver=8060&iscorrection=3";
        String result=httpClient.getJsonResultWithGet(url);
        return  result;
    }
}
