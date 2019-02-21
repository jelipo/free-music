package freemusic.music.service.real;

import okhttp3.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 源自开源项目
 *
 * @author Springmarker
 * @date 2017/2/5
 */
public class NetUtil {
    private static final OkHttpClient client = new OkHttpClient();
    private static final MediaType Content_Type = MediaType.parse("application/x-www-form-urlencoded");
    private static final Headers headers = Headers.of(
            "Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
            "Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-US;q=0.7",
            "Connection", "keep-alive",
            "Cookie", "_iuqxldmzr_=32; _ntes_nnid=910b0511d7a185e8743f9580f072fe31,1544876092232; _ntes_nuid=910b0511d7a185e8743f9580f072fe31; mail_psc_fingerprint=ae585b52e94927998aedf7acc7e91871; UM_distinctid=16804a8b76d2c4-0ebc64b1fedf-6313363-1fa400-16804a8b76e5ac; vjuids=6043b2833.16804a8bba0.0.2a65e1cfaf31f; vinfo_n_f_l_n3=138b740eabd89da9.1.0.1546266393523.0.1546267621783; WM_TID=EbSNQ%2FzNM3BFAEQEARM9gDQd58uYDPSG; __utma=94650624.286023566.1544876094.1547309918.1547711726.7; __utmz=94650624.1547711726.7.3.utmcsr=baidu|utmccn=(organic)|utmcmd=organic; vjlast=1546266394.1549904376.23; WM_NI=cqh1%2BPD0nbHzXC2FDzchBpjgAcNoQUn292kt6iZ7wq%2Bg%2F2RmMx9esRKjHrH3L2RllVPhJGaTNc2XncfvvKJnsogji6JDlzol1hpw4cqOK2Kb5S0w0wwShYAgBWZX5SuiYlc%3D; WM_NIKE=9ca17ae2e6ffcda170e2e6ee99e6598a89f88ce27f8fe78ba6c45e828f9b85b864ac8cabd4d56baa86a9a2d52af0fea7c3b92aa1afa8d2aa5c88f0a283cb729c9dfea7c772a1b88e91e96d83bd8290d45faeeef7d3ea80f6b796d8f67be9b9e1d3d1678fa8f786f25a89b68893cb3990ee9e8def5e94b886a8e4608ebdfeb9ed69a6aabaacc966b1b1a98bec3e8a9ca49bee68f3b8c098b769b39185d3ca6af78d0098b37db58da8bac46d828996b9b859b7b7978de237e2a3; JSESSIONID-WYYY=kAjrADonCIa1AUYMxlDlihOJzMAdrcKYAOAi3uG6I6cS538%5CEIWPrRXI0gvQCrYHUVGfMbvna3m73sHzFieKBxC0GTS6dE7jeSvcj1mDXnlkwpzJCTxV2GcVIeQ9OJIBFxnrWz5%5CcvYjHhUfMheRtVf%5CjOnBgFCB9rc902e8FWKhv4SK%3A1550684211804",
            "Host", "music.163.com",
            "Upgrade-Insecure-Requests", "1",
            "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36"
    );
    final static private String modulus = "00e0b509f6259df8642dbc35662901477df22677ec152b5ff68ace615bb7" +
            "b725152b3ab17a876aea8a5aa76d2e417629ec4ee341f56135fccf695280" +
            "104e0312ecbda92557c93870114af6c9d05c4f7f0c3685b7a46bee255932" +
            "575cce10b424d813cfe4875d3e82047b97ddef52741d546b8e289dc6935b" +
            "3ece0462db0a22b8e7";
    final static private String nonce = "0CoJUm6Qyw8W8jud";
    final static private String pubKey = "010001";

    public static String getEncHtml(String url, String text, boolean needCookie) {

        String param = null;
        try {
            param = encryptedRequest(text);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        assert param != null;
        RequestBody requestBody = RequestBody.create(Content_Type, param);
        Request.Builder builder = new Request.Builder().url(url).post(requestBody).headers(headers);
//        if (needCookie) {
//            builder.addHeader("Cookie", "__remember_me=true; MUSIC_U=5f9d910d66cb2440037d1c68e6972ebb9f15308b56bfeaa4545d34fbabf71e0f36b9357ab7f474595690d369e01fbb9741049cea1c6bb9b6; __csrf=8ea789fbbf78b50e6b64b5ebbb786176; os=uwp; osver=10.0.10586.318; appver=1.2.1; deviceId=0e4f13d2d2ccbbf31806327bd4724043");
//        }
        Request request = builder.build();
        Response execute;
        try {
            execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                return execute.body().string();
            }
        } catch (Exception e) {

        }

        return "";
    }

    public static String getHtmlContent(String url, boolean needCookie) {
        try {
            Request.Builder builder = new Request.Builder().url(url).get().headers(headers);
            if (needCookie) {
                builder.addHeader("Cookie", "__remember_me=true; MUSIC_U=5f9d910d66cb2440037d1c68e6972ebb9f15308b56bfeaa4545d34fbabf71e0f36b9357ab7f474595690d369e01fbb9741049cea1c6bb9b6; __csrf=8ea789fbbf78b50e6b64b5ebbb786176; os=uwp; osver=10.0.10586.318; appver=1.2.1; deviceId=0e4f13d2d2ccbbf31806327bd4724043");
            }
            Request request = builder.build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                return execute.body().string();
            }
        } catch (Exception e) {

        }
        return "";
    }


    public static String postData(String url, Map<String, String> params) {

        try {
            FormBody.Builder build = new FormBody.Builder();
            int len = params.size();
            if (len <= 0) {
                return "";
            }
            Set<String> keys = params.keySet();
            for (String s : keys) {
                build.add(s, params.get(s));
            }
            FormBody body = build.build();
            Request request = new Request.Builder().url(url).post(body).headers(headers).build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                return execute.body().string();
            }
        } catch (Exception ignored) {

        }
        return "";
    }

    //based on [darknessomi/musicbox](https://github.com/darknessomi/musicbox)
    private static String encryptedRequest(String text) throws UnsupportedEncodingException {
        String secKey = createSecretKey(16);
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

    //based on [darknessomi/musicbox](https://github.com/darknessomi/musicbox)
    private static String aesEncrypt(String text, String key) {
        try {
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            //ignore
            return null;
        }
    }

    //based on [darknessomi/musicbox](https://github.com/darknessomi/musicbox)
    private static String rsaEncrypt(String text, String pubKey, String modulus) throws UnsupportedEncodingException {
        text = new StringBuilder(text).reverse().toString();
        BigInteger rs = new BigInteger(String.format("%x", new BigInteger(1, text.getBytes("UTF-8"))), 16)
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

    //based on [darknessomi/musicbox](https://github.com/darknessomi/musicbox)
    private static String createSecretKey(int i) {
        return getRandomString(i);
    }

    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    private static String str = "0123456789abcde";

    private static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }
}
