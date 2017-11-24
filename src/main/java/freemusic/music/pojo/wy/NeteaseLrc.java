package freemusic.music.pojo.wy;

/**
 * Created by qtfreet00 on 2017/2/4.
 */
public class NeteaseLrc {

    /**
     * sgc : false
     * sfy : true
     * qfy : true
     * lyricUser : {"id":451441156,"status":0,"demand":0,"userid":251241884,"nickname":"初茶mio","uptime":1485250663863}
     * lrc : {"version":3,"lyric":"[by:初茶mio]\n[00:03.320]Oh yeah yeah\n[00:08.270]Oh 언젠가는 내 두 발이 Oh 닿는 대로\n[00:13.040]이끌리는 시선을 뺏겨버린 대로\n[00:18.260]가볍게 걸어갈 낯선 곳을 그리다\n[00:22.620]또 결국엔 허전한 긴 한숨에 멈춰\n[00:27.020]Why, Why, 돌아서 또 넌\n[00:35.810]Why, Why, 꿈만 가득해\n[00:43.960]지금 떠난다면 Good, Good, Good, yeah\n[00:48.440]만나게 될 모든 건 Great, Great, yeah\n[00:52.510]가벼워진 맘이Work, Work, baby\n[00:57.320]이미 이미 눈 앞에\n[00:59.910]아른아른대는데 망설여 Why\n[01:04.020]나침반 위 돌아가던 바늘이\n[01:07.320]멈춘 곳에 가득 핀 이름 모를 꽃잎이\n[01:13.140]널 위해 끌어당긴 빛이 담긴 풍경 속에\n[01:17.560]어서 뛰어들어 나보다 자유롭게 더\n[01:22.310]Why, Why, Why, 괜히 미뤄 왔던 날\n[01:31.820]많았던 걱정이 모두 다 사라진 tonight yeah\n[01:39.140]바람 불어오면 Good, Good, Good, yeah\n[01:43.370]펼쳐지는 모든 건 Great, Great, yeah\n[01:47.360]달라지는 맘이 Work, Work, baby\n[01:52.360]이미 이미 눈 앞에\n[01:54.540]아른아른대는데\n[01:56.880]지금 떠난다면 Good, Good, Good, yeah\n[02:01.610]만나게 될 모든 건 Great, Great, yeah\n[02:05.990]가벼워진 맘이Work, Work, baby\n[02:10.530]이미 이미 눈 앞에\n[02:12.880]아른아른대는데 망설여 Why\n[02:17.360]쫓아가기도 벅차 숨이 찬 세상이 전부는 아냐\n[02:22.100]하루 종일 걸어도 똑같은 풍경은 절대 보이지 않아\n[02:26.670]하얀 종이에 적어 본 Why 잉크처럼 번지는 맘\n[02:31.000]I\u2019m falling I\u2019m falling I\u2019m falling to you\n"}
     * klyric : {"version":0}
     * tlyric : {"version":0,"lyric":null}
     * code : 200
     */

    private boolean sgc;
    private boolean sfy;
    private boolean qfy;
    private LyricUserBean lyricUser;
    private LrcBean lrc;
    private KlyricBean klyric;
    private TlyricBean tlyric;
    private int code;

    public boolean isSgc() {
        return sgc;
    }

    public void setSgc(boolean sgc) {
        this.sgc = sgc;
    }

    public boolean isSfy() {
        return sfy;
    }

    public void setSfy(boolean sfy) {
        this.sfy = sfy;
    }

    public boolean isQfy() {
        return qfy;
    }

    public void setQfy(boolean qfy) {
        this.qfy = qfy;
    }

    public LyricUserBean getLyricUser() {
        return lyricUser;
    }

    public void setLyricUser(LyricUserBean lyricUser) {
        this.lyricUser = lyricUser;
    }

    public LrcBean getLrc() {
        return lrc;
    }

    public void setLrc(LrcBean lrc) {
        this.lrc = lrc;
    }

    public KlyricBean getKlyric() {
        return klyric;
    }

    public void setKlyric(KlyricBean klyric) {
        this.klyric = klyric;
    }

    public TlyricBean getTlyric() {
        return tlyric;
    }

    public void setTlyric(TlyricBean tlyric) {
        this.tlyric = tlyric;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class LyricUserBean {
        /**
         * id : 451441156
         * status : 0
         * demand : 0
         * userid : 251241884
         * nickname : 初茶mio
         * uptime : 1485250663863
         */

        private int id;
        private int status;
        private int demand;
        private int userid;
        private String nickname;
        private long uptime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getDemand() {
            return demand;
        }

        public void setDemand(int demand) {
            this.demand = demand;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getUptime() {
            return uptime;
        }

        public void setUptime(long uptime) {
            this.uptime = uptime;
        }
    }

    public static class LrcBean {
        /**
         * version : 3
         * lyric : [by:初茶mio]
         [00:03.320]Oh yeah yeah
         [00:08.270]Oh 언젠가는 내 두 발이 Oh 닿는 대로
         [00:13.040]이끌리는 시선을 뺏겨버린 대로
         [00:18.260]가볍게 걸어갈 낯선 곳을 그리다
         [00:22.620]또 결국엔 허전한 긴 한숨에 멈춰
         [00:27.020]Why, Why, 돌아서 또 넌
         [00:35.810]Why, Why, 꿈만 가득해
         [00:43.960]지금 떠난다면 Good, Good, Good, yeah
         [00:48.440]만나게 될 모든 건 Great, Great, yeah
         [00:52.510]가벼워진 맘이Work, Work, baby
         [00:57.320]이미 이미 눈 앞에
         [00:59.910]아른아른대는데 망설여 Why
         [01:04.020]나침반 위 돌아가던 바늘이
         [01:07.320]멈춘 곳에 가득 핀 이름 모를 꽃잎이
         [01:13.140]널 위해 끌어당긴 빛이 담긴 풍경 속에
         [01:17.560]어서 뛰어들어 나보다 자유롭게 더
         [01:22.310]Why, Why, Why, 괜히 미뤄 왔던 날
         [01:31.820]많았던 걱정이 모두 다 사라진 tonight yeah
         [01:39.140]바람 불어오면 Good, Good, Good, yeah
         [01:43.370]펼쳐지는 모든 건 Great, Great, yeah
         [01:47.360]달라지는 맘이 Work, Work, baby
         [01:52.360]이미 이미 눈 앞에
         [01:54.540]아른아른대는데
         [01:56.880]지금 떠난다면 Good, Good, Good, yeah
         [02:01.610]만나게 될 모든 건 Great, Great, yeah
         [02:05.990]가벼워진 맘이Work, Work, baby
         [02:10.530]이미 이미 눈 앞에
         [02:12.880]아른아른대는데 망설여 Why
         [02:17.360]쫓아가기도 벅차 숨이 찬 세상이 전부는 아냐
         [02:22.100]하루 종일 걸어도 똑같은 풍경은 절대 보이지 않아
         [02:26.670]하얀 종이에 적어 본 Why 잉크처럼 번지는 맘
         [02:31.000]I’m falling I’m falling I’m falling to you

         */

        private int version;
        private String lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getLyric() {
            return lyric;
        }

        public void setLyric(String lyric) {
            this.lyric = lyric;
        }
    }

    public static class KlyricBean {
        /**
         * version : 0
         */

        private int version;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

    public static class TlyricBean {
        /**
         * version : 0
         * lyric : null
         */

        private int version;
        private Object lyric;

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public Object getLyric() {
            return lyric;
        }

        public void setLyric(Object lyric) {
            this.lyric = lyric;
        }
    }
}
