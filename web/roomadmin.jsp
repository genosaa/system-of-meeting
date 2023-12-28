<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/20
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>会议室管理</title>
</head>
<body>
<h2>对空闲的会议室进行管理</h2>
<div id="add">
    <form method="get" action="addroom">
        会议室名称：<input type="text" name="roomname"><br>
        会议室容纳人数：<input type="number" name="hold"><br>
        <input type="submit" name="btn1" value="添加会议室"><br>
    </form>
</div>
<div id="info">
    ${mmm}
</div>
<div id="01">
    <c:if test="${pagecount>0}">
    <table border="1">
        <tr><th>会议室id</th><th>会议室名称</th><th>会议室容纳人数</th><th>操作</th></tr>
        <c:forEach items="${roomleisurelist}" var="room">
            <tr>
                <td>${room.roomid}</td>
                <td>${room.roomname}</td>
                <td>${room.hold}</td>
                <td>
                    <a href="updateroom?roomid=${room.roomid}&roomname=${room.roomname}&hold=${room.hold}">修改</a><br>
                    <a href="deleteroom?roomid=${room.roomid}&roomname=${room.roomname}">删除</a><br>
                </td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
    <c:if test="${pagecount==0}">
    <p>目前没有空闲的会议室</p>
    </c:if><br>
</div>
</body>
<a href="roomadmin01">查看所有会议室</a>
<a href="adminindex.jsp">返回</a>
</html>
