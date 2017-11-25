package freemusic.music.service;

import com.alibaba.fastjson.JSONArray;
import freemusic.music.pojo.MainFormPojo;
import freemusic.music.service.real.KgService;
import freemusic.music.service.real.MusicServices;
import freemusic.music.service.real.QQService;
import freemusic.music.service.real.WyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import freemusic.util.PackingResult;

import java.util.Map;

/**
 * Created by Springmarker on 2017/2/17.
 */
@Service
public class GetJsonService {

    public Map getFormatJson(MainFormPojo mainFormPojo) {
        MusicServices musicService = getService(mainFormPojo.getType());
        JSONArray array = musicService.getFormatJson(mainFormPojo);
        return PackingResult.INSTANCE.toSuccessMap(array);
    }

    public String getPristineJson(MainFormPojo mainFormPojo) {
        MusicServices musicService = getService(mainFormPojo.getType());
        String pristineJson = musicService.getSearchResult(mainFormPojo);
        return pristineJson;
    }

    private MusicServices getService(String type) {
        MusicServices musicService = null;
        if (type.equals("1")) {
            musicService = this.qqService;
        } else if (type.equals("2")) {
            musicService = this.wyService;
        } else if (type.equals("3")) {
            musicService = this.kgService;
        }
        return musicService;
    }

    @Autowired
    private QQService qqService;

    @Autowired
    private KgService kgService;

    @Autowired
    private WyService wyService;


}
