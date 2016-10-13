package Music.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import Music.impl.Pristine2NormJson;
import Music.pojo.MainFormPojo;
@Service("Music/Pristine2Norm")
public class Pristine2NormJsonService implements Pristine2NormJson {

	@Override
	public JSONObject getNormJson(JSONObject pristine, MainFormPojo form) {
		JSONObject result = null;
		switch (form.getMusictype()) {
		case "1": // qq音乐搜索
			result = qqMusicChange(pristine);
			break;
		case "2": // 网易音乐搜索
			result = wyMusicChange(pristine);
			break;
		case "3": // 酷狗音乐搜索
			result = kgMusicChange(pristine);
			break;
		default:
			break;
		}
		return result;
	}
	private JSONObject kgMusicChange(JSONObject json){
		JSONObject normJson=new JSONObject();
		normJson.put("code", "200");
		JSONArray normList=new JSONArray();
		JSONArray pristinelist=json.getJSONObject("data").getJSONArray("lists");
		for(int i=0;i<pristinelist.size();i++){
			JSONObject listchild=new JSONObject();
			JSONObject pristinelistchild=pristinelist.getJSONObject(i);
			listchild.put("song",pristinelistchild.getString("SongName").replace("<em>", "").replace("</em>", ""));
			listchild.put("singer",pristinelistchild.getString("SingerName").replace("<em>", "").replace("</em>", ""));
			listchild.put("album",pristinelistchild.getString("AlbumName").replace("<em>", "").replace("</em>", ""));
			listchild.put("m128",pristinelistchild.getString("FileHash"));
			listchild.put("m320",pristinelistchild.getString("HQFileHash"));
			listchild.put("SQ",pristinelistchild.getString("SQFileHash"));
			listchild.put("time",Integer.toString((int)pristinelistchild.get("HQDuration")/60)+":"+Integer.toString((int)pristinelistchild.get("HQDuration")%60));
			normList.add(listchild);
		}
		normJson.put("list", normList);
		return normJson;
	}
	
	private JSONObject wyMusicChange(JSONObject json1) {
		JSONArray songList = json1.getJSONObject("result").getJSONArray("songs");
		JSONObject newJson = new JSONObject();
		JSONArray newSongList = new JSONArray();
		JSONArray artists = null;
		int i = 0;
		for (int length = songList.size(); i < length; i++) {
			artists = songList.getJSONObject(i).getJSONArray("artists");
			String artist = artists.getJSONObject(0).getString("name");
			for (int j = 1; j < artists.size(); j++) {
				artist=artist +"/"+ artists.getJSONObject(j).getString("name");
			}
			String id = songList.getJSONObject(i).getString("id");
			JSONObject newSongListChild = new JSONObject();
			newSongListChild.put("1", Integer.valueOf(i));
			newSongListChild.put("song", songList.getJSONObject(i).get("name"));
			newSongListChild.put("id", id);
			int time = songList.getJSONObject(i).getInteger("duration").intValue() / 1000;
			String newtime = time / 60 + ":" + (time % 60 > 9 ? Integer.valueOf(time % 60)
					: new StringBuilder("0").append(time % 60).toString());
			newSongListChild.put("time", newtime);
			newSongListChild.put("album", songList.getJSONObject(i).getJSONObject("album").get("name"));
			newSongListChild.put("albumid", songList.getJSONObject(i).getJSONObject("album").getString("id"));
			newSongListChild.put("singer", artist);
			newSongList.add(newSongListChild);
		}
		newJson.put("list", newSongList);
		newJson.put("code", "200");
		newJson.put("type", "wy");
		return newJson;
	}

	private  JSONObject qqMusicChange(JSONObject json) {
		JSONArray songlist = json.getJSONObject("data").getJSONObject("song").getJSONArray("list");
		if (songlist.size()==0){
			songlist=json.getJSONObject("data").getJSONObject("semantic").getJSONArray("list");
		}
		JSONArray newsonglist = new JSONArray();
		for (int i = 0; i < songlist.size(); i++) {
			JSONObject newsinglesong = new JSONObject();
			String[] inf = songlist.getJSONObject(i).getString("f").split("\\|");
			if (inf.length > 2) {
				newsinglesong.put("official", "true");
				newsinglesong.put("song", changeGarbledCode(inf[1]));
				newsinglesong.put("singer", changeGarbledCode(inf[3]));
				newsinglesong.put("album", changeGarbledCode(inf[5]));
				int time = Integer.parseInt(inf[7]);
				String newtime = time / 60 + ":" + (time % 60 > 9 ? Integer.valueOf(time % 60)
						: new StringBuilder("0").append(time % 60).toString());
				newsinglesong.put("time", newtime);
				newsinglesong.put("ape", inf[15]);
				newsinglesong.put("flac", inf[16]);
				newsinglesong.put("common", inf[13]);
				newsinglesong.put("id", inf[20]);
				newsonglist.add(newsinglesong);
			} else {
				newsinglesong.put("official", "false");
				inf = songlist.getJSONObject(i).getString("f").split("@@");
				newsinglesong.put("song", inf[1]);
				newsinglesong.put("singer", inf[3]);
				newsinglesong.put("album", inf[2]);
				int time = Integer.parseInt(inf[7]);
				String newtime = time / 60 + ":" + (time % 60 > 9 ? Integer.valueOf(time % 60)
						: new StringBuilder("0").append(time % 60).toString());
				newsinglesong.put("time", newtime);
				newsinglesong.put("downurl", inf[8]);
				newsonglist.add(newsinglesong);
			}
		}
		JSONObject newjson = new JSONObject();
		newjson.put("list", newsonglist);
		newjson.put("flag", "success");
		newjson.put("type", "qq");
		return newjson;
	}

	private static String changeGarbledCode(String str) {
		if (str.contains("&amp;#")) {
			str = str.replace("&amp;", "");
			str = str.replace("&", "");
			str = str.replace(" ", "");
			String[] b = str.split(";");
			str = "";
			int i = 0;
			for (int length = b.length; i < length; i++) {
				if (b[i].contains("#")) {
					String[] c = b[i].split("#");
					char d = (char) Integer.parseInt(c[1]);
					str = str + c[0] + Character.toString(Character.valueOf(d).charValue());
				} else {
					str = str + b[i];
				}
			}
		}
		return str;
	}

}
