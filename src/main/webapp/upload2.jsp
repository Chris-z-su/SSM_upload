<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/20 0020
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax异步上传图片</title>
    <%--引入jQuery异步上传文件--%>
    <%--<script src="js/jquery-1.6.2.js" type="application/javascript" charset="utf-8"></script>--%>
    <%--<script src="js/js/jquery.form.js" type="application/javascript" charset="utf-8"></script>--%>
    <script src="https://www.zhangsubao.com/js/jquery-1.6.2.js" type="text/javascript" charset="utf-8"></script>
    <script src="https://www.zhangsubao.com/js/jquery.form.js" type="text/javascript" charset="utf-8"></script>
    <!-- Ajax异步上传图片 -->
    <script type="text/javascript">
        function uploadPic() {
            var options = {
                url: "/upload/upload",// 规定把请求发送到那个URL，会覆盖form表单中的action
                type: "post", // 请求方式
                dataType: "json",//服务器响应的数据类型
                // 请求成功时执行的回调函数
                success: function (data, status, xhr) {
                    $("#allUrl").attr("src", data.path);// 图片显示地址
                    $("#imgUrl").empty();//清空内容
                    $("#imgUrl").append(data.path);
                },
                error:function(data){
                    $(".showImg").append("<div  style='font-size:x-large;width: 320px;float: left;margin-left: 80px;'><b>很抱歉，图片上传失败了！</b></div >");
                    $("#allUrl").attr("src", "/upload/images/0922ee7977c451b31e85.png");// 图片显示地址
                }
            };

            var flag = check();
            if (flag) {
                $("#imgForm").ajaxSubmit(options);
            }
        }

        function check() {
            var str = $("#imgForm").get(0)[0].value;
            // console.log(str);
            if (str.length == "") {
                alert("你不选图片上传个鸡儿？？？");
                return false;
            }
            return true;
        }
    </script>
    <%--引入css样式--%>
    <style type="text/css">
        .showImg {
            border: 1px solid #DDDDDD;
            width: 1110px;
            height: 339px;
            line-height: 339px;
        }

        .showImg img {
            height: 339px;
        }

        .upload{
            border: 1px solid #DDDDDD;
            height: 50px;
            line-height: 50px;
            padding-left: 10px;
            margin: 20px 0px;
        }

        .urltext{
            border: 1px solid #DDDDDD;
            height: 50px;
            line-height: 50px;
            padding-left: 10px;
            background-color: #F5F5F5;
        }
    </style>
</head>
<body>
<div class="title">
    <h2>Image Upload</h2>
    <h4>5 MB max per file. 10 files max per request. </h4>
</div>
<div class="content">
    <div class="showImg">
        <img src="/upload/images/6f406d4d_E792236_490b3400.jpg" id="allUrl"/>
    </div>
    <div class="upload">
        <form id="imgForm" action="/upload/upload" method="post" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="button" value="提交" onclick="uploadPic()">
        </form>
    </div>
    <div class="urltext">
        <span>Image URL：</span>
        <span>
            <code id="imgUrl"></code>
        </span>
    </div>
</div>
</body>
</html>
