package Music.service;

import java.security.MessageDigest;

import Tool.Service.SendHttpGet;
import Tool.Service.SendHttpPost;
import Tool.imp.SendHttp;
import Tool.pojo.HttpResult;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import HttpCore.SendGet;
import Music.impl.Download;
import Music.pojo.DownloadPojo;

import javax.annotation.Resource;

@Service("Music/Download")
public class DownloadService implements Download {
	@Resource(name= "Tool/Service/SendHttpGet")
	private SendHttpGet httpGet;

	@Override
	public String getRealUrl(DownloadPojo pojo) {
		String url=null;
		switch (pojo.getMusictype()) {
		case "1": // qq音乐搜索
			url = qqRealUrl(pojo);
			break;
		case "2": // 网易音乐搜索
			url = wyRealUrl(pojo);
			break;
		case "3": // 酷狗音乐搜索
			url = kgRealUrl(pojo);
			break;
		default:
			break;
		}
		return url;
	}
	private String qqRealUrl(DownloadPojo pojo){
		String filetype=pojo.getFiletype();
		if(filetype.equals("flac")){
			return "http://stream.qqmusic.tc.qq.com/F000" + pojo.getId() + ".flac";
			
		}else if(filetype.equals("ape")){
			return "http://stream.qqmusic.tc.qq.com/A000" + pojo.getId()+ ".ape";
		}
		int curMs = 265;
		long a = (long) (Math.round(Math.random() * 2.147483647E9D) * curMs % 1.0E10D);
		String url = "http://base.music.qq.com/fcgi-bin/fcg_musicexpress.fcg?json=3&guid=" + a
				+ "&g_tk=938407465&loginUin=0&hostUin=0&format=jsonp&inCharset=GB2312&outCharset=GB2312&notice=0&platform=yqq&jsonpCallback=jsonCallback&needNewCode=0";
		httpGet.setUrl(url);
		HttpResult result=httpGet.send();
		String html = result.getResult();
		String[] res = html.split("\\(");
		String[] real = res[1].split("\\)");
		JSONObject json = JSON.parseObject(real[0]);
		String vkey = json.getString("key");
		String url1 = "http://cc.stream.qqmusic.qq.com/M800" + pojo.getId() + ".mp3?vkey=" + vkey + "&guid=" + String.valueOf(a)
				+ "&fromtag=0";
		return url1;
	}
	private String wyRealUrl(DownloadPojo pojo){
		String url = "http://m2.music.126.net/";
		String downUrl ;
		httpGet.setUrl("http://music.163.com/api/song/detail/?id="+pojo.getId()+ "&ids=%5B" +pojo.getId()+ "%5D");
		httpGet.addHeader("Referer", "http://music.163.com");
		HttpResult result=httpGet.send();
		String json2 = result.getResult();
		if (JSON.parseObject(json2).getJSONArray("songs").getJSONObject(0).get("mp3Url") == null) {
			downUrl = "DownloadError";
		} else {
			JSONObject songid = JSON.parseObject(json2).getJSONArray("songs").getJSONObject(0).getJSONObject("hMusic");
			if ((songid == null) || (songid.equals(""))) {
				songid = JSON.parseObject(json2).getJSONArray("songs").getJSONObject(0).getJSONObject("mMusic");
			}
			new Encryption();
			String r = Encryption.encrypted_id(songid.getString("dfsId"));
			downUrl =url + r + "/" + songid.get("dfsId") + ".mp3";
		}
		return downUrl;
	}
	private String kgRealUrl(DownloadPojo pojo){
		String hash=pojo.getId();
		String key = DigestUtils.md5Hex(hash+"kgcloud");
		SendGet get=new SendGet("http://trackercdn.kugou.com/i/?"
				+ "key="+key+"&cmd=4&acceptMp3=1&"
				+ "hash="+hash+"&pid=1", "utf-8");
		JSONObject json=JSON.parseObject(get.send());
		return json.getString("url");
	}
}
