var keyword = document.getElementById('keyword').getAttribute("value");
var musictype =document.getElementById('musictype').getAttribute("value");
var page = document.getElementById('page').getAttribute("value");
addHtml(keyword,musictype,page);
function addHtml(keyword,musictype,page){
	var json;
	$.ajax({
		url : "searchjson?keyword=" + keyword + "&musictype=" + musictype+ "&page=" + page,
		type : 'get',
		async : false, // 默认为true 异步
		error : function() {},
		success : function(data) {json = data;}
	});
	var html="";
	var list=json.list;
	var pageup;
	var pagedown;
	var img;
	if(musictype=="1"){
		img="res/pic/qq.png";
	}else if(musictype=="2"){
		img="res/pic/wangyi.png";
	}else if(musictype=="3"){
		img="res/pic/kugou.png";
	}
	for(var i=0;i<list.length;i++){
		html=html+"<div class=\"singlesong\"><div class=\"singlesong_main\"><div class=\"singlesong_main_ico\">" +
		"<img src=\""+img+"\" style=\"width:24px;margin-top:13px;\"></div>" +
		"<div class=\"singlesong_main_title\">"+list[i].song+"</div><div class=\"singlesong_main_time\">"+list[i].time+"</div>" +
		"<div class=\"singlesong_main_singeralbum\">"+list[i].singer+"&nbsp;-&nbsp;"+list[i].album+"</div>" +
		"<div class=\"singlesong_main_download\">" +
		addUrl(list[i],musictype)+
		"</div></div></div>";
	}
	if(page==1){
		pageup="<div class=\"turnpage\"><div class=\"pageup\">第一页没有了哦</div>";
		pagedown="<div class=\"pagedown\" onClick=\"turnpage('"+keyword+"','"+musictype+"','"+(parseInt(page)+1)+"')\">下一页</div>";
	}else{
		pageup="<div class=\"turnpage\"><div class=\"pageup\" onClick=\"turnpage('"+keyword+"','"+musictype+"','"+(parseInt(page)-1)+"')\">上一页</div>";
		pagedown="<div class=\"pagedown\" onClick=\"turnpage('"+keyword+"','"+musictype+"','"+(parseInt(page)+1)+"')\">下一页</div>";
	}
	html=html+
				pageup +
					pagedown+"</div>";
	document.getElementById('songlist').innerHTML=html;
}
function addUrl(list,musictype) {
	var html;
	if(musictype=="1"){
		html=qqMusic(list,musictype);
	}else if(musictype=="2"){
		html=wyMusic(list,musictype);
	}else if(musictype=="3"){
		html=kgMusic(list,musictype);
	}
	return html;
}
function turnpage(keyword, type, page) {
	addHtml(keyword,musictype,page);
}
function qqMusic(list,musictype) {
	var html;
	if(list.official=="false"){
		html="<img title=\"下载第三方音乐\" class=\"download_pic\" src=\"res/pic/wap/3rd.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0')\">";
		return html;
	}
	if(list.common=="320000"){
		html="<img title=\"下载320k品质音乐\" class=\"download_pic\" src=\"res/pic/wap/320.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0')\">";
	}else if(list.common=="192000"){
		html="<img title=\"下载192k品质音乐\" class=\"download_pic\" src=\"res/pic/wap/192.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0')\">";
	}else{
		html="<img title=\"下载128品质音乐\" class=\"download_pic\" src=\"res/pic/wap/320.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0')\">";
	}
	if(list.flac>0){
		html=html+"<img title=\"下载Flac无损音乐\" class=\"download_pic\" src=\"res/pic/wap/flac.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=flac')\">";
	}
	if(list.ape>0){
		html=html+"<img title=\"下载Ape无损音乐\" class=\"download_pic\" src=\"res/pic/wap/ape.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=ape')\">";
	}
	return html;
}
function wyMusic(list,musictype) {
	var html="<img title=\"下载320k品质音乐\" class=\"download_pic\" src=\"res/pic/wap/320.png\" " +
	"onclick=\"window.open('downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0')\">";
	return html;
}
function kgMusic(list,musictype) {
	var html="";
	if(list.m128!=0){
		html=html+"<img title=\"下载320k品质音乐\" class=\"download_pic\" src=\"res/pic/wap/128.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.m128+"&musictype="+musictype+"&filetype=0')\">";
	}
	if(list.m320!=0){
		html=html+"<img title=\"下载320k品质音乐\" class=\"download_pic\" src=\"res/pic/wap/320.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.m320+"&musictype="+musictype+"&filetype=0')\">";
	}
	if(list.SQ!=0){
		html=html+"<img title=\"下载320k品质音乐\" class=\"download_pic\" src=\"res/pic/wap/flac.png\" " +
		"onclick=\"window.open('downloadurl?id="+list.SQ+"&musictype="+musictype+"&filetype=0')\">";
	}
	return html;
}


