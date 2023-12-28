<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/18
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>通知用户参加会议</title>
</head>
<body>
<c:set var="count" value="0" />
<c:forEach items="${usernamelist}" var="id">
    <c:set var="count" value="${count + 1}" />
</c:forEach>
<h2>通知用户参加会议</h2>
<h3>会议名称：${meetname}<br>
    会议室名称：${meetroom}<br>
    会议室可容纳人数：${roomhold}<br>
    已通知人数：${count}<br>
    确定参会人数：${numbercount}</h3>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>用户id</th><th>用户名字</th><th>用户职位</th><th>用户部门</th><th>操作</th></tr>
            <c:forEach items="${userlist}" var="user">
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.username}</td>
                    <td>${user.job}</td>
                    <td>${user.department}</td>
                    <td>
                        <c:if test="${count<roomhold}">
                            <c:if test="${not usernamelist.contains(user.username)}">
                                <a href="informuser01?username=${user.username}&meetname=${meetname}&meetroom=${meetroom}">通知</a>
                            </c:if>
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
