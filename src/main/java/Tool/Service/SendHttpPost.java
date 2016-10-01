package Tool.Service;

import Tool.imp.SendHttp;
import Tool.pojo.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 10441 on 2016/9/30.
 */
@Service("Tool/Service/SendHttpPost")
public class SendHttpPost  {
    private String URL;
    private String params="";
    private Map<String, String> headers = new HashMap();
    private String encoding="UTF-8";
    private HttpResult httpResult=new HttpResult();
    private static Logger log = Logger.getLogger(SendHttp.class);
    public void setUrl(String URL) {
        this.URL = URL;
    }


    public void addParam(String name, String value) {
        this.params = this.params + "&" + name + "=" + value;
    }


    public void addHeader(String name, String value) {
        this.headers.put(name, value);
    }


    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }


    public HttpResult getHttpResult() {
        return httpResult;
    }

    private  void init(){
        this.URL=(this.URL).replace(" ", "20%");
//        添加默认头，按情况添加
//        this.headers.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//        this.headers.put("Accept-Language","zh-CN,zh;q=0.8");
    }


    public HttpResult send() {
        init();
        try {
            java.net.URL url = new URL(URL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Charset", this.encoding);
            Set set = this.headers.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mapentry = (Map.Entry) iterator.next();
                httpConn.setRequestProperty(mapentry.getKey().toString(), mapentry.getValue().toString());
            }
            httpConn.connect();
            DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
            dos.writeBytes(this.params);
            dos.flush();
            dos.close();
            httpResult.setResultCode(httpConn.getResponseCode());
            httpResult.setResultHeaders(httpConn.getHeaderFields());
            //if (200 == httpResult.getResultCode()) {
                StringBuffer sb = new StringBuffer();
                String readLine;
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),encoding));
                while ((readLine = responseReader.readLine()) != null) {
                    sb.append (readLine).append("\n");
                }
                responseReader.close();
                httpResult.setResult(sb.toString());
            //}
        } catch (Exception e) {
            log.error("发送POST请求时出错");
            e.printStackTrace();
        }
        return httpResult;
    }
}
