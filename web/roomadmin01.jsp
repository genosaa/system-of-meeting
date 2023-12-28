<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/20
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查看所有会议室</title>
</head>
<body>
<h2>查看所有会议室</h2>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>会议室id</th><th>会议室名称</th><th>会议室容纳人数</th><th>操作</th></tr>
            <c:forEach items="${roomalllist}" var="room">
                <tr>
                    <td>${room.roomid}</td>
                    <td>${room.roomname}</td>
                    <td>${room.hold}</td>
                    <td>
                        <a href="searchdevice?roomname=${room.roomname}">查看设备配置</a><br>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount==0}">
        <p>没有会议室</p>
    </c:if><br>
</div>
<a href="roomadmin">返回</a>
</body>
</html>
