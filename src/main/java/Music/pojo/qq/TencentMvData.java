package Music.pojo.qq;

import java.util.List;

/**
 * Created by qtfreet00 on 2017/2/6.
 */
public class TencentMvData {

    /**
     * dltype : 1
     * exem : 0
     * fl : {"cnt":2,"fi":[{"br":64,"cname":"标清;(270P)","fs":8102845,"id":11303,"lmt":0,"name":"sd","sb":1,"sl":1},{"br":20000,"cname":"高清;(360P)","fs":18523193,"id":11302,"lmt":0,"name":"hd","sb":1,"sl":0}]}
     * hs : 0
     * ip : 49.75.61.109
     * ls : 0
     * preview : 228
     * s : o
     * sfl : {"cnt":0}
     * tm : 1486385568
     * vl : {"cnt":1,"vi":[{"br":34,"ch":0,"cl":{"ci":[{"cd":"228.333","cmd5":"ceb777545423a07e7447c7d864dd9a45","cs":8102845,"idx":1,"keyid":"x0017riia2j.11303.1"}],"fc":1},"ct":21600,"drm":0,"dsb":0,"fclip":1,"fmd5":"ceb777545423a07e7447c7d864dd9a45","fn":"x0017riia2j.p1303.mp4","fs":8102845,"fst":5,"fvkey":"BDB593AB1B120F33F11F45DB7075010CCE4F4991E12F8A242CDF134151077A6A0734BB83E918F60C4E2EB4E2F67D8DB03E5158EFF92957434D14EC747D58BABC134CC8884EA7A4DE7DF2E19515E8E529ABE343C0AFCEB6777D7E93212FC9F1BE","hevc":0,"iflag":0,"level":0,"lnk":"x0017riia2j","logo":0,"pl":[{"cnt":2,"pd":[{"c":10,"cd":2,"fmt":40001,"fn":"q1","h":45,"r":10,"url":"http://video.qpic.cn/video_caps/0/","w":80},{"c":5,"cd":2,"fmt":40002,"fn":"q2","h":90,"r":5,"url":"http://video.qpic.cn/video_caps/0/","w":160}]}],"share":1,"sp":0,"st":2,"td":"228.333","ti":"Why","type":3584,"ul":{"ui":[{"dt":2,"dtc":10,"url":"http://61.155.143.143/music.qqvideo.tc.qq.com/","vt":210},{"dt":2,"dtc":10,"url":"http://61.155.143.142/music.qqvideo.tc.qq.com/","vt":210},{"dt":2,"dtc":10,"url":"http://video.dispatch.tc.qq.com/","vt":0}]},"vh":256,"vid":"x0017riia2j","videotype":22,"vst":2,"vw":360}]}
     */

    private int dltype;
    private int exem;
    private FlBean fl;
    private int hs;
    private String ip;
    private int ls;
    private int preview;
    private String s;
    private SflBean sfl;
    private int tm;
    private VlBean vl;

    public int getDltype() {
        return dltype;
    }

    public void setDltype(int dltype) {
        this.dltype = dltype;
    }

    public int getExem() {
        return exem;
    }

    public void setExem(int exem) {
        this.exem = exem;
    }

    public FlBean getFl() {
        return fl;
    }

    public void setFl(FlBean fl) {
        this.fl = fl;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getLs() {
        return ls;
    }

    public void setLs(int ls) {
        this.ls = ls;
    }

    public int getPreview() {
        return preview;
    }

    public void setPreview(int preview) {
        this.preview = preview;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public SflBean getSfl() {
        return sfl;
    }

    public void setSfl(SflBean sfl) {
        this.sfl = sfl;
    }

    public int getTm() {
        return tm;
    }

    public void setTm(int tm) {
        this.tm = tm;
    }

    public VlBean getVl() {
        return vl;
    }

    public void setVl(VlBean vl) {
        this.vl = vl;
    }

    public static class FlBean {
        /**
         * cnt : 2
         * fi : [{"br":64,"cname":"标清;(270P)","fs":8102845,"id":11303,"lmt":0,"name":"sd","sb":1,"sl":1},{"br":20000,"cname":"高清;(360P)","fs":18523193,"id":11302,"lmt":0,"name":"hd","sb":1,"sl":0}]
         */

        private int cnt;
        private List<FiBean> fi;

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public List<FiBean> getFi() {
            return fi;
        }

        public void setFi(List<FiBean> fi) {
            this.fi = fi;
        }

        public static class FiBean {
            /**
             * br : 64
             * cname : 标清;(270P)
             * fs : 8102845
             * id : 11303
             * lmt : 0
             * name : sd
             * sb : 1
             * sl : 1
             */

            private int br;
            private String cname;
            private int fs;
            private int id;
            private int lmt;
            private String name;
            private int sb;
            private int sl;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public int getFs() {
                return fs;
            }

            public void setFs(int fs) {
                this.fs = fs;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getLmt() {
                return lmt;
            }

            public void setLmt(int lmt) {
                this.lmt = lmt;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSb() {
                return sb;
            }

            public void setSb(int sb) {
                this.sb = sb;
            }

            public int getSl() {
                return sl;
            }

            public void setSl(int sl) {
                this.sl = sl;
            }
        }
    }

    public static class SflBean {
        /**
         * cnt : 0
         */

        private int cnt;

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }

    public static class VlBean {
        /**
         * cnt : 1
         * vi : [{"br":34,"ch":0,"cl":{"ci":[{"cd":"228.333","cmd5":"ceb777545423a07e7447c7d864dd9a45","cs":8102845,"idx":1,"keyid":"x0017riia2j.11303.1"}],"fc":1},"ct":21600,"drm":0,"dsb":0,"fclip":1,"fmd5":"ceb777545423a07e7447c7d864dd9a45","fn":"x0017riia2j.p1303.mp4","fs":8102845,"fst":5,"fvkey":"BDB593AB1B120F33F11F45DB7075010CCE4F4991E12F8A242CDF134151077A6A0734BB83E918F60C4E2EB4E2F67D8DB03E5158EFF92957434D14EC747D58BABC134CC8884EA7A4DE7DF2E19515E8E529ABE343C0AFCEB6777D7E93212FC9F1BE","hevc":0,"iflag":0,"level":0,"lnk":"x0017riia2j","logo":0,"pl":[{"cnt":2,"pd":[{"c":10,"cd":2,"fmt":40001,"fn":"q1","h":45,"r":10,"url":"http://video.qpic.cn/video_caps/0/","w":80},{"c":5,"cd":2,"fmt":40002,"fn":"q2","h":90,"r":5,"url":"http://video.qpic.cn/video_caps/0/","w":160}]}],"share":1,"sp":0,"st":2,"td":"228.333","ti":"Why","type":3584,"ul":{"ui":[{"dt":2,"dtc":10,"url":"http://61.155.143.143/music.qqvideo.tc.qq.com/","vt":210},{"dt":2,"dtc":10,"url":"http://61.155.143.142/music.qqvideo.tc.qq.com/","vt":210},{"dt":2,"dtc":10,"url":"http://video.dispatch.tc.qq.com/","vt":0}]},"vh":256,"vid":"x0017riia2j","videotype":22,"vst":2,"vw":360}]
         */

        private int cnt;
        private List<ViBean> vi;

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public List<ViBean> getVi() {
            return vi;
        }

        public void setVi(List<ViBean> vi) {
            this.vi = vi;
        }

        public static class ViBean {
            /**
             * br : 34
             * ch : 0
             * cl : {"ci":[{"cd":"228.333","cmd5":"ceb777545423a07e7447c7d864dd9a45","cs":8102845,"idx":1,"keyid":"x0017riia2j.11303.1"}],"fc":1}
             * ct : 21600
             * drm : 0
             * dsb : 0
             * fclip : 1
             * fmd5 : ceb777545423a07e7447c7d864dd9a45
             * fn : x0017riia2j.p1303.mp4
             * fs : 8102845
             * fst : 5
             * fvkey : BDB593AB1B120F33F11F45DB7075010CCE4F4991E12F8A242CDF134151077A6A0734BB83E918F60C4E2EB4E2F67D8DB03E5158EFF92957434D14EC747D58BABC134CC8884EA7A4DE7DF2E19515E8E529ABE343C0AFCEB6777D7E93212FC9F1BE
             * hevc : 0
             * iflag : 0
             * level : 0
             * lnk : x0017riia2j
             * logo : 0
             * pl : [{"cnt":2,"pd":[{"c":10,"cd":2,"fmt":40001,"fn":"q1","h":45,"r":10,"url":"http://video.qpic.cn/video_caps/0/","w":80},{"c":5,"cd":2,"fmt":40002,"fn":"q2","h":90,"r":5,"url":"http://video.qpic.cn/video_caps/0/","w":160}]}]
             * share : 1
             * sp : 0
             * st : 2
             * td : 228.333
             * ti : Why
             * type : 3584
             * ul : {"ui":[{"dt":2,"dtc":10,"url":"http://61.155.143.143/music.qqvideo.tc.qq.com/","vt":210},{"dt":2,"dtc":10,"url":"http://61.155.143.142/music.qqvideo.tc.qq.com/","vt":210},{"dt":2,"dtc":10,"url":"http://video.dispatch.tc.qq.com/","vt":0}]}
             * vh : 256
             * vid : x0017riia2j
             * videotype : 22
             * vst : 2
             * vw : 360
             */

            private int br;
            private int ch;
            private ClBean cl;
            private int ct;
            private int drm;
            private int dsb;
            private int fclip;
            private String fmd5;
            private String fn;
            private int fs;
            private int fst;
            private String fvkey;
            private int hevc;
            private int iflag;
            private int level;
            private String lnk;
            private int logo;
            private int share;
            private int sp;
            private int st;
            private String td;
            private String ti;
            private int type;
            private UlBean ul;
            private int vh;
            private String vid;
            private int videotype;
            private int vst;
            private int vw;
            private List<PlBean> pl;

            public int getBr() {
                return br;
            }

            public void setBr(int br) {
                this.br = br;
            }

            public int getCh() {
                return ch;
            }

            public void setCh(int ch) {
                this.ch = ch;
            }

            public ClBean getCl() {
                return cl;
            }

            public void setCl(ClBean cl) {
                this.cl = cl;
            }

            public int getCt() {
                return ct;
            }

            public void setCt(int ct) {
                this.ct = ct;
            }

            public int getDrm() {
                return drm;
            }

            public void setDrm(int drm) {
                this.drm = drm;
            }

            public int getDsb() {
                return dsb;
            }

            public void setDsb(int dsb) {
                this.dsb = dsb;
            }

            public int getFclip() {
                return fclip;
            }

            public void setFclip(int fclip) {
                this.fclip = fclip;
            }

            public String getFmd5() {
                return fmd5;
            }

            public void setFmd5(String fmd5) {
                this.fmd5 = fmd5;
            }

            public String getFn() {
                return fn;
            }

            public void setFn(String fn) {
                this.fn = fn;
            }

            public int getFs() {
                return fs;
            }

            public void setFs(int fs) {
                this.fs = fs;
            }

            public int getFst() {
                return fst;
            }

            public void setFst(int fst) {
                this.fst = fst;
            }

            public String getFvkey() {
                return fvkey;
            }

            public void setFvkey(String fvkey) {
                this.fvkey = fvkey;
            }

            public int getHevc() {
                return hevc;
            }

            public void setHevc(int hevc) {
                this.hevc = hevc;
            }

            public int getIflag() {
                return iflag;
            }

            public void setIflag(int iflag) {
                this.iflag = iflag;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getLnk() {
                return lnk;
            }

            public void setLnk(String lnk) {
                this.lnk = lnk;
            }

            public int getLogo() {
                return logo;
            }

            public void setLogo(int logo) {
                this.logo = logo;
            }

            public int getShare() {
                return share;
            }

            public void setShare(int share) {
                this.share = share;
            }

            public int getSp() {
                return sp;
            }

            public void setSp(int sp) {
                this.sp = sp;
            }

            public int getSt() {
                return st;
            }

            public void setSt(int st) {
                this.st = st;
            }

            public String getTd() {
                return td;
            }

            public void setTd(String td) {
                this.td = td;
            }

            public String getTi() {
                return ti;
            }

            public void setTi(String ti) {
                this.ti = ti;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public UlBean getUl() {
                return ul;
            }

            public void setUl(UlBean ul) {
                this.ul = ul;
            }

            public int getVh() {
                return vh;
            }

            public void setVh(int vh) {
                this.vh = vh;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public int getVideotype() {
                return videotype;
            }

            public void setVideotype(int videotype) {
                this.videotype = videotype;
            }

            public int getVst() {
                return vst;
            }

            public void setVst(int vst) {
                this.vst = vst;
            }

            public int getVw() {
                return vw;
            }

            public void setVw(int vw) {
                this.vw = vw;
            }

            public List<PlBean> getPl() {
                return pl;
            }

            public void setPl(List<PlBean> pl) {
                this.pl = pl;
            }

            public static class ClBean {
                /**
                 * ci : [{"cd":"228.333","cmd5":"ceb777545423a07e7447c7d864dd9a45","cs":8102845,"idx":1,"keyid":"x0017riia2j.11303.1"}]
                 * fc : 1
                 */

                private int fc;
                private List<CiBean> ci;

                public int getFc() {
                    return fc;
                }

                public void setFc(int fc) {
                    this.fc = fc;
                }

                public List<CiBean> getCi() {
                    return ci;
                }

                public void setCi(List<CiBean> ci) {
                    this.ci = ci;
                }

                public static class CiBean {
                    /**
                     * cd : 228.333
                     * cmd5 : ceb777545423a07e7447c7d864dd9a45
                     * cs : 8102845
                     * idx : 1
                     * keyid : x0017riia2j.11303.1
                     */

                    private String cd;
                    private String cmd5;
                    private int cs;
                    private int idx;
                    private String keyid;

                    public String getCd() {
                        return cd;
                    }

                    public void setCd(String cd) {
                        this.cd = cd;
                    }

                    public String getCmd5() {
                        return cmd5;
                    }

                    public void setCmd5(String cmd5) {
                        this.cmd5 = cmd5;
                    }

                    public int getCs() {
                        return cs;
                    }

                    public void setCs(int cs) {
                        this.cs = cs;
                    }

                    public int getIdx() {
                        return idx;
                    }

                    public void setIdx(int idx) {
                        this.idx = idx;
                    }

                    public String getKeyid() {
                        return keyid;
                    }

                    public void setKeyid(String keyid) {
                        this.keyid = keyid;
                    }
                }
            }

            public static class UlBean {
                private List<UiBean> ui;

                public List<UiBean> getUi() {
                    return ui;
                }

                public void setUi(List<UiBean> ui) {
                    this.ui = ui;
                }

                public static class UiBean {
                    /**
                     * dt : 2
                     * dtc : 10
                     * url : http://61.155.143.143/music.qqvideo.tc.qq.com/
                     * vt : 210
                     */

                    private int dt;
                    private int dtc;
                    private String url;
                    private int vt;

                    public int getDt() {
                        return dt;
                    }

                    public void setDt(int dt) {
                        this.dt = dt;
                    }

                    public int getDtc() {
                        return dtc;
                    }

                    public void setDtc(int dtc) {
                        this.dtc = dtc;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getVt() {
                        return vt;
                    }

                    public void setVt(int vt) {
                        this.vt = vt;
                    }
                }
            }

            public static class PlBean {
                /**
                 * cnt : 2
                 * pd : [{"c":10,"cd":2,"fmt":40001,"fn":"q1","h":45,"r":10,"url":"http://video.qpic.cn/video_caps/0/","w":80},{"c":5,"cd":2,"fmt":40002,"fn":"q2","h":90,"r":5,"url":"http://video.qpic.cn/video_caps/0/","w":160}]
                 */

                private int cnt;
                private List<PdBean> pd;

                public int getCnt() {
                    return cnt;
                }

                public void setCnt(int cnt) {
                    this.cnt = cnt;
                }

                public List<PdBean> getPd() {
                    return pd;
                }

                public void setPd(List<PdBean> pd) {
                    this.pd = pd;
                }

                public static class PdBean {
                    /**
                     * c : 10
                     * cd : 2
                     * fmt : 40001
                     * fn : q1
                     * h : 45
                     * r : 10
                     * url : http://video.qpic.cn/video_caps/0/
                     * w : 80
                     */

                    private int c;
                    private int cd;
                    private int fmt;
                    private String fn;
                    private int h;
                    private int r;
                    private String url;
                    private int w;

                    public int getC() {
                        return c;
                    }

                    public void setC(int c) {
                        this.c = c;
                    }

                    public int getCd() {
                        return cd;
                    }

                    public void setCd(int cd) {
                        this.cd = cd;
                    }

                    public int getFmt() {
                        return fmt;
                    }

                    public void setFmt(int fmt) {
                        this.fmt = fmt;
                    }

                    public String getFn() {
                        return fn;
                    }

                    public void setFn(String fn) {
                        this.fn = fn;
                    }

                    public int getH() {
                        return h;
                    }

                    public void setH(int h) {
                        this.h = h;
                    }

                    public int getR() {
                        return r;
                    }

                    public void setR(int r) {
                        this.r = r;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public int getW() {
                        return w;
                    }

                    public void setW(int w) {
                        this.w = w;
                    }
                }
            }
        }
    }
}
