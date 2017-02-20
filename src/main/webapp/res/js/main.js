/**
 * Created by cao on 2017/1/9.
 */

$(function () {


});
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}

//ajax
function getAjaxData(url) {
    var defer = $.Deferred();
    $.ajax({
        url : url,
        success: function(data){
            if (data.resultCode==200){
                defer.resolve(data.data)
            }else {
                return null;
            }
        }
    });
    return defer.promise();
}

function ajaxUploadFile(Url, formData) {
    var data;
    $.ajax({
        url: Url,
        async: false,
        type: 'POST',
        data: formData,
        // 告诉jQuery不要去处理发送的数据
        processData: false,
        // 告诉jQuery不要去设置Content-Type请求头
        contentType: false,
        beforeSend: function () {
            console.log("正在进行，请稍候");
        },
        success: function (result) {
            if (result.resultCode == 200) {
                data = result.data;
            } else {
                alert("服务器出现错误，错误代码" + result.resultCode + ',错误内容' + result.wrong);
                return null;
            }
        },
        error: function (responseStr) {
            alert("error");
        }
    });
    return data;
}