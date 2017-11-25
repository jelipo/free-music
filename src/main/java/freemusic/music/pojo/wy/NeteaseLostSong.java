package freemusic.music.pojo.wy;

import java.util.List;

/**
 * Created by qtfreet on 2017/2/6.
 */
public class NeteaseLostSong {
    private int code;
    private AlbumBeanX album;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AlbumBeanX getAlbum() {
        return album;
    }

    public void setAlbum(AlbumBeanX album) {
        this.album = album;
    }

    public static class AlbumBeanX {
        private boolean paid;
        private boolean onSale;
        private String commentThreadId;
        private long picId;
        private String briefDesc;
        private long publishTime;
        private String company;
        private ArtistBean artist;
        private String picUrl;
        private int copyrightId;
        private int status;
        private String blurPicUrl;
        private int companyId;
        private long pic;
        private String tags;
        private String description;
        private String subType;
        private String name;
        private int id;
        private String type;
        private int size;
        private InfoBean info;
        private List<SongsBean> songs;
        private List<ArtistsBeanXX> artists;
        private List<String> alias;

        public static class ArtistBean {
            private long img1v1Id;
            private int topicPerson;
            private long picId;
            private String briefDesc;
            private int albumSize;
            private String img1v1Url;
            private String trans;
            private String picUrl;
            private int musicSize;
            private String name;
            private int id;
            private String picId_str;
            private String img1v1Id_str;
            private List<?> alias;
            private List<String> transNames;

        }

        public static class InfoBean {
            private Object latestLikedUsers;
            private boolean liked;
            private Object comments;
            private int resourceType;
            private int resourceId;
            private int commentCount;
            private int shareCount;
            private int likedCount;
            private String threadId;
        }

        public static class SongsBean {

            private boolean starred;
            private double popularity;
            private int starredNum;
            private int playedNum;
            private int dayPlays;
            private int hearTime;
            private String mp3Url;
            private Object rtUrls;
            private int fee;
            private String commentThreadId;
            private HMusicBean hMusic;
            private MMusicBean mMusic;
            private LMusicBean lMusic;
            private AlbumBean album;
            private int mvid;
            private int ftype;
            private int rtype;
            private Object rurl;
            private String copyFrom;
            private int score;
            private int copyrightId;
            private int status;
            private String disc;
            private Object crbt;
            private BMusicBean bMusic;
            private Object rtUrl;
            private int position;
            private int duration;
            private Object audition;
            private Object ringtone;
            private int no;
            private String name;
            private int id;
            private List<ArtistsBeanX> artists;
            private List<?> alias;
            private List<String> transNames;

            public static class HMusicBean {

                private int playTime;
                private int bitrate;
                private long dfsId;
                private int sr;
                private double volumeDelta;
                private Object name;
                private int id;
                private int size;
                private String extension;
                private String dfsId_str;
            }

            public static class MMusicBean {
                private int playTime;
                private int bitrate;
                private long dfsId;
                private int sr;
                private double volumeDelta;
                private Object name;
                private int id;
                private int size;
                private String extension;
            }

            public static class LMusicBean {
                private int playTime;
                private int bitrate;
                private long dfsId;
                private int sr;
                private double volumeDelta;
                private Object name;
                private int id;
                private int size;
                private String extension;
                private String dfsId_str;
            }

            public static class AlbumBean {

                private boolean paid;
                private boolean onSale;
                private String commentThreadId;
                private long picId;
                private String briefDesc;
                private long publishTime;
                private String company;
                private ArtistBeanX artist;
                private String picUrl;
                private int copyrightId;
                private int status;
                private String blurPicUrl;
                private int companyId;
                private long pic;
                private String tags;
                private String description;
                private String subType;
                private String name;
                private int id;
                private String type;
                private int size;
                private List<?> songs;
                private List<ArtistsBean> artists;
                private List<String> alias;

                public static class ArtistBeanX {
                    private long img1v1Id;
                    private int topicPerson;
                    private int picId;
                    private String briefDesc;
                    private int albumSize;
                    private String img1v1Url;
                    private String trans;
                    private String picUrl;
                    private int musicSize;
                    private String name;
                    private int id;
                    private String img1v1Id_str;
                    private List<?> alias;
                }

                public static class ArtistsBean {
                    private long img1v1Id;
                    private int topicPerson;
                    private int picId;
                    private String briefDesc;
                    private int albumSize;
                    private String img1v1Url;
                    private String trans;
                    private String picUrl;
                    private int musicSize;
                    private String name;
                    private int id;
                    private String img1v1Id_str;
                    private List<?> alias;

                }
            }

            public static class BMusicBean {
                private int playTime;
                private int bitrate;
                private long dfsId;
                private int sr;
                private double volumeDelta;
                private Object name;
                private int id;
                private int size;
                private String extension;
                private String dfsId_str;

            }

            public static class ArtistsBeanX {
                private long img1v1Id;
                private int topicPerson;
                private int picId;
                private String briefDesc;
                private int albumSize;
                private String img1v1Url;
                private String trans;
                private String picUrl;
                private int musicSize;
                private String name;
                private int id;
                private String img1v1Id_str;
                private List<?> alias;
            }
        }

        public static class ArtistsBeanXX {
            private long img1v1Id;
            private int topicPerson;
            private int picId;
            private String briefDesc;
            private int albumSize;
            private String img1v1Url;
            private String trans;
            private String picUrl;
            private int musicSize;
            private String name;
            private int id;
            private String img1v1Id_str;
            private List<?> alias;
        }
    }
}
