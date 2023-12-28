<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/15
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录界面</title>
</head>
<body>
<h1>管理员登录界面</h1>
<form action="adminlogin" method="post">
    用户名：<input type="text" name="adminname"><br>
    密码：<input type="password" name="adminpwd"><br>
    <input type="submit" value="登录">
</form>
<a href="userlogin.jsp">用户登录</a>
</body>
</html>
