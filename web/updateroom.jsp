<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/20
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改会议室内容</title>
</head>
<body>
<h2>修改${roomname}</h2>
<div id="info">
    ${mmm}
</div>
<form action="updateroom01" method="post">
    <input type="hidden" name="roomid" value="${roomid}"><br>
    <input type="text" name="roomname" value="${roomname}"><br>
    <input type="number" name="hold" value="${hold}"><br>
    <input type="submit" value="修改"><br>
</form>
<a href="roomadmin">返回</a>
</body>
</html>
