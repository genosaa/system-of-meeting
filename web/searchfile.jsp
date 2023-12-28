<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/19
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>查看下载会议文件</title>
</head>
<body>
<h2>查看下载会议文件</h2>
<div id="01">
    <c:if test="${pagecount>0}">
        <table border="1">
            <tr><th>文件id</th><th>文件名字</th><th>会议名字</th><th>上传者</th><th>操作</th></tr>
            <c:forEach items="${filelist}" var="filee">
                <tr>
                    <td>${filee.fileid}</td>
                    <td>${filee.filename}</td>
                    <td>${filee.meetname}</td>
                    <td>${filee.launchuser}</td>
                    <td>
                        <a href="downloadfile01?fileid=${filee.fileid}">下载</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${pagecount==0}">
        <p>目前没有记录</p>
    </c:if><br>
</div>
<a href="searchmeetingjoin">返回</a>
</body>
</html>
