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
    <title>搜索结果</title>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
    <link rel="shortcut icon" type="image/x-icon" href="res/ico/ico.png" media="screen" />
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

        .item_lable {
            display: none;
            float: left;
            margin-left: 15px;
            padding: 3px 10px 3px 10px;
            border-radius: 3px;
            text-decoration: none;
            font-weight: 600;
            margin-top: 5px;
            transform: skewX(165deg);
        }

        .item_lable_128 {
            color: #FFF;
            background-color: #4CAF50;
        }

        .item_lable_OGG {
            color: #FFF;
            background-color: #4CAF50;
        }

        .item_lable_320 {
            color: #FFF;
            background-color: #4CAF50;
        }

        .item_lable_SQ {
            color: #FFF;
            background-color: #9C27B0;
        }

        .item_lable_MV {
            color: #FFF;
            background-color: #212121;
        }

        .item_lable_IMG {
            color: #FFF;
            background-color: #FF9800;
        }

        .input-keyword {
            transition: 0.5s;
            opacity: 0;
        }

        .input-keyword:focus {
            opacity: 1;
        }

        .fixButton {
            z-index: 10000;
            display: none;
        }

        .turnpage_up {
            margin-left: 10px;
        }

        .turnpage_down {
            margin-right: 10px;
            float: right;
        }

        .warn {
            color: #E9E9E9;
            text-align: center;
            padding-top: 50px;
            font-size: 14px;
        }

        @media only screen and (max-width: 800px) {
            .input-keyword {
                display: none;
            }

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

            .fixButton {
                display: block;
            }

            .warn {
                font-size: 12px;
            }
        }
    </style>
</head>
<body class="mdui-drawer-body-left">
<input id="keyword" type="hidden" value="${keyword}">
<input id="type" type="hidden" value="${type}">
<input id="page" type="hidden" value="${page}">
<button mdui-dialog="{target: '#dialog'}"
        class="fixButton mdui-fab mdui-fab-fixed mdui-ripple mdui-color-pink"><i
        class="mdui-icon material-icons">search</i></button>
<div class="mdui-toolbar mdui-color-indigo">
    <span class="mdui-typo-title"> ${keyword} - 搜索结果</span>
    <div class="mdui-toolbar-spacer"></div>
    <div class="mdui-textfield" style="padding-top:5px">
        <input id="inputKeyword" class="input-keyword mdui-textfield-input" type="text" placeholder="输入关键词"/>
    </div>
    <a id="search" onclick="showInput();" style="margin-right: 20px;" class="searchButton mdui-btn mdui-btn-icon "><i
            class="mdui-icon material-icons">
        &#xe8b6;</i></a>
</div>
<div id="drawer" style="background-color: #e9e9e9; " class=" mdui-drawer">
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
            <div id="example1-tab2" class="mdui-p-a-2">
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

    <div id="turnpage" style="margin-top: 15px;">
        <button onclick="" class="mdui-color-indigo turnpage_up mdui-btn-raised mdui-btn mdui-btn-icon"><i
                class="mdui-icon material-icons">first_page</i></button>
        <button onclick="" class="mdui-color-indigo turnpage_down mdui-btn-raised mdui-btn mdui-btn-icon">
            <i class="mdui-icon material-icons">last_page</i></button>
    </div>

</div>

<!--对话框-->
<div class="mdui-dialog" id="dialog">
    <div class="mdui-textfield" style="padding:20px 20px 30px 20px;">
        <input id="dialoginput" class="mdui-textfield-input" type="text" placeholder="请输入关键词"/>
    </div>
    <div class="mdui-dialog-actions">
        <button class="mdui-btn mdui-ripple " mdui-dialog-close>取消</button>
        <button class="mdui-btn mdui-ripple" onclick="dialogsearch()">确定</button>
    </div>
</div>
<!--对话框-->

<footer class="mdui-color-indigo-800" style=" width: 100%;height: 100px;bottom:0px;left:0px;">
    <div class="warn">
        本站内容从互联网上收集而来，内容和本站无关
    </div>
    <div style="text-align: center;padding-top: 10px;font-size: 12px;">
        <a style="color: #e9e9e9;text-decoration: none" href="http://www.miitbeian.gov.cn/" target="_blank">
            2016 Cao. All rights reserved.备案号：鲁ICP备16035555号-1
        </a>

    </div>
</footer>
<script>
    $(function () {
        var tab = new mdui.Tab('#tab');
        var drawer = new mdui.Drawer('#drawer');
        tab.show("tab" + $("#type").val());
        var isGotType1 = false;
        var isGotType2 = false;
        var isGotType3 = false;
        var type = $("#type").val(); //进入页面是时的类型
        var keyword = $("#keyword").val();
        getJson($("#page").val(), type, keyword);
        if (type == 1) {
            isGotType1 = true;
        } else if (type == 2) {
            isGotType2 = true;
        } else if (type == 3) {
            isGotType3 = true;
        }
        var typeMap = {};
        typeMap['128'] = "s128";
        typeMap['OGG'] = "sogg";
        typeMap['320'] = "s320";
        typeMap['SQ'] = "SQ";
        var tip = new mdui.Tooltip('#search', {
            content: '搜索按钮在这'
        });
        showTip();
        function showTip() {
            if (window.innerWidth>800){
                tip.open();
            }
        }
        function getJson(page, type, keyword) {

            $.when(getAjaxData("/searchjson.do?keyword=" + keyword + "&page=" + page + "&type=" + type)).done(function (data) {
                var list = data;
                $("#tab" + type + "-panel").empty();
                for (var i = 0; i < list.length; i++) {
                    var singleJson = list[i];
                    var copyHtml = $('#singleItem').clone();
                    copyHtml.attr("id", "item" + (i + 1));
                    copyHtml.find(".Stitle").html(singleJson.name);
                    copyHtml.find('.Ssinger').html(singleJson.singer);
                    copyHtml.find('.Salbum').html(singleJson.album);
                    copyHtml.find('.Stime').html(singleJson.time);
                    for (var single in typeMap) {
                        if (!(singleJson[typeMap[single]] == 0 || singleJson[typeMap[single]] == undefined)) {
                            copyHtml.find(".item_lable_" + single).attr("href", "downloadurl.do?quality=" + typeMap[single] + "&id=" + singleJson[typeMap[single]] + "&type=" + type);
                            copyHtml.find(".item_lable_" + single).css("display", "block");
                        }
                    }
                    if (!(singleJson.mv == 0 || singleJson.mv == undefined)) {
                        copyHtml.find(".item_lable_MV").attr("href", "getmvurl.do?quality=0&id=" + singleJson.mv + "&type=" + type);
                        copyHtml.find(".item_lable_MV").css("display", "block");
                    }
                    $("#tab" + type + "-panel").append(copyHtml);
                }
                var turnpage = $('#turnpage').clone();
                if ((Number(page) - 1) > 0) {
                    turnpage.find(".turnpage_up").attr("onclick", "getJson('" + ( Number(page) - 1) + "','" + type + "','" + keyword + "')");
                } else {
                    turnpage.find(".turnpage_up").attr("onclick", "showNoPage()");
                }

                turnpage.find(".turnpage_down").attr("onclick", "getJson('" + ( Number(page) + 1) + "','" + type + "','" + keyword + "')");
                $("#tab" + type + "-panel").append(turnpage);
                var height = document.body.scrollWidth;
                $('body,html').animate({'scrollTop': 0}, 200);
            });
        }

        document.getElementById('tab1').addEventListener('show.mdui.tab', function () {
            if (!isGotType1) {
                getJson(1, 1, $("#keyword").val());
                isGotType1 = true;
            }

        });
        document.getElementById('tab2').addEventListener('show.mdui.tab', function () {
            if (!isGotType2) {
                getJson(1, 2, $("#keyword").val());
                isGotType2 = true;
            }

        });
        document.getElementById('tab3').addEventListener('show.mdui.tab', function () {
            if (!isGotType3) {
                getJson(1, 3, $("#keyword").val());
                isGotType3 = true;
            }
        });


        $('#inputKeyword').bind('keyup', function (event) {
            if (event.keyCode == "13") {
                //回车执行查询
                var keyword = $("#inputKeyword").val();
                if (keyword == null || keyword == undefined || keyword == "") {
                    mdui.snackbar({message: '未输入关键词！'});
                } else {
                    location.href = "search.do?keyword=" + keyword + "&page=1&type=" + $("#type").val();
                }

            }
        });
    });
    function showInput() {
        $("#inputKeyword").focus();
    }
    function dialogsearch() {
        var keyword = $("#dialoginput").val();
        if (keyword == null || keyword == undefined || keyword == "") {
            mdui.snackbar({message: '未输入关键词！'});
        } else {
            location.href = "search.do?keyword=" + keyword + "&page=1&type=" + $("#type").val();
        }
    }

    function showNoPage() {
        mdui.snackbar({message: '没有上一页了！'});
    }
</script>
</body>
</html>
