<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/19
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>修改会议内容</title>
</head>
<body>
<h2>修改会议${meetname}的内容</h2>
<div id="update">
    <form method="get" action="updatemeeting01">
        <input type="text" name="meetname" value="${meetname}" style="display: none">
        <input type="datetime-local" name="starttime" value="${starttime}" style="display: none">
        <input type="datetime-local" name="endtime" value="${endtime}" style="display: none">
        <input type="number" name="predictnumber" value="${predictnumber}" style="display: none">
        会议名称：<input type="text" name="meetname01" value="${meetname}"><br>
        会议开始时间：<input type="datetime-local" name="starttime01" value="${starttime}"><br>
        会议结束时间：<input type="datetime-local" name="endtime01" value="${endtime}"><br>
        会议预计人数：<input type="number" name="predictnumber01" value="${predictnumber}"><br>
        <input type="submit" name="btn1" value="修改"><br>
    </form>
</div>
<div id="info">
    ${message1}
</div>
<a href="searchmeetinglaunch">返回</a>
</body>
</html>
