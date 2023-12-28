package com.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "UpdateMeetingServlet" , urlPatterns = "/updatemeeting")
public class UpdateMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        session.setAttribute("message","");
        String meetname = request.getParameter("meetname");
        String startTimeStr = request.getParameter("starttime");
        String endTimeStr = request.getParameter("endtime");
        // 将获取到的时间字符串转换为LocalDateTime对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        // 将获取到的时间字符串转换为LocalDateTime对象
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);
// 将LocalDateTime对象转换为Timestamp对象
        java.sql.Timestamp starttime = java.sql.Timestamp.valueOf(startTime);
        java.sql.Timestamp endtime = java.sql.Timestamp.valueOf(endTime);
        int predictnumber = Integer.parseInt(request.getParameter("predictnumber"));
        request.setAttribute("meetname", meetname);
        request.setAttribute("starttime", starttime);
        request.setAttribute("endtime", endtime);
        request.setAttribute("predictnumber", predictnumber);
        RequestDispatcher rd = request.getRequestDispatcher("updatemeeting.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
