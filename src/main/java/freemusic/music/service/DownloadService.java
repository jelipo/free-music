package freemusic.music.service;

import freemusic.music.service.download.KgDownload;
import freemusic.music.service.download.MusicDownload;
import freemusic.music.service.download.QQDownload;
import freemusic.music.service.download.WyDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadService {

    public String getDownloadUrl(String type, String quality, String id) {
        MusicDownload musicDownload = getService(type);
        String url = musicDownload.getDownloadUrl(id, quality);
        return url;
    }

    public String getMvUrl(String type, String quality, String id) {
        MusicDownload musicDownload = getService(type);
        String url = musicDownload.getMvUrl(id, quality);
        return url;
    }


    private MusicDownload getService(String type) {
        MusicDownload musicDownload = null;
        if (type.equals("1")) {
            musicDownload = qqDownload;
        } else if (type.equals("2")) {
            musicDownload = wyDownload;
        } else if (type.equals("3")) {
            musicDownload = kgDownload;
        }
        return musicDownload;
    }

    @Autowired
    private QQDownload qqDownload;

    @Autowired
    private KgDownload kgDownload;

    @Autowired
    private WyDownload wyDownload;


}
