<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/19
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查看所有会议预约记录</title>
</head>
<body>
<h2>查看所有会议预约记录</h2>
<div id="01">
    <c:if test="${pagecount01>0}">
        <table border="1">
            <tr><th>会议id</th><th>会议名称</th><th>会议室</th><th>会议开始时间</th><th>会议结束时间</th><th>会议状态</th><th>会议发起者</th><th>预计参会人数</th><th>确定参会人数</th></tr>
            <c:forEach items="${meetinglist01}" var="meeting">
                <tr>
                    <td>${meeting.meetid}</td>
                    <td>${meeting.meetname}</td>
                    <td>${meeting.meetroom}</td>
                    <td>${meeting.starttime}</td>
                    <td>${meeting.endtime}</td>
                    <td>${meeting.state}</td>
                    <td>${meeting.launchuser}</td>
                    <td>${meeting.predictnumber}</td>
                    <td>${meeting.number}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount01==0}">
        <p>没有会议预约记录</p>
    </c:if><br>
</div>
<a href="searchmeetinglaunch">返回</a>
</body>
</html>
