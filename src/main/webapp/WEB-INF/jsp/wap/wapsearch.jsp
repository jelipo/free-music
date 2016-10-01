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

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>自由的音乐</title>
<style>
.topbar {
	width: 100%;
	height: 50px;
	background: white;
	text-align: center;
	border-radius: 3px;
	box-shadow: #CFCFCF 0px 5px 10px;
	font-size: 0.9em;
}

.topbar_index {
	float: left;
	line-height: 50px;
	width: 50px;
	color: #7A7A7A;
}

.topbar_search {
	float: left;
	line-height: 50px;
	width: 80px;
}

.main {
	width: 100%;
	font-size: 0.9em;
	margin-top: 15px;
}

.singlesong {
	width: 100%;
	height: 53px;
}

.singlesong_main {
	width: 100%;
	height: 48px;
	background: white;
	border-radius: 3px;
	box-shadow: #CFCFCF 0px 2px 5px;
}

.singlesong_main_ico {
	width: 8%;
	height: 100%;
	margin-left: 2%;
	float: left;
}

.singlesong_main_title {
	width: 68%;
	float: left;
	height: 60%;
	line-height: 28px;
	margin-left: 2%;
	font-size: 1.2em;
	overflow: hidden;
}

.singlesong_main_time {
	width: 20%;
	float: left;
	height: 60%;
	line-height: 28px;
	font-size: 0.9em;
}

.singlesong_main_singeralbum {
	width: 58%;
	float: left;
	height: 40%;
	margin-left: 2%;
	font-size: 0.9em;
	color: #5E5E5E;
	overflow: hidden;
	text-overflow: ellipsis; 
	display: box; 
	display: -webkit-box; 
	line-clamp: 2; 
	-webkit-line-clamp: 2; 
	-webkit-box-orient: vertical;
}

.singlesong_main_download {
	width: 30%;
	float: left;
	height: 40%;
}

.download_pic {
	height: 100%
}

.turnpage {
	width: 100%;
	height: 40px;
	float: left;
	background: white;
	text-align: center;
	border-radius: 3px;
	box-shadow: #CFCFCF 0px 2px 10px;
	font-size: 0.9em;
}

.pageup {
	width: 50%;
	height: 100%;
	line-height: 40px;
	float: left;
}

.pagedown {
	width: 50%;
	height: 100%;
	line-height: 40px;
	float: left;
}
</style>

<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body
	style="width: 98%; height: 100%; min-height: 100px; margin: 1px 1px 1px 3px; font-family: Microsoft Yahei, Roboto; background: #f9f9f9; min-width: 300px;">

	<div class="topbar" data-genuitec-lp-enabled="false"
		data-genuitec-file-id="wc1-5"
		data-genuitec-path="/16_08_15_AnlysisMusic Maven Webapp/src/main/webapp/WEB-INF/jsp/wap/wapsearch.jsp">
		<div class="topbar_index"
			onClick="window.open('<%=basePath%>','_self')">首页</div>
		<div class="topbar_search">&gt;&nbsp;&nbsp;搜索结果</div>
	</div>
	<div class="main" id="songlist"></div>
	<input type="hidden" value="${keyword}" id="keyword" />
	<input type="hidden" value="${musictype}" id="musictype" />
	<input type="hidden" value="${page}" id="page" />
</body>
<script src="res/js/wapctrl.js"></script>
</html>
