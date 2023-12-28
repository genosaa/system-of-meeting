<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2023-12-17
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户板</title>
</head>
<body>
<h1>用户管理</h1>
<form action="search" method="get">
    <select name="searchColumn">
        <option value="username">用户</option>
        <option value="job">职位</option>
        <option value="department">部门</option>
    </select>
    <input type="text" name="keyword" placeholder="模糊查询">
    <input type="submit" value="查询">
</form>


<%
    String message = request.getParameter("message");
    if (message != null && message.equals("success")) {
        out.println("<div class='message'>成功</div>");
    } else if (message != null && message.equals("error")) {
        out.println("<div class='message'>失败</div>");
    }
%>

<h2>用户板</h2>
<table border="1">
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>职位</th>
        <th>部门</th>
        <th>加入条件</th>
        <th>操作</th>
    </tr>
    <%
        // Get the user list attribute
        List<User> userList = (List<User>) request.getAttribute("UserList");

        // Check if the userList is not null before iterating over it
        if (userList != null) {
            // Iterate over the user list and display the table rows
            for (User user : userList) {
    %>
    <tr>
        <td><%= user.getUserid() %></td>
        <td><%= user.getUsername() %></td>
        <td><%= user.getUserpwd() %></td>
        <td><form action="updatej" method="post">
            <input type="hidden" name="id" value="<%= user.getUserid() %>">
            <select name="job">
                <option value="员工" <%= user.getJob() != null && user.getJob().equals("员工") ? "selected" : "" %>>员工</option>
                <option value="经理" <%= user.getJob() != null && user.getJob().equals("经理") ? "selected" : "" %>>经理</option>
            </select>
            <input type="submit" value="更新">
        </form>
        </td>
        <td><form action="updated" method="post">
            <input type="hidden" name="id" value="<%= user.getUserid() %>">
            <select name="department">
                <option value="开发" <%= user.getDepartment() != null && user.getDepartment().equals("开发") ? "selected" : "" %>>开发</option>
                <option value="运维" <%= user.getDepartment() != null && user.getDepartment().equals("运维") ? "selected" : "" %>>运维</option>
                <option value="销售" <%= user.getDepartment() != null && user.getDepartment().equals("销售") ? "selected" : "" %>>销售</option>
            </select>
            <input type="submit" value="更新">
        </form>
        </td>
        <td><%= user.getJoincondition() %></td>
        <td>
            <form action="deleteu" method="post">
                <input type="hidden" name="id" value="<%= user.getUserid() %>">
                <input type="submit" value="删除">
            </form>
            <form action="updateu" method="post">
                <input type="hidden" name="id" value="<%= user.getUserid() %>">
                <select name="ability">
                    <option value="启用" <%= user.getAbility() != null && user.getAbility().equals("启用") ? "selected" : "" %>>启用</option>
                    <option value="禁用" <%= user.getAbility() != null && user.getAbility().equals("禁用") ? "selected" : "" %>>禁用</option>
                </select>
                <input type="submit" value="更新">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
<a href="adminindex.jsp">返回</a>
</body>
</html>