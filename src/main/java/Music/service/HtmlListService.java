package Music.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import Tool.Service.SendHttpGet;
import Tool.Service.SendHttpPost;
import Tool.pojo.HttpResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import HttpCore.SendGet;
import HttpCore.SendPost;
import Music.impl.HtmlList;
import Music.pojo.MainFormPojo;

import javax.annotation.Resource;

@Service("Music/HtmlList")
public class HtmlListService implements HtmlList {
	@Value("#{config['search.pagesize']}")
	private String pagesize;

	@Resource(name= "Tool/Service/SendHttpGet")
	private SendHttpGet httpGet;
	@Resource(name= "Tool/Service/SendHttpPost")
	private SendHttpPost httpPost;

	@Override
	public JSONObject getPristineJson(MainFormPojo form) {
		String result = null;
		form.setKeyword(URLDecoder.decode(form.getKeyword()));
		switch (form.getMusictype()) {
		case "1": // qq音乐搜索
			result = qqMusic(form);
			break;
		case "2": // 网易音乐搜索
			result = wyMusic(form);
			break;
		case "3": // 酷狗音乐搜索
			result = kgMusic(form);
			break;
		default:
			break;
		}

		return JSON.parseObject(result);
	}

	private String qqMusic(MainFormPojo form) {
		String keyword = null;
		try {
			keyword=URLEncoder.encode(form.getKeyword(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String Url = "http://s.music.qq.com/fcgi-bin/music_search_new_platform?t=0&n=" + pagesize
				+ "&aggr=1&cr=1&loginUin=0&format=json&inCharset=GB2312&outCharset=utf-8&notice=0"
				+ "&platform=jqminiframe.json&needNewCode=0&p=" + form.getPage()
				+ "&catZhida=0&remoteplace=sizer.newclient.next_song&w=" + keyword;
		httpGet.setUrl(Url);
		HttpResult result=httpGet.send();
		return result.getResult();
	}

	//
	private String wyMusic(MainFormPojo form) {
		String keyword = null;
		try {
			keyword=URLEncoder.encode(form.getKeyword(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SendPost post=new SendPost("http://music.163.com/api/search/pc","utf-8");
		post.addHttpHeader("Cookie", "appver=2.0.2");
		post.addHttpHeader("Referer", "http://music.163.com");
		post.addPostText("s", keyword);

		post.addPostText("sub", "false");
		post.addPostText("limit", "20");
		post.addPostText("type", "1");
		post.addPostText("offset", form.getPage());
		return post.send();
	}

	private String kgMusic(MainFormPojo form) {
		String keyword = null;
		try {
			keyword=URLEncoder.encode(form.getKeyword(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String url = "http://songsearch.kugou.com/song_search_v2?"
				+ "keyword="+keyword+"&page="+form.getPage()+"&pagesize="+pagesize+"&filter=0&bitrate=0&isfuzzy=0&"
						+ "tag=em&inputtype=2&platform=PcFilter&userid=&clientver=8060&iscorrection=3";
		httpGet.setUrl(url);
		HttpResult result=httpGet.send();
		return result.getResult();
	}

}
