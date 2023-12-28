<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/18
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传会议文件</title>
</head>
<body>
<h2>上传会议文件</h2><br>
<h3>会议名称：${meetname}</h3>
<div id="upload">
    <form method="post" action="uploadfile01" enctype="multipart/form-data">
        选择文件：<input type="file" name="file1" contenteditable="false" onclick="info.innerHTML=''"><br>
        <input type="submit" value="上传">
    </form>
</div>
<div id="infoo">
    ${message}
</div>
<a href="searchmeetinglaunch">返回</a>
</body>
</html>
