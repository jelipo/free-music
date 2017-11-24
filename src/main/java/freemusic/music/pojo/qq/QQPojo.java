package freemusic.music.pojo.qq;


import java.util.List;

public class QQPojo {

    private int size128;
    private int size320;
    private int sizeape;
    private int sizeflac;
    private int sizeogg;
    private int songid;

    private List<Singer> singer;
    //mid
    private String songmid;
    private String songname;
    private String songname_hilight;
    private String vid;
    private String strMediaMid;
    //专辑名
    private String albumname;

    private int interval;

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getSize128() {
        return size128;
    }

    public void setSize128(int size128) {
        this.size128 = size128;
    }

    public int getSize320() {
        return size320;
    }

    public void setSize320(int size320) {
        this.size320 = size320;
    }

    public int getSizeape() {
        return sizeape;
    }

    public void setSizeape(int sizeape) {
        this.sizeape = sizeape;
    }

    public int getSizeflac() {
        return sizeflac;
    }

    public void setSizeflac(int sizeflac) {
        this.sizeflac = sizeflac;
    }

    public int getSizeogg() {
        return sizeogg;
    }

    public void setSizeogg(int sizeogg) {
        this.sizeogg = sizeogg;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public List<Singer> getSinger() {
        return singer;
    }

    public void setSinger(List<Singer> singer) {
        this.singer = singer;
    }

    public String getSongmid() {
        return songmid;
    }

    public void setSongmid(String songmid) {
        this.songmid = songmid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongname_hilight() {
        return songname_hilight;
    }

    public void setSongname_hilight(String songname_hilight) {
        this.songname_hilight = songname_hilight;
    }

    public String getStrMediaMid() {
        return strMediaMid;
    }

    public void setStrMediaMid(String strMediaMid) {
        this.strMediaMid = strMediaMid;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }
}
