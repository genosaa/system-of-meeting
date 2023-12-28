<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/17
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查看会议室需审批申请记录</title>
</head>
<body>
<h2>查看会议室申请</h2>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>会议室申请id</th><th>会议室名称</th><th>会议名称</th><th>发起会议人</th><th>会议开始时间</th><th>会议结束时间</th><th>会议室申请状态</th><th>操作</th></tr>
            <c:forEach items="${roomapplylist}" var="roomapply">
                <tr>
                    <td>${roomapply.applyid}</td>
                    <td>${roomapply.roomname}</td>
                    <td>${roomapply.meetname}</td>
                    <td>${roomapply.launchname}</td>
                    <td>${roomapply.starttime}</td>
                    <td>${roomapply.endtime}</td>
                    <td>${roomapply.roomtype}</td>
                    <td>
                        <c:if test="${roomapply.roomtype=='预约申请中'}">
                            <a href="yesapply?applyid=${roomapply.applyid}&meetname=${roomapply.meetname}">通过申请</a><br>
                            <a href="noapply?applyid=${roomapply.applyid}&meetname=${roomapply.meetname}">驳回申请</a><br>
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
<a href="auditroom01">查看所有会议室申请记录</a>
<a href="adminindex.jsp">返回</a>
</body>
</html>
