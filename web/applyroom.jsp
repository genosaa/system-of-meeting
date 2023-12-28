<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/17
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>申请会议室</title>
</head>
<body>
<h2>申请会议室</h2>
<div id="info">
    会议名称：${meetname}<br>
    预计参会人数：${predictnumber}<br>
    会议申请状态：${meetstate}
</div>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>会议室id</th><th>会议室名称</th><th>会议室容量</th><th>操作</th></tr>
            <c:forEach items="${roomlist}" var="room">
                <tr>
                    <td>${room.roomid}</td>
                    <td>${room.roomname}</td>
                    <td>${room.hold}</td>
                    <td>
                    <c:if test="${meetstate=='会议室申请中' || meetstate=='会议室审核被驳回重新申请中'}">
                            <a href="applyroom01?roomname=${room.roomname}&meetname=${meetname}&starttime=${starttime}&endtime=${endtime}&predictnumber=${predictnumber}">申请</a><br>
                    </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount==0}">
        <p>目前没有记录</p>
    </c:if><br>
</div>
<a href="searchmeetinglaunch">返回</a>
</body>
</html>
