package freemusic.music.pojo.qq;

import java.util.List;


public class TencentMvData {

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
    public static class FlBean {
        private int cnt;
        private List<FiBean> fi;
        public static class FiBean {
            private int br;
            private String cname;
            private int fs;
            private int id;
            private int lmt;
            private String name;
            private int sb;
            private int sl;
        }
    }
    private static class SflBean {
        private int cnt;
    }

    public static class VlBean {
        private int cnt;
        private List<ViBean> vi;
        static class ViBean {
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
            static class ClBean {
                private int fc;
                private List<CiBean> ci;
                static class CiBean {
                    private String cd;
                    private String cmd5;
                    private int cs;
                    private int idx;
                    private String keyid;

                }
            }

            static class UlBean {
                private List<UiBean> ui;
                static class UiBean {
                    private int dt;
                    private int dtc;
                    private String url;
                    private int vt;

                }
            }
            static class PlBean {
                private int cnt;
                private List<PdBean> pd;
                static class PdBean {
                    private int c;
                    private int cd;
                    private int fmt;
                    private String fn;
                    private int h;
                    private int r;
                    private String url;
                    private int w;
                }
            }
        }
    }
}
