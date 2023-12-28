<%@ page import="com.entity.liuyan" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <th>状态</th>
        <th>操作</th>
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
        <td><%=ly.getState()%></td>
        <td>
            <form action="delete" method="post">
                <input type="hidden" name="id" value="<%=ly.getId()%>">
                <input type="submit" value="举报删除">
            </form>
            <form action="update" method="post">
                <input type="hidden" name="id" value="<%=ly.getId()%>">
                <select name="state">
                    <option value="启用">启用</option>
                    <option value="禁用">禁用</option>
                </select>
                <input type="submit" value="更新">
            </form>
        </td>
    </tr>
    <% } %>
</table>
<a href="adminindex.jsp">返回</a>
</body>
</html>
