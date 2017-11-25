package freemusic.music.service.download;

/**
 * Created by Springmarker on 2017/2/17.
 */
public interface MusicDownload {

    String getDownloadUrl(String id, String quality);

    String getMvUrl(String id, String quality);

    String getImgUrl(String id, String quality);
}
