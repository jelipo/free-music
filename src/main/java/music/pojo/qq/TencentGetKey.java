package music.pojo.qq;

import java.util.List;

/**
 * Created by qtfreet on 2017/2/6.
 */
public class TencentGetKey {

    /**
     * code : 0
     * sip : ["http://58.221.77.143/streamoc.music.tc.qq.com/","http://dl.stream.qqmusic.qq.com/","http://isure.stream.qqmusic.qq.com/"]
     * thirdip : ["http://thirdparty.gtimg.com/abcd1234/","http://thirdparty.gtimg.com/abcd1234/"]
     * testfile2g : C100003mAan70zUy5O.m4a
     * testfilewifi : C100003mAan70zUy5O.m4a
     * key : 4C2CFFDE791310F0E07C0353AB0B40E7DFE1196AA8B158DBA90520C01326DEB338B9195135FC76C15BA30E51E2B7287FEC8F2CFCED676DD7
     */

    private int code;
    private String testfile2g;
    private String testfilewifi;
    private String key;
    private List<String> sip;
    private List<String> thirdip;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTestfile2g() {
        return testfile2g;
    }

    public void setTestfile2g(String testfile2g) {
        this.testfile2g = testfile2g;
    }

    public String getTestfilewifi() {
        return testfilewifi;
    }

    public void setTestfilewifi(String testfilewifi) {
        this.testfilewifi = testfilewifi;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getSip() {
        return sip;
    }

    public void setSip(List<String> sip) {
        this.sip = sip;
    }

    public List<String> getThirdip() {
        return thirdip;
    }

    public void setThirdip(List<String> thirdip) {
        this.thirdip = thirdip;
    }
}
