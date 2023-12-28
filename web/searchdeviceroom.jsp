<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/20
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查看会议室设备</title>
</head>
<body>
<h2>查看${roomname}设备</h2>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>设备id</th><th>设备名称</th><th>设备所属会议室</th></tr>
            <c:forEach items="${devicelist}" var="device">
                <tr>
                    <td>${device.deviceid}</td>
                    <td>${device.devicename}</td>
                    <td>${device.devicemeetroom}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount==0}">
        <p>该会议室没有分配设备</p>
    </c:if><br>
</div>
<a href="roomadmin01">返回</a>
</body>
</html>
