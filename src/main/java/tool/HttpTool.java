package tool;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class HttpTool {

    private OkHttpClient okHttpClient;

    @PostConstruct
    public void init() {
        this.okHttpClient = new OkHttpClient();
    }

    public OkHttpClient getHttpClient() {
        return okHttpClient;
    }

    public String getJsonResultWithGet(String url) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = this.okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
