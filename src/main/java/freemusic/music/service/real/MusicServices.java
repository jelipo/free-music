package freemusic.music.service.real;

import freemusic.music.pojo.MainFormPojo;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;


public interface MusicServices {

    ArrayList getFormatJson(MainFormPojo mainFormPojo);

    String getSearchResult(MainFormPojo mainFormPojo);

}
