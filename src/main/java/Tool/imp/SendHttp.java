package Tool.imp;

import Tool.pojo.HttpResult;
import org.springframework.stereotype.Service;

/**
 * Created by 10441 on 2016/9/30.
 */

public interface SendHttp {
    public void setUrl(String URL);
    public void addParam(String name,String value);
    public void addHeader(String name,String value);
    public void setEncoding(String encoding);

    public HttpResult getHttpResult();
    public HttpResult send();

}
