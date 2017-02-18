package Music.service.real;

import Music.pojo.MainFormPojo;
import com.alibaba.fastjson.JSONArray;


public interface MusicServices {

    JSONArray getFormatJson(MainFormPojo mainFormPojo);

    String getSearchResult(MainFormPojo mainFormPojo);

}
