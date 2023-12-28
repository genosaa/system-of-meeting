<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/20
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>会议设备管理</title>
</head>
<body>
<h2>会议设备管理</h2>
<div id="launch">
    <form method="get" action="adddevice">
        设备名称：<input type="text" name="devicename"><br>
        <input type="submit" name="btn1" value="添加设备"><br>
    </form>
</div>
<div id="info">
    ${message}
</div>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>设备id</th><th>设备名称</th><th>设备所属会议室</th><th>操作</th></tr>
            <c:forEach items="${devicelist}" var="device">
                <tr>
                    <td>${device.deviceid}</td>
                    <td>${device.devicename}</td>
                    <td>${device.devicemeetroom}</td>
                    <td>
                        <c:if test="${device.devicemeetroom=='无'}">
                            <a href="assigndevice?deviceid=${device.deviceid}">分配</a>
                        </c:if>
                        <c:if test="${device.devicemeetroom!='无'}">
                            <a href="regaindevice?deviceid=${device.deviceid}">收回</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount==0}">
        <p>没有会议设备</p>
    </c:if><br>
</div>
<a href="adminindex.jsp">返回</a>
</body>
</html>
