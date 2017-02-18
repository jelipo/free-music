package Music.service.real;

import okhttp3.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by qtfreet00 on 2017/2/5.
 */
public class NetUtil {
    private static final OkHttpClient client = new OkHttpClient();
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

    public static String GetEncHtml(String url, String text, boolean needCookie) {

        String param = encryptedRequest(text);
        assert param != null;
        RequestBody requestBody = RequestBody.create(Content_Type, param);
        Request.Builder builder = new Request.Builder().url(url).post(requestBody).headers(headers);
        if (needCookie) {
            builder.addHeader("Cookie", "__remember_me=true; MUSIC_U=5f9d910d66cb2440037d1c68e6972ebb9f15308b56bfeaa4545d34fbabf71e0f36b9357ab7f474595690d369e01fbb9741049cea1c6bb9b6; __csrf=8ea789fbbf78b50e6b64b5ebbb786176; os=uwp; osver=10.0.10586.318; appver=1.2.1; deviceId=0e4f13d2d2ccbbf31806327bd4724043");
        }
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

    public static String GetHtmlContent(String url) {
        return GetHtmlContent(url, false);
    }

    public static String GetHtmlContent(String url, boolean needCookie) {
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


    public static String GetHtmlWithRefer(String url, String refer) {
        try {
            Request.Builder builder = new Request.Builder().url(url).get().headers(headers);

            builder.addHeader("Referer", refer);

            Request request = builder.build();
            Response execute = client.newCall(request).execute();
            if (execute.isSuccessful()) {
                return execute.body().string();
            }
        } catch (Exception e) {

        }
        return "";
    }

    public static String PostData(String url, HashMap<String, String> params) {

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
        } catch (Exception e) {

        }
        return "";
    }

    //based on [darknessomi/musicbox](https://github.com/darknessomi/musicbox)
    static String encryptedRequest(String text) {
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

            byte[] encrypted = cipher.doFinal(text.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            //ignore
            return null;
        }
    }

    //based on [darknessomi/musicbox](https://github.com/darknessomi/musicbox)
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

    //based on [darknessomi/musicbox](https://github.com/darknessomi/musicbox)
    private static String createSecretKey(int i) {
        return getRandomString(16);
    }

    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    private static String string = "0123456789abcde";

    private static String getRandomString(int length) {
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }
}
