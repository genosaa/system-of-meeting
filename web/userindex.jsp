<%@ page import="com.dao.UserDao" %>
<%@ page import="com.dao.UserDaoImpl" %>
<%@ page import="com.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/15
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录主界面</title>
</head>
<body>
<h1>用户登录界面</h1>
<h2>人员信息管理</h2>
<table border="1">
    <tr>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <%
        // Get the logged in user's username from the session
        String loggedInUsername = (String) request.getSession().getAttribute("username");

// Retrieve the user's information from the database based on the username
        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectUserByUsername(loggedInUsername);

// Display the user's information in the table
        if (user != null) {
    %>
    <tr>
        <td><%= user.getUsername() %></td>
        <td><%= user.getUserpwd() %></td>
    </tr>
    <%
        }
    %>
    <h3>修改用户信息</h3>
    <%
        String message = request.getParameter("message");
        if (message != null && message.equals("success")) {
            out.println("<div class='message'>成功</div>");
        } else if (message != null && message.equals("error")) {
            out.println("<div class='message'>失败</div>");
        }
    %>
    <form action="updateuser" method="post">
        <input type="hidden" name="user" value="<%= user.getUsername() %>">
        用户名
        <input type="text" name="username" value="<%= user.getUsername() %>">
        <br>
        密码
        <input type="password" name="userpwd" value="<%= user.getUserpwd() %>">
        <br>
        <input type="submit" value="更新">
    </form>
</table>
<a href="show">查看公告</a>
<h2>会议管理</h2>
<a href="searchmeetinglaunch">预约会议</a><br>
<a href="searchmeetingjoin">查看需参加会议</a><br>
<a href="userlogin.jsp">返回用户登录界面</a>
</body>
</html>
