<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <link href="res/css/mdui.min.css" rel="stylesheet">
    <script type="text/javascript" src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://res.springmarker.com/other/js/mdui.min.js"></script>
    <script type="text/javascript" src="res/js/main.js"></script>

    <style>
        body {
            font-family: Microsoft Yahei;
        }

        .searchButton {

        }
        .item_lable{
            display: none;
            float: left;
            margin-left: 15px;
            padding: 3px 10px 3px 10px;
            border-radius: 3px;
            text-decoration: none;
            font-weight: 600;
            margin-top: 5px;
            transform:skewX(165deg);
        }
        .item_lable_128{
            color: #FFF;
            background-color: #4CAF50;
        }
        .item_lable_OGG{
            color: #FFF;
            background-color: #4CAF50;
        }
        .item_lable_320{
            color: #FFF;
            background-color: #4CAF50;
        }
        .item_lable_SQ{
            color: #FFF;
            background-color:#9C27B0;
        }
        .item_lable_MV{
            color: #FFF;
            background-color: #212121;
        }
        .item_lable_IMG{
            color: #FFF;
            background-color: #FF9800;
        }


        @media only screen and (max-width: 800px) {
            .searchButton {
                display: none;
            }

            .mdui-panel-item-header {
                height: 38px;
                font-size: 13px;
            }

            .mobileNone {
                display: none;
            }

            .mdui-p-a-2 {
                padding: 16px 0px 16px 0px !important;
            }

        }
    </style>
</head>
<body class="mdui-drawer-body-left">
<input id="keyword" type="hidden" value="${keyword}">
<input id="type" type="hidden" value="${type}">
<input id="page" type="hidden" value="${page}">
<div class="mdui-toolbar mdui-color-indigo">
    <a href="" class="mdui-btn mdui-btn-icon"><i class="mdui-icon material-icons">&#xe5d2;</i></a>
    <span class="mdui-typo-title">${keyword}-搜索结果</span>
    <div class="mdui-toolbar-spacer"></div>
    <a style="margin-right: 20px;" class="searchButton mdui-btn mdui-btn-icon "><i class="mdui-icon material-icons">
        &#xe8b6;</i></a>
</div>
<div id="drawer" style="background-color: #e9e9e9; "  class=" mdui-drawer">
    <div style="width: 100%;height: 100%;overflow: hidden;background-color: #424343">
        <img src="res/pic/music-background.png" width="100%" style="margin-top: 100px ">
    </div>
</div>
<div class="mdui-container" style="min-height: 800px">
    <div class="mdui-row" style="max-width: 1200px;">
        <div class="mdui-col-xs-12 mdui-center">
            <div class="mdui-tab mdui-tab-full-width" id="tab" mdui-tab>
                <a id="tab1" href="#example1-tab1" class="mdui-ripple">腾讯</a>
                <a id="tab2" href="#example1-tab2" class="mdui-ripple">网易</a>
                <a id="tab3" href="#example1-tab3" class="mdui-ripple">酷狗</a>
            </div>
            <div id="example1-tab1" class="mdui-p-a-2">
                <div id="tab1-panel" class="mdui-panel" mdui-panel="{accordion: true}">
                    <!--标签1-->
                </div>
            </div>
            <div id="example1-tab2" class="mdui-p-a-2" >
                <div id="tab2-panel" class="mdui-panel" mdui-panel="{accordion: true}">
                    <!--标签2-->
                </div>
            </div>
            <div id="example1-tab3" class="mdui-p-a-2">
                <div id="tab3-panel" class="mdui-panel" mdui-panel="{accordion: true}">
                    <!--标签3-->
                </div>
            </div>
        </div>
    </div>


</div>


<div style="display: none">

    <!-- 单个item-->
    <div id="singleItem" class="mdui-panel-item">
        <div class="mdui-panel-item-header">
            <div class="Stitle mdui-panel-item-title">标题</div>
            <div class="Ssinger mdui-panel-item-summary">歌手</div>
            <div class="Salbum mdui-panel-item-summary">专辑</div>
            <div class="Stime mdui-panel-item-summary mobileNone" style="text-align:right;">时间</div>
            <i class="mdui-panel-item-arrow mdui-icon material-icons">&#xe313;</i>
        </div>
        <div class="mdui-panel-item-body">
            <a href="" class="item_lable item_lable_128" target="_blank">128</a>
            <a href="" class="item_lable item_lable_OGG" target="_blank">OGG</a>
            <a href="" class="item_lable item_lable_320" target="_blank">320</a>
            <a href="" class="item_lable item_lable_SQ" target="_blank">SQ</a>
            <a href="" class="item_lable item_lable_MV" target="_blank" rel="noreferrer">MV</a>
            <a href="" class="item_lable item_lable_IMG" target="_blank">IMG</a>
        </div>
    </div>
    <!-- 单个item-->

</div>

<footer class="mdui-color-grey-900" style=" width: 100%;height: 100px;bottom:0px;left:0px;">
    <div style="color:#E9E9E9;text-align: center;padding-top: 40px;font-size: 14px;">
        本站内容从互联网上收集而来，内容和本站无关
    </div>
    <div style="text-align: center;padding-top: 20px;font-size: 12px;">
        <a style="color: #e9e9e9;text-decoration: none" href="http://www.miitbeian.gov.cn/" target="_blank">
            2016 Cao. All rights reserved.备案号：鲁ICP备16035555号-2
        </a>

    </div>
</footer>
<script>
    var tab = new mdui.Tab('#tab');
    tab.show("tab" + $("#type").val());
    var drawer = new mdui.Drawer('#drawer');

    var isGotType1 = false;
    var isGotType2 = false;
    var isGotType3 = false;
    var type = $("#type").val(); //进入页面是时的类型
    getJson($("#page").val(), type)
    if (type == 1) {
        isGotType1 = true;
    } else if (type == 2) {
        isGotType2 = true;
    } else if (type == 3) {
        isGotType3 = true;
    }
    var typeMap= {};
    typeMap['128'] = "s128";
    typeMap['OGG'] = "sogg";
    typeMap['320'] = "s320";
    typeMap['SQ'] = "SQ";

    function getJson(page, type) {
        $.when(getAjaxData("/searchjson.do?keyword=" + $("#keyword").val() + "&page=" + page + "&type=" + type)).done(function (data) {
            var list = data;
            for (var i = 0; i < list.length; i++) {
                var singleJson=list[i];
                var copyHtml = $('#singleItem').clone();
                copyHtml.attr("id", "item" + (i + 1));
                copyHtml.find(".Stitle").html(singleJson.name);
                copyHtml.find('.Ssinger').html(singleJson.singer);
                copyHtml.find('.Salbum').html(singleJson.album);
                copyHtml.find('.Stime').html(singleJson.time);
                for (var single in typeMap){
                    if (!(singleJson[typeMap[single]]==0||singleJson[typeMap[single]]==undefined)){
                        copyHtml.find(".item_lable_"+single).attr("href","downloadurl.do?quality="+typeMap[single]+"&id="+singleJson[typeMap[single]]+"&type="+type);
                        copyHtml.find(".item_lable_"+single).css("display","block");
                    }
                }
                if (!(singleJson.mv==0||singleJson.mv==undefined)){
                    copyHtml.find(".item_lable_MV").attr("href","getmvurl.do?quality=0&id="+singleJson.mv+"&type="+type);
                    copyHtml.find(".item_lable_MV").css("display","block");
                }
                $("#tab" + type + "-panel").append(copyHtml);
            }
        });
    }
    function showLable(copyHtml,single) {
        if (!(list[i].s128==0||list[i].s128==undefined)){
            copyHtml.find('.item_lable_128').show();
            copyHtml.find('.item_lable_128').attr("href",list[i].s128);
        }
    }
    document.getElementById('tab1').addEventListener('show.mdui.tab', function () {
        if (!isGotType1) {
            getJson(1, 1);
            isGotType1 = true;
        }

    });
    document.getElementById('tab2').addEventListener('show.mdui.tab', function () {
        if (!isGotType2) {
            getJson(1, 2);
            isGotType2 = true;
        }

    });
    document.getElementById('tab3').addEventListener('show.mdui.tab', function () {
        if (!isGotType3) {
            getJson(1, 3);
            isGotType3 = true;
        }
    });

</script>
</body>
</html>
