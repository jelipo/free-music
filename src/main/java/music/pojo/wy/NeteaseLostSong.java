package music.pojo.wy;

import java.util.List;

/**
 * Created by qtfreet on 2017/2/6.
 */
public class NeteaseLostSong {

    /**
     * code : 200
     * album : {"songs":[{"starred":false,"popularity":100,"starredNum":0,"playedNum":0,"dayPlays":0,"hearTime":0,"mp3Url":"http://m2.music.126.net/l41ucoza0ZMTrXHi2iE0gQ==/18633423557585526.mp3","rtUrls":null,"artists":[{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"},{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"金泰妍","id":125506,"img1v1Id_str":"18686200114669622"}],"fee":0,"commentThreadId":"R_SO_4_400875361","hMusic":{"playTime":219106,"bitrate":320000,"dfsId":18609234301768452,"sr":44100,"volumeDelta":-2.8,"name":null,"id":1262608754,"size":8766738,"extension":"mp3","dfsId_str":"18609234301768452"},"mMusic":{"playTime":219106,"bitrate":160000,"dfsId":3393092927059089,"sr":44100,"volumeDelta":-2.38,"name":null,"id":1262608755,"size":4383392,"extension":"mp3"},"lMusic":{"playTime":219106,"bitrate":96000,"dfsId":18633423557585526,"sr":44100,"volumeDelta":-2.4,"name":null,"id":1262608756,"size":2630053,"extension":"mp3","dfsId_str":"18633423557585526"},"album":{"songs":[],"paid":false,"onSale":false,"artists":[{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"}],"commentThreadId":"R_AL_3_34438064","picId":6664139977735905,"briefDesc":"","publishTime":1453392000007,"company":"(주)로엔엔터테인먼트","artist":{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"","id":0,"img1v1Id_str":"18686200114669622"},"picUrl":"http://p4.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","copyrightId":18001,"status":0,"blurPicUrl":"http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","companyId":0,"pic":6664139977735905,"tags":"","description":"","subType":"录音室版","alias":["不要忘记"],"name":"잊어버리지마","id":34438064,"type":"EP/Single","size":1},"mvid":5281043,"ftype":0,"rtype":0,"rurl":null,"copyFrom":"","score":100,"copyrightId":18001,"status":0,"disc":"1","crbt":null,"bMusic":{"playTime":219106,"bitrate":96000,"dfsId":18633423557585526,"sr":44100,"volumeDelta":-2.4,"name":null,"id":1262608756,"size":2630053,"extension":"mp3","dfsId_str":"18633423557585526"},"rtUrl":null,"position":1,"duration":219106,"alias":[],"audition":null,"ringtone":null,"no":1,"name":"잊어버리지마","id":400875361,"transNames":["不要忘记"]}],"paid":false,"onSale":false,"artists":[{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"}],"commentThreadId":"R_AL_3_34438064","picId":6664139977735905,"briefDesc":"","publishTime":1453392000007,"company":"(주)로엔엔터테인먼트","artist":{"img1v1Id":18686200114669622,"topicPerson":0,"picId":18778559092490316,"briefDesc":"","albumSize":15,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"크러쉬","picUrl":"http://p3.music.126.net/5dUPF7aBNhlYhyRrEYFFvg==/18778559092490316.jpg","musicSize":91,"alias":[],"name":"Crush","id":711186,"picId_str":"18778559092490316","transNames":["크러쉬"],"img1v1Id_str":"18686200114669622"},"picUrl":"http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","copyrightId":18001,"status":0,"blurPicUrl":"http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","companyId":0,"pic":6664139977735905,"tags":"","description":"","subType":"录音室版","alias":["不要忘记"],"name":"잊어버리지마","id":34438064,"type":"EP/Single","size":1,"info":{"latestLikedUsers":null,"liked":false,"comments":null,"resourceType":3,"resourceId":34438064,"commentCount":68,"shareCount":17,"likedCount":0,"threadId":"R_AL_3_34438064"}}
     */

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
        /**
         * songs : [{"starred":false,"popularity":100,"starredNum":0,"playedNum":0,"dayPlays":0,"hearTime":0,"mp3Url":"http://m2.music.126.net/l41ucoza0ZMTrXHi2iE0gQ==/18633423557585526.mp3","rtUrls":null,"artists":[{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"},{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"金泰妍","id":125506,"img1v1Id_str":"18686200114669622"}],"fee":0,"commentThreadId":"R_SO_4_400875361","hMusic":{"playTime":219106,"bitrate":320000,"dfsId":18609234301768452,"sr":44100,"volumeDelta":-2.8,"name":null,"id":1262608754,"size":8766738,"extension":"mp3","dfsId_str":"18609234301768452"},"mMusic":{"playTime":219106,"bitrate":160000,"dfsId":3393092927059089,"sr":44100,"volumeDelta":-2.38,"name":null,"id":1262608755,"size":4383392,"extension":"mp3"},"lMusic":{"playTime":219106,"bitrate":96000,"dfsId":18633423557585526,"sr":44100,"volumeDelta":-2.4,"name":null,"id":1262608756,"size":2630053,"extension":"mp3","dfsId_str":"18633423557585526"},"album":{"songs":[],"paid":false,"onSale":false,"artists":[{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"}],"commentThreadId":"R_AL_3_34438064","picId":6664139977735905,"briefDesc":"","publishTime":1453392000007,"company":"(주)로엔엔터테인먼트","artist":{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"","id":0,"img1v1Id_str":"18686200114669622"},"picUrl":"http://p4.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","copyrightId":18001,"status":0,"blurPicUrl":"http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","companyId":0,"pic":6664139977735905,"tags":"","description":"","subType":"录音室版","alias":["不要忘记"],"name":"잊어버리지마","id":34438064,"type":"EP/Single","size":1},"mvid":5281043,"ftype":0,"rtype":0,"rurl":null,"copyFrom":"","score":100,"copyrightId":18001,"status":0,"disc":"1","crbt":null,"bMusic":{"playTime":219106,"bitrate":96000,"dfsId":18633423557585526,"sr":44100,"volumeDelta":-2.4,"name":null,"id":1262608756,"size":2630053,"extension":"mp3","dfsId_str":"18633423557585526"},"rtUrl":null,"position":1,"duration":219106,"alias":[],"audition":null,"ringtone":null,"no":1,"name":"잊어버리지마","id":400875361,"transNames":["不要忘记"]}]
         * paid : false
         * onSale : false
         * artists : [{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"}]
         * commentThreadId : R_AL_3_34438064
         * picId : 6664139977735905
         * briefDesc :
         * publishTime : 1453392000007
         * company : (주)로엔엔터테인먼트
         * artist : {"img1v1Id":18686200114669622,"topicPerson":0,"picId":18778559092490316,"briefDesc":"","albumSize":15,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"크러쉬","picUrl":"http://p3.music.126.net/5dUPF7aBNhlYhyRrEYFFvg==/18778559092490316.jpg","musicSize":91,"alias":[],"name":"Crush","id":711186,"picId_str":"18778559092490316","transNames":["크러쉬"],"img1v1Id_str":"18686200114669622"}
         * picUrl : http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg
         * copyrightId : 18001
         * status : 0
         * blurPicUrl : http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg
         * companyId : 0
         * pic : 6664139977735905
         * tags :
         * description :
         * subType : 录音室版
         * alias : ["不要忘记"]
         * name : 잊어버리지마
         * id : 34438064
         * type : EP/Single
         * size : 1
         * info : {"latestLikedUsers":null,"liked":false,"comments":null,"resourceType":3,"resourceId":34438064,"commentCount":68,"shareCount":17,"likedCount":0,"threadId":"R_AL_3_34438064"}
         */

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

        public boolean isPaid() {
            return paid;
        }

        public void setPaid(boolean paid) {
            this.paid = paid;
        }

        public boolean isOnSale() {
            return onSale;
        }

        public void setOnSale(boolean onSale) {
            this.onSale = onSale;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public long getPicId() {
            return picId;
        }

        public void setPicId(long picId) {
            this.picId = picId;
        }

        public String getBriefDesc() {
            return briefDesc;
        }

        public void setBriefDesc(String briefDesc) {
            this.briefDesc = briefDesc;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public ArtistBean getArtist() {
            return artist;
        }

        public void setArtist(ArtistBean artist) {
            this.artist = artist;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public int getCopyrightId() {
            return copyrightId;
        }

        public void setCopyrightId(int copyrightId) {
            this.copyrightId = copyrightId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getBlurPicUrl() {
            return blurPicUrl;
        }

        public void setBlurPicUrl(String blurPicUrl) {
            this.blurPicUrl = blurPicUrl;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public long getPic() {
            return pic;
        }

        public void setPic(long pic) {
            this.pic = pic;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSubType() {
            return subType;
        }

        public void setSubType(String subType) {
            this.subType = subType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public List<ArtistsBeanXX> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBeanXX> artists) {
            this.artists = artists;
        }

        public List<String> getAlias() {
            return alias;
        }

        public void setAlias(List<String> alias) {
            this.alias = alias;
        }

        public static class ArtistBean {
            /**
             * img1v1Id : 18686200114669622
             * topicPerson : 0
             * picId : 18778559092490316
             * briefDesc :
             * albumSize : 15
             * img1v1Url : http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * trans : 크러쉬
             * picUrl : http://p3.music.126.net/5dUPF7aBNhlYhyRrEYFFvg==/18778559092490316.jpg
             * musicSize : 91
             * alias : []
             * name : Crush
             * id : 711186
             * picId_str : 18778559092490316
             * transNames : ["크러쉬"]
             * img1v1Id_str : 18686200114669622
             */

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

            public long getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(long img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public int getTopicPerson() {
                return topicPerson;
            }

            public void setTopicPerson(int topicPerson) {
                this.topicPerson = topicPerson;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPicId_str() {
                return picId_str;
            }

            public void setPicId_str(String picId_str) {
                this.picId_str = picId_str;
            }

            public String getImg1v1Id_str() {
                return img1v1Id_str;
            }

            public void setImg1v1Id_str(String img1v1Id_str) {
                this.img1v1Id_str = img1v1Id_str;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<String> getTransNames() {
                return transNames;
            }

            public void setTransNames(List<String> transNames) {
                this.transNames = transNames;
            }
        }

        public static class InfoBean {
            /**
             * latestLikedUsers : null
             * liked : false
             * comments : null
             * resourceType : 3
             * resourceId : 34438064
             * commentCount : 68
             * shareCount : 17
             * likedCount : 0
             * threadId : R_AL_3_34438064
             */

            private Object latestLikedUsers;
            private boolean liked;
            private Object comments;
            private int resourceType;
            private int resourceId;
            private int commentCount;
            private int shareCount;
            private int likedCount;
            private String threadId;

            public Object getLatestLikedUsers() {
                return latestLikedUsers;
            }

            public void setLatestLikedUsers(Object latestLikedUsers) {
                this.latestLikedUsers = latestLikedUsers;
            }

            public boolean isLiked() {
                return liked;
            }

            public void setLiked(boolean liked) {
                this.liked = liked;
            }

            public Object getComments() {
                return comments;
            }

            public void setComments(Object comments) {
                this.comments = comments;
            }

            public int getResourceType() {
                return resourceType;
            }

            public void setResourceType(int resourceType) {
                this.resourceType = resourceType;
            }

            public int getResourceId() {
                return resourceId;
            }

            public void setResourceId(int resourceId) {
                this.resourceId = resourceId;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public int getShareCount() {
                return shareCount;
            }

            public void setShareCount(int shareCount) {
                this.shareCount = shareCount;
            }

            public int getLikedCount() {
                return likedCount;
            }

            public void setLikedCount(int likedCount) {
                this.likedCount = likedCount;
            }

            public String getThreadId() {
                return threadId;
            }

            public void setThreadId(String threadId) {
                this.threadId = threadId;
            }
        }

        public static class SongsBean {
            /**
             * starred : false
             * popularity : 100.0
             * starredNum : 0
             * playedNum : 0
             * dayPlays : 0
             * hearTime : 0
             * mp3Url : http://m2.music.126.net/l41ucoza0ZMTrXHi2iE0gQ==/18633423557585526.mp3
             * rtUrls : null
             * artists : [{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"},{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"金泰妍","id":125506,"img1v1Id_str":"18686200114669622"}]
             * fee : 0
             * commentThreadId : R_SO_4_400875361
             * hMusic : {"playTime":219106,"bitrate":320000,"dfsId":18609234301768452,"sr":44100,"volumeDelta":-2.8,"name":null,"id":1262608754,"size":8766738,"extension":"mp3","dfsId_str":"18609234301768452"}
             * mMusic : {"playTime":219106,"bitrate":160000,"dfsId":3393092927059089,"sr":44100,"volumeDelta":-2.38,"name":null,"id":1262608755,"size":4383392,"extension":"mp3"}
             * lMusic : {"playTime":219106,"bitrate":96000,"dfsId":18633423557585526,"sr":44100,"volumeDelta":-2.4,"name":null,"id":1262608756,"size":2630053,"extension":"mp3","dfsId_str":"18633423557585526"}
             * album : {"songs":[],"paid":false,"onSale":false,"artists":[{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"}],"commentThreadId":"R_AL_3_34438064","picId":6664139977735905,"briefDesc":"","publishTime":1453392000007,"company":"(주)로엔엔터테인먼트","artist":{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"","id":0,"img1v1Id_str":"18686200114669622"},"picUrl":"http://p4.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","copyrightId":18001,"status":0,"blurPicUrl":"http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg","companyId":0,"pic":6664139977735905,"tags":"","description":"","subType":"录音室版","alias":["不要忘记"],"name":"잊어버리지마","id":34438064,"type":"EP/Single","size":1}
             * mvid : 5281043
             * ftype : 0
             * rtype : 0
             * rurl : null
             * copyFrom :
             * score : 100
             * copyrightId : 18001
             * status : 0
             * disc : 1
             * crbt : null
             * bMusic : {"playTime":219106,"bitrate":96000,"dfsId":18633423557585526,"sr":44100,"volumeDelta":-2.4,"name":null,"id":1262608756,"size":2630053,"extension":"mp3","dfsId_str":"18633423557585526"}
             * rtUrl : null
             * position : 1
             * duration : 219106
             * alias : []
             * audition : null
             * ringtone : null
             * no : 1
             * name : 잊어버리지마
             * id : 400875361
             * transNames : ["不要忘记"]
             */

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

            public boolean isStarred() {
                return starred;
            }

            public void setStarred(boolean starred) {
                this.starred = starred;
            }

            public double getPopularity() {
                return popularity;
            }

            public void setPopularity(double popularity) {
                this.popularity = popularity;
            }

            public int getStarredNum() {
                return starredNum;
            }

            public void setStarredNum(int starredNum) {
                this.starredNum = starredNum;
            }

            public int getPlayedNum() {
                return playedNum;
            }

            public void setPlayedNum(int playedNum) {
                this.playedNum = playedNum;
            }

            public int getDayPlays() {
                return dayPlays;
            }

            public void setDayPlays(int dayPlays) {
                this.dayPlays = dayPlays;
            }

            public int getHearTime() {
                return hearTime;
            }

            public void setHearTime(int hearTime) {
                this.hearTime = hearTime;
            }

            public String getMp3Url() {
                return mp3Url;
            }

            public void setMp3Url(String mp3Url) {
                this.mp3Url = mp3Url;
            }

            public Object getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(Object rtUrls) {
                this.rtUrls = rtUrls;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public HMusicBean getHMusic() {
                return hMusic;
            }

            public void setHMusic(HMusicBean hMusic) {
                this.hMusic = hMusic;
            }

            public MMusicBean getMMusic() {
                return mMusic;
            }

            public void setMMusic(MMusicBean mMusic) {
                this.mMusic = mMusic;
            }

            public LMusicBean getLMusic() {
                return lMusic;
            }

            public void setLMusic(LMusicBean lMusic) {
                this.lMusic = lMusic;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public int getMvid() {
                return mvid;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public String getCopyFrom() {
                return copyFrom;
            }

            public void setCopyFrom(String copyFrom) {
                this.copyFrom = copyFrom;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getDisc() {
                return disc;
            }

            public void setDisc(String disc) {
                this.disc = disc;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public BMusicBean getBMusic() {
                return bMusic;
            }

            public void setBMusic(BMusicBean bMusic) {
                this.bMusic = bMusic;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public Object getAudition() {
                return audition;
            }

            public void setAudition(Object audition) {
                this.audition = audition;
            }

            public Object getRingtone() {
                return ringtone;
            }

            public void setRingtone(Object ringtone) {
                this.ringtone = ringtone;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<ArtistsBeanX> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBeanX> artists) {
                this.artists = artists;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<String> getTransNames() {
                return transNames;
            }

            public void setTransNames(List<String> transNames) {
                this.transNames = transNames;
            }

            public static class HMusicBean {
                /**
                 * playTime : 219106
                 * bitrate : 320000
                 * dfsId : 18609234301768452
                 * sr : 44100
                 * volumeDelta : -2.8
                 * name : null
                 * id : 1262608754
                 * size : 8766738
                 * extension : mp3
                 * dfsId_str : 18609234301768452
                 */

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

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public String getDfsId_str() {
                    return dfsId_str;
                }

                public void setDfsId_str(String dfsId_str) {
                    this.dfsId_str = dfsId_str;
                }
            }

            public static class MMusicBean {
                /**
                 * playTime : 219106
                 * bitrate : 160000
                 * dfsId : 3393092927059089
                 * sr : 44100
                 * volumeDelta : -2.38
                 * name : null
                 * id : 1262608755
                 * size : 4383392
                 * extension : mp3
                 */

                private int playTime;
                private int bitrate;
                private long dfsId;
                private int sr;
                private double volumeDelta;
                private Object name;
                private int id;
                private int size;
                private String extension;

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }
            }

            public static class LMusicBean {
                /**
                 * playTime : 219106
                 * bitrate : 96000
                 * dfsId : 18633423557585526
                 * sr : 44100
                 * volumeDelta : -2.4
                 * name : null
                 * id : 1262608756
                 * size : 2630053
                 * extension : mp3
                 * dfsId_str : 18633423557585526
                 */

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

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public String getDfsId_str() {
                    return dfsId_str;
                }

                public void setDfsId_str(String dfsId_str) {
                    this.dfsId_str = dfsId_str;
                }
            }

            public static class AlbumBean {
                /**
                 * songs : []
                 * paid : false
                 * onSale : false
                 * artists : [{"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"Crush","id":711186,"img1v1Id_str":"18686200114669622"}]
                 * commentThreadId : R_AL_3_34438064
                 * picId : 6664139977735905
                 * briefDesc :
                 * publishTime : 1453392000007
                 * company : (주)로엔엔터테인먼트
                 * artist : {"img1v1Id":18686200114669622,"topicPerson":0,"picId":0,"briefDesc":"","albumSize":0,"img1v1Url":"http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg","trans":"","picUrl":"","musicSize":0,"alias":[],"name":"","id":0,"img1v1Id_str":"18686200114669622"}
                 * picUrl : http://p4.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg
                 * copyrightId : 18001
                 * status : 0
                 * blurPicUrl : http://p3.music.126.net/_mSHo891adnUsAyF3Rg7WQ==/6664139977735905.jpg
                 * companyId : 0
                 * pic : 6664139977735905
                 * tags :
                 * description :
                 * subType : 录音室版
                 * alias : ["不要忘记"]
                 * name : 잊어버리지마
                 * id : 34438064
                 * type : EP/Single
                 * size : 1
                 */

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

                public boolean isPaid() {
                    return paid;
                }

                public void setPaid(boolean paid) {
                    this.paid = paid;
                }

                public boolean isOnSale() {
                    return onSale;
                }

                public void setOnSale(boolean onSale) {
                    this.onSale = onSale;
                }

                public String getCommentThreadId() {
                    return commentThreadId;
                }

                public void setCommentThreadId(String commentThreadId) {
                    this.commentThreadId = commentThreadId;
                }

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(long publishTime) {
                    this.publishTime = publishTime;
                }

                public String getCompany() {
                    return company;
                }

                public void setCompany(String company) {
                    this.company = company;
                }

                public ArtistBeanX getArtist() {
                    return artist;
                }

                public void setArtist(ArtistBeanX artist) {
                    this.artist = artist;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getBlurPicUrl() {
                    return blurPicUrl;
                }

                public void setBlurPicUrl(String blurPicUrl) {
                    this.blurPicUrl = blurPicUrl;
                }

                public int getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(int companyId) {
                    this.companyId = companyId;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }

                public String getTags() {
                    return tags;
                }

                public void setTags(String tags) {
                    this.tags = tags;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getSubType() {
                    return subType;
                }

                public void setSubType(String subType) {
                    this.subType = subType;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public List<?> getSongs() {
                    return songs;
                }

                public void setSongs(List<?> songs) {
                    this.songs = songs;
                }

                public List<ArtistsBean> getArtists() {
                    return artists;
                }

                public void setArtists(List<ArtistsBean> artists) {
                    this.artists = artists;
                }

                public List<String> getAlias() {
                    return alias;
                }

                public void setAlias(List<String> alias) {
                    this.alias = alias;
                }

                public static class ArtistBeanX {
                    /**
                     * img1v1Id : 18686200114669622
                     * topicPerson : 0
                     * picId : 0
                     * briefDesc :
                     * albumSize : 0
                     * img1v1Url : http://p3.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
                     * trans :
                     * picUrl :
                     * musicSize : 0
                     * alias : []
                     * name :
                     * id : 0
                     * img1v1Id_str : 18686200114669622
                     */

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

                    public long getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(long img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public int getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(int topicPerson) {
                        this.topicPerson = topicPerson;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getImg1v1Id_str() {
                        return img1v1Id_str;
                    }

                    public void setImg1v1Id_str(String img1v1Id_str) {
                        this.img1v1Id_str = img1v1Id_str;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }

                public static class ArtistsBean {
                    /**
                     * img1v1Id : 18686200114669622
                     * topicPerson : 0
                     * picId : 0
                     * briefDesc :
                     * albumSize : 0
                     * img1v1Url : http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
                     * trans :
                     * picUrl :
                     * musicSize : 0
                     * alias : []
                     * name : Crush
                     * id : 711186
                     * img1v1Id_str : 18686200114669622
                     */

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

                    public long getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(long img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public int getTopicPerson() {
                        return topicPerson;
                    }

                    public void setTopicPerson(int topicPerson) {
                        this.topicPerson = topicPerson;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getImg1v1Id_str() {
                        return img1v1Id_str;
                    }

                    public void setImg1v1Id_str(String img1v1Id_str) {
                        this.img1v1Id_str = img1v1Id_str;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }
            }

            public static class BMusicBean {
                /**
                 * playTime : 219106
                 * bitrate : 96000
                 * dfsId : 18633423557585526
                 * sr : 44100
                 * volumeDelta : -2.4
                 * name : null
                 * id : 1262608756
                 * size : 2630053
                 * extension : mp3
                 * dfsId_str : 18633423557585526
                 */

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

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public String getDfsId_str() {
                    return dfsId_str;
                }

                public void setDfsId_str(String dfsId_str) {
                    this.dfsId_str = dfsId_str;
                }
            }

            public static class ArtistsBeanX {
                /**
                 * img1v1Id : 18686200114669622
                 * topicPerson : 0
                 * picId : 0
                 * briefDesc :
                 * albumSize : 0
                 * img1v1Url : http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
                 * trans :
                 * picUrl :
                 * musicSize : 0
                 * alias : []
                 * name : Crush
                 * id : 711186
                 * img1v1Id_str : 18686200114669622
                 */

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

                public long getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(long img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public int getTopicPerson() {
                    return topicPerson;
                }

                public void setTopicPerson(int topicPerson) {
                    this.topicPerson = topicPerson;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImg1v1Id_str() {
                    return img1v1Id_str;
                }

                public void setImg1v1Id_str(String img1v1Id_str) {
                    this.img1v1Id_str = img1v1Id_str;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class ArtistsBeanXX {
            /**
             * img1v1Id : 18686200114669622
             * topicPerson : 0
             * picId : 0
             * briefDesc :
             * albumSize : 0
             * img1v1Url : http://p4.music.126.net/VnZiScyynLG7atLIZ2YPkw==/18686200114669622.jpg
             * trans :
             * picUrl :
             * musicSize : 0
             * alias : []
             * name : Crush
             * id : 711186
             * img1v1Id_str : 18686200114669622
             */

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

            public long getImg1v1Id() {
                return img1v1Id;
            }

            public void setImg1v1Id(long img1v1Id) {
                this.img1v1Id = img1v1Id;
            }

            public int getTopicPerson() {
                return topicPerson;
            }

            public void setTopicPerson(int topicPerson) {
                this.topicPerson = topicPerson;
            }

            public int getPicId() {
                return picId;
            }

            public void setPicId(int picId) {
                this.picId = picId;
            }

            public String getBriefDesc() {
                return briefDesc;
            }

            public void setBriefDesc(String briefDesc) {
                this.briefDesc = briefDesc;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public String getTrans() {
                return trans;
            }

            public void setTrans(String trans) {
                this.trans = trans;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public int getMusicSize() {
                return musicSize;
            }

            public void setMusicSize(int musicSize) {
                this.musicSize = musicSize;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImg1v1Id_str() {
                return img1v1Id_str;
            }

            public void setImg1v1Id_str(String img1v1Id_str) {
                this.img1v1Id_str = img1v1Id_str;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }
}
