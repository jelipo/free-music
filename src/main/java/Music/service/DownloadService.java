package Music.service;

import Music.service.download.KgDownload;
import Music.service.download.MusicDownload;
import Music.service.download.QQDownload;
import Music.service.download.WyDownload;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("Music/DownloadService")
public class DownloadService{

	public String getDownloadUrl(String type,String quality,String id){
		MusicDownload musicDownload=getService(type);
		String url=musicDownload.getDownloadUrl(id,quality);
		return url;
	}

	public String getMvUrl( String type,String quality,String id){
		MusicDownload musicDownload=getService(type);
		String url=musicDownload.getMvUrl(id,quality);
		return url;
	}




	private MusicDownload getService(String type){
		MusicDownload musicDownload = null;
		if (type.equals("1")){
			musicDownload=qqDownload;
		}else if (type.equals("2")){
			musicDownload=wyDownload;
		}else if (type.equals("3")){
			musicDownload=kgDownload;
		}
		return musicDownload;
	}

	@Resource(name = "Music/service/download/QQDownload")
	private QQDownload qqDownload;

	@Resource(name = "Music/service/download/KgDownload")
	private KgDownload kgDownload;

	@Resource(name = "Music/service/download/WyDownload")
	private WyDownload wyDownload;


}
