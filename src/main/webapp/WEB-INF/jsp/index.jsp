<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>自由的音乐</title>
<link rel="shortcut icon" href="res/favicon.ico" type="image/x-icon" />
<meta charset="utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="res/css/cs-select.css" />
<link rel="stylesheet" type="text/css"
	href="res/css/cs-skin-underline.css" />
<style>
.title {
	margin-top: 50px;
	float: left;
	font: 40px Microsoft Yahei;
	position: absolute;
	left: 50%;
	transform: translate(-50%, -50%);
}
.main_select {
	width: 100%;
	height: 60px;
	float: left;
}
.main_text {
	width: 100%;
	height: 75px;
	float: left;
}
.main_submit {
	width: 100%;
	height: 60px;
	float: left;
}
.j {
	width: 250px;
	height: 45px;
	outline: none;
	font-size: 13px;
	float: left;
	border-radius: 18px;
	border: #9f9f9f 1px solid;
	position: absolute;
	left: 50%;
	transform: translate(-50%, -50%);
	font: 13px Microsoft Yahei;
}
.j:focus {
	transition: border linear .2s, box-shadow linear .5s;
	-moz-transition: border linear .2s, -moz-box-shadow linear .5s;
	-webkit-transition: border linear .2s, -webkit-box-shadow linear .5s;
	outline: none;
	border-color: rgba(225, 255, 255, .75);
	box-shadow: 0 0 8px rgba(225, 255, 255, .5);
	-moz-box-shadow: 0 0 8px rgba(225, 255, 255, .5);
	-webkit-box-shadow: 0 0 8px rgba(225, 255, 255, 3);
}
.submit {
	border-style: none;
	padding: 8px 30px;
	line-height: 24px;
	color: #fff;
	font: 16px "Microsoft YaHei", Verdana, Geneva, sans-serif;
	cursor: pointer;
	border: 2px #FFF solid;
	box-shadow: inset 0px 0px 1px #fff; /*内发光效果*/
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px; /*边框圆角*/
	background-color: #24a9e1;
	position: absolute;
	left: 50%;
	transform: translate(-50%, -50%);
}
.select {
	font: 13px Microsoft Yahei;
	position: absolute;
	left: 50%;
	transform: translate(-50%, -50%);
}
.form {
	width: 100%;
	float: left;
	margin-top: 120px;
}
</style>
</head>

<body style="background:#24a9e1;color:#FFFFFF;">
<div class="title" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" >自由的音乐</div>
<form action="MainSearch.do" method="post" class="form">
  <div class="mainselect">
    <input type="hidden" name="page" value="1" >
    <select class="cs-select cs-skin-underline select" name="musictype">
      <option value="1">请选择</option>
      <option value="1">QQ音乐</option>
      <option value="2">网易音乐</option>
      <option value="3">酷狗音乐</option>
    </select>
  </div>
  <div style="width:100%;height:30px"></div>
  <div class="main_text">
    <input class="j" type="text" name="keyword" autocomplete="off" placeholder="请输入要搜索歌曲的关键字" id="keyword" />
  </div>
  <div class="main_submit">
    <input type="submit" value="Let's Go" class="submit" onClick="return checkNull()" >
  </div>
</form>
<script src="res/js/classie.js"></script> 
<script src="res/js/selectFx.js"></script> 
<script>
		(function() {
			[].slice.call(document.querySelectorAll('select.cs-select'))
					.forEach(function(el) {
						new SelectFx(el);
					});
		})();
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
</body>
</html>
