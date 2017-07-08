package music.service.real;

import music.pojo.MainFormPojo;
import com.alibaba.fastjson.JSONArray;


public interface MusicServices {

    JSONArray getFormatJson(MainFormPojo mainFormPojo);

    String getSearchResult(MainFormPojo mainFormPojo);

}
