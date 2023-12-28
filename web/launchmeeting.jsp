<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/15
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>发起会议</title>
</head>
<body>
<h2>会议预约管理</h2>
<div id="launch">
    <form method="get" action="launchmeeting">
        会议名称：<input type="text" name="meetname"><br>
        会议开始时间：<input type="datetime-local" name="starttime"><br>
        会议结束时间：<input type="datetime-local" name="endtime"><br>
        会议预计人数：<input type="number" name="predictnumber"><br>
        <input type="submit" name="btn1" value="发起会议"><br>
    </form>
</div>
<div id="info">
    ${message}
</div>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>会议id</th><th>会议名称</th><th>会议室</th><th>会议开始时间</th><th>会议结束时间</th><th>会议状态</th><th>会议发起者</th><th>预计参会人数</th><th>确定参会人数</th><th>操作</th></tr>
            <c:forEach items="${meetinglist}" var="meeting">
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
                    <td>
                        <a href="updatemeeting?meetname=${meeting.meetname}&starttime=${meeting.starttime}&endtime=${meeting.endtime}&predictnumber=${meeting.predictnumber}">修改会议内容</a><br>
                        <c:if test="${meeting.state=='会议室申请中'}">
                            <a href="applyroom?meetname=${meeting.meetname}&predictnumber=${meeting.predictnumber}&starttime=${meeting.starttime}&endtime=${meeting.endtime}">申请会议室</a><br>
                        </c:if>
                        <c:if test="${meeting.state=='会议室审核被驳回重新申请中'}">
                            <a href="applyroom?meetname=${meeting.meetname}&predictnumber=${meeting.predictnumber}&starttime=${meeting.starttime}&endtime=${meeting.endtime}">申请会议室</a><br>
                        </c:if>
                        <c:if test="${meeting.state=='会议室申请成功上传会议文件中'}">
                            <a href="uploadfile?meetname=${meeting.meetname}">上传会议文件</a><br>
                            <a href="nouploadfile?meetname=${meeting.meetname}">无需上传文件（上传完成）</a><br>
                        </c:if>
                        <c:if test="${meeting.state=='通知人员参会等待会议开始中'}">
                            <a href="informuser?meetname=${meeting.meetname}&meetroom=${meeting.meetroom}">通知人员参会</a><br>
                            <a href="accomplishmeeting?meetname=${meeting.meetname}">会议完成</a><br>
                        </c:if>
                        <c:if test="${meeting.state=='会议室申请中' || meeting.state=='会议室被驳回重新申请中'}">
                            <a href="cancelmeeting?meetname=${meeting.meetname}">取消会议</a>
                        </c:if>
                        <c:if test="${meeting.state=='会议室审核中' || meeting.state=='会议室申请成功上传会议文件中' || meeting.state=='通知人员参会等待会议开始中'}">
                            <a href="cancelmeeting01?meetname=${meeting.meetname}">取消会议</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount==0}">
        <p>目前没有正在预约的会议</p>
    </c:if><br>
</div>
<a href="searchmeetinglaunch01">查看所有会议预约记录</a>
<a href="userindex.jsp">返回</a>
</body>
</html>
