<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>搜索结果——自由的音乐</title>
<link rel="shortcut icon" href="res/favicon.ico" type="image/x-icon" />
<meta charset="utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="res/css/songlist.css" type="text/css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="res/dist/ripple.min.css" type="text/css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	
	function checkNull() {
		var keyword = document.getElementById("keyword").value;
		if (keyword == null || keyword == '') {
			alert("关键词不能为空");
			return false;
		} else {
			return true;
		}
	}
</script>
<style type="text/css">


</style>
</head>
<body style="min-width: 1270px">
	<div class="left_bar" data-genuitec-lp-enabled="false"
		data-genuitec-file-id="wc1-3"
		data-genuitec-path="/16_08_15_AnlysisMusic Maven Webapp/src/main/webapp/WEB-INF/jsp/search.jsp">
		<span style="color: white">测试文字</span>
	</div>
	<div class="all">
		<div class="left_bar_space"></div>
		<div class="left_space"></div>
		<div class="main">
			<div class="top_bar">
				<div class="top_bar_space"></div>
				<div class="top_bar_main">
					<div class="top_bar_main_space"></div>
					<div class="top_bar_main_index"
						onclick="window.open('http://www.bluebamboo.me')">首页</div>
					<div class="top_bar_main_result">》&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;搜索结果</div>
					<div class="top_bar_main_search">
						<form action="MainSearch" method="post">
							<input type="hidden" name="page" value="1"> <input
								type="hidden" name="musictype" value="1"> <input
								class="search" type="text" name="keyword"
								placeholder="搜索，默认QQ音乐" /> <input class="submit"
								type="submit" value="开始" onClick="return checkNull()">
						</form>
					</div>
				</div>
			</div>
			<div class="main_song">
				<div style="width: 2%; height: 900px; float: left;"></div>
				<div class="main_song_space"></div>
				<div style="width: 98%; height: 40px; float: left;">
					<div class="main_song_title">
						<div class="main_song_title_space"></div>
						<div class="main_song_title_title">标题</div>
						<div class="main_song_title_singer">歌手</div>
						<div class="main_song_title_album">专辑</div>
						<div class="main_song_title_time">时长</div>
						<div class="main_song_title_do">操作</div>
					</div>
				</div>
				<div id="songlist" class="songlist">
<div class="songlist_singlesong">
  <div class="songlist_singlesong_main  material-ripple material-shadow-1 material-hover ">
    <div class="songlist_singlesong_main_space">
      <div style="width:20px;height:100%;float:left;"></div>
      <div style="width:30px;height:100%;float:left;"><img src="res/pic/qq.png" style="width:20px;margin:5px 0px;"></div>
      <div style="width:10px;height:100%;float:left;"></div>
      <div style="width:20px;height:100%;float:left;">1</div>
    </div>
    <div class="songlist_singlesong_main_title">Piece Of Heaven</div>
    <div class="songlist_singlesong_main_singer">CS</div>
    <div class="songlist_singlesong_main_album">空</div>
    <div class="songlist_singlesong_main_time">3:29</div>
    <div class="songlist_singlesong_main_do"><a href="qq/128downurl?id=000gHU1t2WGfrg" target="_blank" class="songlist_singlesong_main_do_download img128"></a>
   </div>
  </div>
					<div class="turn_page">
						<div class="turn_page_main">
							<div class="page_up_connot">上一页</div>
							<div class="page_down" onClick="turnpage('邓紫棋','2','2') ">下一页</div>
						</div>
					</div>
				</div>
			</div>
			<div class="blewbar">
				<div class="explain">1.申明下，本站是解析高品质音乐（指音乐文件的质量）的网站，是方便大家下载的地方，一些觉得什么品质音乐都能听的人请绕道，本站可能不适合你。</div>
				<div class="explain">2.本站还是新站，难免会有些bug，如果在使用过程中遇到了问题，请在QQ上反馈给我，谢谢。</div>
				<div class="explain">3.目前只解析出QQ音乐和网易音乐的下载的加密方式，因为本人能力有限，目前只有QQ音乐可以下载无损音乐，网易只能解析出320k的下载链接。一些浏览器（如chrome内核的浏览器，360、qq浏览器、搜狗等很多都是chrome内核）当识别到mp3格式的音乐下载链接时，浏览器会直接自动在线播放，不会调用下载器进行下载(这是浏览器本身的问题，无法解决），这时把正在播放音乐的网页的网址复制进下载器即可。</div>
				<div class="explain">4.注意低调使用.</div>
				<div class="declaraction">所有资源属各大网站所有，本站对资源内容不承担任何责任</div>
				<div class="final">© 2016 自由音乐/Powered by LaoCao<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1260186749'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/z_stat.php%3Fid%3D1260186749%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script></div>
			</div>
		</div>
	</div>
	<input type="hidden" value="${keyword}" id="keyword" />
	<input type="hidden" value="${musictype}"  id="musictype" />
	<input type="hidden" value="${page}"  id="page"/>
	<script src="res/js/ctrl.js"></script>
	<script src="res/dist/ripple.js"></script>
</body>
</html>
