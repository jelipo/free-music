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

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>自由的音乐</title>
<style>
.main {
	width: 96%;
	height: 500px;
	border-radius: 10px;
	box-shadow: #CFCFCF 0px 0px 5px;
	background: white;
	position: absolute;
}

.j {
	width: 65%;
	height: 40px;
	outline: none;
	font-size: 13px;
	float: left;
	border-radius: 5px;
	border: #02A8DB 1px solid;
}

.j:focus {
	transition: border linear .2s, box-shadow linear .5s;
	-moz-transition: border linear .2s, -moz-box-shadow linear .5s;
	-webkit-transition: border linear .2s, -webkit-box-shadow linear .5s;
	outline: none;
	border-color: rgba(227, 139, 0, .75);
	box-shadow: 0 0 8px rgba(227, 139, 0, .5);
	-moz-box-shadow: 0 0 8px rgba(227, 139, 0, .5);
	-webkit-box-shadow: 0 0 8px rgba(227, 139, 0, 3);
}

.main_title {
	width: 100%;
	height: 90px;
	font-family: Microsoft Yahei, Roboto;
	font-size: 2em;
	line-height: 90px;
	text-align: center;
	float: left;
}

.main_select {
	width: 100%;
	height: 70px;
	font-family: Microsoft Yahei, Roboto;
	float: left;
}

.select {
	width: 25%;
	height: 40px;
	float: left;
	border-radius: 5px;
	margin-left: 5%;
	border: #02A8DB 1px solid;
	color: #02A8D8
}

.main_submit {
	width: 100%;
	height: 50px;
	float: left;
}

.submit {
	margin-left: 32%;
	padding: 8px 30px;
	color: #02A8D8;
	font: 16px "Microsoft YaHei", Verdana, Geneva, sans-serif;
	cursor: pointer;
	border: 2px #02A8D8 solid;
	box-shadow: inset 0px 0px 1px #fff; /*内发光效果*/
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px; /*边框圆角*/
	background-color: #FFFFFF;
}
</style>
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

</head>

<body style="font-family:Roboto;background:#f9f9f9;min-width: 300px;">
<%@ include file="cs.jsp" %>
<%CS cs = new CS(1260186749);cs.setHttpServlet(request,response);
String imgurl = cs.trackPageView();%> 
<img src="<%= imgurl %>" width="0" height="0"  />
	<div class="main" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-4" data-genuitec-path="/16_08_15_AnlysisMusic Maven Webapp/src/main/webapp/WEB-INF/jsp/wap/wapindex.jsp">
		<div class="main_title">自由的音乐</div>
		<form action="wap/MainSearch" method="post">
			<div class="main_select">
				<input type="hidden" name="page" value="1"> <select
					class="select" name="musictype">
					<option value="1">请选择</option>
					<option value="1">QQ音乐</option>
					<option value="2">网易音乐</option>
					<option value="3">酷狗音乐</option>
				</select> <input class="j" type="text" name="keyword" placeholder="请输入搜索音乐的关键词"
					id="keyword" />
			</div>
			<div class="main_submit">
				<input type="submit" class="submit" value="Let's Go!" onClick="return checkNull()">
			</div>
		</form>
	</div>
	

							
</body>
</html>
