<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/18
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>确认自己需要参加的会议</title>
</head>
<body>
<h2>查看待确认会议通知</h2>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>通知id</th><th>会议名字</th><th>会议室</th><th>开始时间</th><th>结束时间</th><th>发起人名字</th><th>参会者名字</th><th>通知状态</th><th>操作</th></tr>
            <c:forEach items="${meetinginformjoinlist}" var="meetinginform">
                <tr>
                    <td>${meetinginform.informid}</td>
                    <td>${meetinginform.meetname}</td>
                    <td>${meetinginform.meetroom}</td>
                    <td>${meetinginform.starttime}</td>
                    <td>${meetinginform.endtime}</td>
                    <td>${meetinginform.launchname}</td>
                    <td>${meetinginform.username}</td>
                    <td>${meetinginform.joincondition}</td>
                    <td>
                            <c:if test="${meetinginform.joincondition=='待确认参会'}">
                                <a href="downloadfile?meetname=${meetinginform.meetname}">下载会议文件</a><br>
                                <a href="yesjoinmeeting?informid=${meetinginform.informid}&username=${meetinginform.username}&meetname=${meetinginform.meetname}">确定参会</a><br>
                                <a href="nojoinmeeting?informid=${meetinginform.informid}&username=${meetinginform.username}&meetname=${meetinginform.meetname}">拒绝参会</a><br>
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
<a href="searchmeetingjoin01">查看自己所有会议记录</a>
<a href="userindex.jsp">返回</a>
</body>
</html>
