<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/15
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
</head>
<body>
<h1>用户登录界面</h1>
<%
    String message = request.getParameter("message");
    if (message != null && message.equals("success")) {
        out.println("<div class='message'>成功,请重新登录</div>");
    } else if (message != null && message.equals("error")) {
        out.println("<div class='message'>失败</div>");
    }
%>
<form method="post" name="form1">
    用户名：
    <input type="text" name="username" onclick="mes.innerHTML=''"
           value="${param.username }" />
    <br />
    密码：
    <input type="password" name="userpwd" value="${param.userpwd }" />
    <br />
    验证码：
    <input type="text" name="checkcode" />
    <img border="0" src="checkcode" />
    <input type="submit" value="换一张"
           onclick="form1.action='changecheckcode'" />
    <br />
    <input type="submit" value="登录" onclick="form1.action='userlogin'" />
    <input type="reset" value="重置" />
    <div id="mes">
        ${info}
    </div>
</form>
<a href="adminlogin.jsp">管理员登录</a>
<a href="reg.jsp">用户注册</a>
</body>
</html>
