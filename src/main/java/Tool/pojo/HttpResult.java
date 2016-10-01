package Tool.pojo;

import java.util.List;
import java.util.Map;

/**
 * Created by 10441 on 2016/9/30.
 */
public class HttpResult {
    private String result;
    private int resultCode;
    private Map<String, List<String>> resultHeaders;



    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Map<String, List<String>> getResultHeaders() {
        return resultHeaders;
    }

    public void setResultHeaders(Map<String, List<String>> resultHeaders) {
        this.resultHeaders = resultHeaders;
    }
}
