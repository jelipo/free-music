package freemusic.music.service.real;

import freemusic.music.pojo.MainFormPojo;
import com.alibaba.fastjson.JSONArray;


public interface MusicServices {

    JSONArray getFormatJson(MainFormPojo mainFormPojo);

    String getSearchResult(MainFormPojo mainFormPojo);

}
