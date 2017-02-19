package Music.service;

import Music.pojo.MainFormPojo;
import Music.service.real.KgService;
import Music.service.real.MusicServices;
import Music.service.real.QQService;
import Music.service.real.WyService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Service;
import util.PackingResult;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by cao on 2017/2/17.
 */
@Service("Music/service/GetJsonService")
public class GetJsonService {

    public Map getFormatJson(MainFormPojo mainFormPojo) {
        MusicServices musicService=getService(mainFormPojo.getType());
        JSONArray array=musicService.getFormatJson(mainFormPojo);
        return PackingResult.toSuccessMap(array);
    }

    public String getPristineJson(MainFormPojo mainFormPojo) {
        MusicServices musicService=getService(mainFormPojo.getType());
        String  pristineJson = musicService.getSearchResult(mainFormPojo);
        return pristineJson;
    }

    private MusicServices getService(String type){
        MusicServices musicService = null;
        if (type.equals("1")){
            musicService=qqService;
        }else if (type.equals("2")){
            musicService=wyService;
        }else if (type.equals("3")){
            musicService=kgService;
        }
        return musicService;
    }

    @Resource(name = "Music/service/real/QQService")
    private QQService qqService;

    @Resource(name = "Music/service/real/KgService")
    private KgService kgService;

    @Resource(name = "Music/service/real/WyService")
    private WyService wyService;




}
