<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/18
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>确认自己所有通知</title>
</head>
<body>
<h2>查看所有会议通知</h2>
<div id="01">
    <c:if test="${pagecount01>0}">
        <table border="1">
            <tr><th>通知id</th><th>会议名字</th><th>会议室</th><th>开始时间</th><th>结束时间</th><th>发起人名字</th><th>参会者名字</th><th>通知状态</th></tr>
            <c:forEach items="${meetinginformjoinlist01}" var="meetinginform">
                <tr>
                    <td>${meetinginform.informid}</td>
                    <td>${meetinginform.meetname}</td>
                    <td>${meetinginform.meetroom}</td>
                    <td>${meetinginform.starttime}</td>
                    <td>${meetinginform.endtime}</td>
                    <td>${meetinginform.launchname}</td>
                    <td>${meetinginform.username}</td>
                    <td>${meetinginform.joincondition}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount01==0}">
        <p>目前没有记录</p>
    </c:if><br>
</div>
<a href="searchmeetingjoin">返回</a>
</body>
</html>
