package Music.service.real;


import Music.pojo.MainFormPojo;
import Music.pojo.wy.Ar;
import Music.pojo.wy.WyPojo;
import Music.pojo.wy.wy;
import Tool.HttpTool;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import okhttp3.MediaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;

@Service("Music/service/real/WyService")
public class WyService implements MusicServices {

    @Value("#{config['search.pagesize']}")
    private int pagesize;

    @Resource(name = "Tool/HttpTool")
    private HttpTool httpTool;


    @Override
    public JSONArray getFormatJson(MainFormPojo form) {
        String searchResult=getSearchResult(form);
        System.out.println(searchResult);
        JSONObject jsonResult= JSONObject.parseObject(searchResult).getJSONObject("result");
        if (jsonResult.getInteger("songCount")==0){
            return new JSONArray();
        }
        JSONArray jsonList= jsonResult.getJSONArray("songs");
        List<wy> list=jsonList.toJavaList(wy.class);
        JSONArray array=new JSONArray();
        for(int i=0;i<list.size();i++){
            wy single=list.get(i);
            JSONObject json=new JSONObject();
            json.put("name",single.getName());
            List<Ar> singerList=single.getAr();
            String singer = null;
            for(int a=0;a<singerList.size();a++){
                singer=singerList.get(a).getName()+" ";
            }
            json.put("singer",singer);
            json.put("album",single.getAl().getName());
            json.put("s128",0);
            json.put("sogg",0);
            json.put("s320",single.getId());
            json.put("SQ",0);
            json.put("time",(single.getDt()/1000)/60+":"+(single.getDt()/1000)%60);
            json.put("mv",0);
            array.add(json);
        }
        return array;
    }

    @Override
    public String getSearchResult(MainFormPojo form) {
        String key=form.getKeyword();
        int page=Integer.valueOf(form.getPage());
        String text = "{\"s\":\"" + key + "\",\"type\":1,\"offset\":" + (page - 1) * pagesize + ",\"limit\":" + pagesize + ",\"total\":true}";
        System.out.println(text);
        String s = null;
        s = NetUtil.GetEncHtml("http://music.163.com/weapi/cloudsearch/get/web?csrf_token=", text, true);
        return s;
//        String keyword = null;
//        try {
//            keyword= URLEncoder.encode(form.getKeyword(), "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        SendPost post=new SendPost("http://music.163.com/api/search/pc","utf-8");
//        post.addHttpHeader("Cookie", "appver=2.0.2");
//        post.addHttpHeader("Referer", "http://music.163.com");
//        post.addPostText("s", keyword);
//
//        post.addPostText("sub", "false");
//        post.addPostText("limit", "20");
//        post.addPostText("type", "1");
//        post.addPostText("offset", form.getPage());
//        return post.send();
    }


    private String encryptedRequest(String text) {
        String secKey =getRandomString(16);
        String encText = aesEncrypt(aesEncrypt(text, nonce), secKey);
        String encSecKey = rsaEncrypt(secKey, pubKey, modulus);
        try {
            assert encText != null;
            return "params=" + URLEncoder.encode(encText, "UTF-8") + "&encSecKey=" + URLEncoder.encode(encSecKey, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //ignore
            return null;
        }
    }

    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }
    private static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }

    private static String aesEncrypt(String text, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(text.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            //ignore
            return null;
        }
    }

    private static String rsaEncrypt(String text, String pubKey, String modulus) {
        text = new StringBuilder(text).reverse().toString();
        BigInteger rs = new BigInteger(String.format("%x", new BigInteger(1, text.getBytes())), 16)
                .modPow(new BigInteger(pubKey, 16), new BigInteger(modulus, 16));
        String r = rs.toString(16);
        if (r.length() >= 256) {
            return r.substring(r.length() - 256, r.length());
        } else {
            while (r.length() < 256) {
                r = 0 + r;
            }
            return r;
        }
    }

    private static final MediaType Content_Type = MediaType.parse("application/x-www-form-urlencoded");
    private static final Headers headers = new Headers.Builder()
            .add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36")
            .build();
    final static private String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7" +
            "b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280" +
            "104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932" +
            "575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b" +
            "3ece0462db0a22b8e7";
    final static private String nonce = "0CoJUm6Qyw8W8jud";
    final static private String pubKey = "010001";
    private static String string = "0123456789abcde";
}
