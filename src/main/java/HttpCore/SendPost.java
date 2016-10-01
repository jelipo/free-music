package HttpCore;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SendPost {
	private String urlPath = null;
	private String param = null;
	private int resultCode = 0;
	private String characterEncoding = null;
	private Map<String, String> headMap = new HashMap();

	public SendPost(String url, String characterEncoding) {
		this.urlPath = url.replace(" ", "%20");
		this.characterEncoding = characterEncoding;
	}

	public void addPostText(String name, String value) {
		this.param = (this.param + "&" + name + "=" + value);
	}

	public int getResultCode() {
		return this.resultCode;
	}

	public void addHttpHeader(String name, String value) {
		this.headMap.put(name, value);
	}

	public String send(){
		String result = "";
		try {
			URL url = new URL(this.urlPath);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setUseCaches(false);
			httpConn.setRequestMethod("POST");

			httpConn.setRequestProperty("Charset", "UTF-8");
			Set set = this.headMap.entrySet();
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry mapentry = (Entry) iterator.next();
				httpConn.setRequestProperty(mapentry.getKey().toString(), mapentry.getValue().toString());
			}
			httpConn.connect();
			DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
			dos.writeBytes(this.param);
			dos.flush();
			dos.close();
			this.resultCode = httpConn.getResponseCode();
			if (200 == this.resultCode) {
				StringBuffer sb = new StringBuffer();
				String readLine = new String();
				BufferedReader responseReader = new BufferedReader(
						new InputStreamReader(httpConn.getInputStream(), this.characterEncoding));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				result = sb.toString();
			} else {
				return "{'flag','发送失败,网络错误代码：" + this.resultCode + "'}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
}
