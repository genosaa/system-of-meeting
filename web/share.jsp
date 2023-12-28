<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2023-11-16
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String message = request.getParameter("message");
    out.println(request.getParameter("message"));
    if (message != null && message.equals("success")) {
        out.println("<div class='message'>成功</div>");
    }else if (message != null && message.equals("error")) {
        out.println("<div class='message'>失败</div>");
    }
%>
公告栏
<form action="add" method="post">
    主题<input type="text" name="name"><br>
    内容<textarea name="content"></textarea><br>
    <input type="submit" value="提交">
</form>
</body>
<a href="show">查看留言</a>

