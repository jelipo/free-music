var keyword = $("#keyword").attr("value");
var musictype = $("#musictype").attr("value");
var page = $("#page").attr("value");
addHtml(keyword,musictype,page);
function addHtml(keyword,musictype,page){
	var json;
	$.ajax({
		url : "searchjson.do?keyword=" + keyword + "&musictype=" + musictype+ "&page=" + page,
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
		html=html+"<div class=\"songlist_singlesong\">" +
				"<div class=\"songlist_singlesong_main  material-ripple material-shadow-1 material-hover\" onClick='ripple(this)' \">" +
				"<div class=\"songlist_singlesong_main_space\">" +
				"<div style=\"width:20px;height:100%;float:left;\"></div>" +
				"<div style=\"width:30px;height:100%;float:left;\"><img src=\""+img+"\" style=\"width:20px;margin:5px 0px;\"></div>" +
				"<div style=\"width:10px;height:100%;float:left;\"></div>" +
				"<div style=\"width:20px;height:100%;float:left;\">"+(i+1)+"</div>" +
				"</div>" +
				"<div class=\"songlist_singlesong_main_title\">"+list[i].song+"</div>" +
				"<div class=\"songlist_singlesong_main_singer\">"+list[i].singer+"</div>" +
				"<div class=\"songlist_singlesong_main_album\">"+list[i].album+"</div>" +
				"<div class=\"songlist_singlesong_main_time\">"+list[i].time+"</div>" +
				"<div class=\"songlist_singlesong_main_do\">" +
				addUrl(list[i],musictype)+
				"</div>" +
				"</div></div>";
	}
	if(page==1){
		pageup="<div class=\"page_up_connot\">上一页没有了哦</div>";
		pagedown="<div class=\"page_down\" onClick=\"turnpage('"+keyword+"','"+musictype+"','"+(parseInt(page)+1)+"')\">下一页</div>";
	}else{
		pageup="<div class=\"page_up\" onClick=\"turnpage('"+keyword+"','"+musictype+"','"+(parseInt(page)-1)+"')\">上一页</div>";
		pagedown="<div class=\"page_down\" onClick=\"turnpage('"+keyword+"','"+musictype+"','"+(parseInt(page)+1)+"')\">下一页</div>";
	}
	html=html+"<div class=\"turn_page\">" +
			"<div class=\"turn_page_main\">" +
				pageup +
					pagedown +
				"</div>" +
			"</div>";
	$("#songlist").html(html);
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
		html="<a href=\" "+list.downurl+" \" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download img3rd\"></a>";
		return html;
	}
	if(list.common=="320000"){
		html="<a href=\"downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0\" target=\"_blank\" " +
				"class=\"songlist_singlesong_main_do_download img320\"></a>";
	}else if(list.common=="192000"){
		html="<a href=\"downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0\" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download img192\"></a>";
	}else{
		html="<a href=\"downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0\" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download img128 \"></a>";
	}
	if(list.flac>0){
		html=html+"<a href=\"downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=flac\" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download imgflac \"></a>";
	}
	if(list.ape>0){
		html=html+"<a href=\"downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=ape\" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download imgape\"></a>";
	}
	return html;
}
function wyMusic(list,musictype) {
	var html="<a href=\"downloadurl?id="+list.id+"&musictype="+musictype+"&filetype=0\" target=\"_blank\" " +
	"class=\"songlist_singlesong_main_do_download img320\"></a>";
	return html;
}
function kgMusic(list,musictype) {
	var html="";
	if(list.m128!=0){
		html=html+"<a href=\"downloadurl?id="+list.m128+"&musictype="+musictype+"&filetype=0\" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download img128\"></a>";
	}
	if(list.m320!=0){
		html=html+"<a href=\"downloadurl?id="+list.m320+"&musictype="+musictype+"&filetype=0\" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download img320\"></a>";
	}
	if(list.SQ!=0){
		html=html+"<a href=\"downloadurl?id="+list.SQ+"&musictype="+musictype+"&filetype=0\" target=\"_blank\" " +
		"class=\"songlist_singlesong_main_do_download imgflac\"></a>";
	}
	return html;
}


