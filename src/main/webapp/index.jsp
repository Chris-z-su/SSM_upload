<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/19 0019
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>r
<head>
    <title>Title</title>
</head>
<body>
    <form action="upload" method="post" enctype="multipart/form-data">
        <label>文件上传</label>
        <input type="file" name="file">
        <input type="submit" value="提交">
    </form>
</body>
</html>
