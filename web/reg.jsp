<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2023-12-17
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<%
    String message = request.getParameter("message");
    if (message != null && message.equals("failure")) {
        out.println("<div class='message'>注册失败，请重新注册</div>");
    }
%>
<h2>用户注册界面</h2>
<form action="reg" method="post">
    用户名：<input type="text" name="uname"><br>
    密码：<input type="password" name="upwd"><br>
    <input type="submit" value="OK">
</form>
<a href="userlogin.jsp">返回登录界面</a>
</body>
</html>