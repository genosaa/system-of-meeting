<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/15
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录主界面</title>
</head>
<body>
<%
    String message = request.getParameter("message");
    if (message != null && message.equals("success")) {
        out.println("<div class='message'>成功</div>");
    }else if (message != null && message.equals("error")) {
        out.println("<div class='message'>失败</div>");
    }
%>
<h2>管理员登录界面</h2>
<h3>人员结构管理</h3>
<a href="User">用户管理界面</a><br>
<h2>公告管理</h2>
<form action="add" method="post">
    主题<input type="text" name="name"><br>
    内容<textarea name="content"></textarea><br>
    <input type="submit" value="提交">
</form>
<a href="showall">管理公告</a>
<h3>会议管理</h3>
<a href="searchmeetingadmin">会议记录管理</a><br>
<a href="auditroom">会议室审核</a><br>
<a href="roomadmin">会议室管理</a><br>
<a href="deviceadmin">会议设备管理</a><br>
<a href="adminlogin.jsp">返回管理员登录界面</a>
</body>
</html>
