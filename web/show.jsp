<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/21
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.liuyan" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>留言板</title>
</head>
<body>
<%
    String message = request.getParameter("message");
    if (message != null && message.equals("success")) {
        out.println("<div class='message'>成功</div>");
    } else if (message != null && message.equals("error")) {
        out.println("<div class='message'>失败</div>");
    }
%>
<h2>留言板</h2>
<table border="1">
    <tr>
        <th>留言人</th>
        <th>留言内容</th>
        <th>留言时间</th>
    </tr>

    <%
        // 获取留言信息列表
        List<liuyan> liuyanList = (List<liuyan>)request.getAttribute("liuyanList");
        // 遍历留言信息列表并输出表格内容

        for (liuyan ly : liuyanList) {
    %>
    <tr>
        <td><%=ly.getName()%></td>
        <td><%=ly.getNr()%></td>
        <td><%=ly.getTime()%></td>
    </tr>
    <% } %>
</table>
<a href="userindex.jsp">返回</a>
</body>
</html>
