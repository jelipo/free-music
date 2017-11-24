package freemusic.music.service.download;

import freemusic.music.pojo.wy.NeteaseLostSong;
import freemusic.music.service.real.NetUtil;
import freemusic.tool.HttpTool;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.*;


@Service
public class WyDownload implements MusicDownload {

    @Autowired
    private HttpTool httpTool;

    @Override
    public String getDownloadUrl(String id, String quality) {
        String realQuality="320000";
        String text = "{\"ids\":[\"" + id + "\"],\"br\":" + realQuality + ",\"csrf_token\":\"\"}";
        String html;
        html = NetUtil.GetEncHtml("http://music.163.com/weapi/song/enhance/player/url?csrf_token=", text, true);
        JSONObject json = JSON.parseObject(html);
        if (json.getJSONArray("data").getJSONObject(0).getInteger("code")==200){
            return json.getJSONArray("data").getJSONObject(0).getString("url");
        }else {
            return  GetLostPlayUrl(id, realQuality);
        }
    }

    @Override
    public String getMvUrl(String id, String quality) {
        String sendUrl = "http://music.163.com/api/song/mv?id=" + id+ "&type=mp4";
        OkHttpClient httpClient = httpTool.getHttpClient();
        Request request = new Request.Builder().url(sendUrl)
                .addHeader("Cookie", "__remember_me=true; MUSIC_U=5f9d910d66cb2440037d1c68e6972ebb9f15308b56bfeaa4545d34fbabf71e0f36b9357ab7f474595690d369e01fbb9741049cea1c6bb9b6; __csrf=8ea789fbbf78b50e6b64b5ebbb786176; os=uwp; osver=10.0.10586.318; appver=1.2.1; deviceId=0e4f13d2d2ccbbf31806327bd4724043")
                .build();
        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
            String html=response.body().string();
            JSONObject json=JSONObject.parseObject(html);
            JSONArray array=json.getJSONArray("mvs");
            Map<Integer ,JSONObject> map=new HashMap();
            int arraySize=array.size();
            int arr[]=new int[arraySize];
            for (int i=0;i<arraySize;i++){
                JSONObject single=array.getJSONObject(i);
                arr[i]=single.getInteger("br");
                map.put(arr[i],single);
            }
            Arrays.sort(arr);
            map.get(arr[arraySize-1]);
            JSONObject bigJson=map.get(arr[arraySize-1]);;
            return bigJson.getString("mvurl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public String getImgUrl(String id, String quality) {
        return null;
    }

    public static String GetLostPlayUrl(String id, String quality) {
        String albumId = GetLostAlbumId(id);
        try {
            String s = NetUtil.GetHtmlContent("http://music.163.com/api/album/" + albumId, true);
            NeteaseLostSong neteaseLostSong = JSON.parseObject(s, NeteaseLostSong.class);
            List<NeteaseLostSong.AlbumBeanX.SongsBean> songs = neteaseLostSong.getAlbum().getSongs();
            int size = songs.size();
            for (NeteaseLostSong.AlbumBeanX.SongsBean songsBean : songs) {
                if (songsBean.getId() == Integer.parseInt(id)) {
                    switch (quality) {
                        case "320000":
                            String dfsId;
                            if (songsBean.getHMusic() == null) {
                                if (songsBean.getMMusic() == null) {
                                    return songsBean.getMp3Url();
                                }
                                dfsId = String.valueOf(songsBean.getMMusic().getDfsId());
                            } else {
                                dfsId = String.valueOf(songsBean.getHMusic().getDfsId());
                            }
                            return GetUrlBySid(dfsId);
                        case "192000":
                            if (songsBean.getMMusic() == null) {
                                return songsBean.getMp3Url();
                            } else {
                                dfsId = String.valueOf(songsBean.getMMusic().getDfsId());
                                return GetUrlBySid(dfsId);
                            }
                        default:
                            return songsBean.getMp3Url();
                    }
                }
            }
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public static String GetLostAlbumId(String id) {
        String text = "[{\"id\":\"" + id + "\"}]";
        HashMap<String, String> map = new HashMap<>();
        map.put("c", text);
        try {
            String s = NetUtil.PostData("http://music.163.com/api/v3/song/detail", map);
            int albumId = JSON.parseObject(s).getJSONArray("songs").getJSONObject(0).getJSONObject("al").getInteger("id");
            return String.valueOf(albumId);
        } catch (Exception e) {
            return null;
        }
    }
    private static String GetUrlBySid(String dfsId) {
        String encryptPath = EncryptId(dfsId);
        return "http://m2.music.126.net/" + encryptPath + "/" + dfsId + ".mp3";
    }

    private static String EncryptId(String id) {
        byte[] byte1 = "3go8&$8*3*3h0k(2)2".getBytes();
        byte[] byte2 = id.getBytes();
        int byte1Length = byte1.length;
        for (int i = 0; i < byte2.length; i++) {
            byte tmp = byte1[(i % byte1Length)];
            byte2[i] = ((byte) (byte2[i] ^ tmp));
        }
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        byte[] md5Bytes = md5.digest(byte2);
        String retval = new BASE64Encoder().encode(md5Bytes);
        retval = retval.replace('/', '_');
        retval = retval.replace('+', '-');
        return retval;
    }
}
