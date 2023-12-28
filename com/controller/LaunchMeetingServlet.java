package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.entity.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

@WebServlet(name = "LaunchMeetingServlet" , urlPatterns = "/launchmeeting")
public class LaunchMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String launchuser = (String) session.getAttribute("username");
        String meetname = request.getParameter("meetname");
        String startTimeStr = request.getParameter("starttime");
        String endTimeStr = request.getParameter("endtime");
        String predictnumber01 = request.getParameter("predictnumber");
        if (!meetname.equals("") && !startTimeStr.equals("") && !endTimeStr.equals("") &&  !predictnumber01.equals("")) {
// 将获取到的时间字符串转换为LocalDateTime对象
            int predictnumber = Integer.parseInt(predictnumber01);
            LocalDateTime startTime = LocalDateTime.parse(startTimeStr);
            LocalDateTime endTime = LocalDateTime.parse(endTimeStr);
// 将LocalDateTime对象转换为Timestamp对象
            java.sql.Timestamp starttime = java.sql.Timestamp.valueOf(startTime);
            java.sql.Timestamp endtime = java.sql.Timestamp.valueOf(endTime);
            if (startTime.isAfter(endTime)) {
                session.setAttribute("message", "开始时间不能晚于截至时间");
                response.sendRedirect("searchmeetinglaunch");
                return;
            }
            LocalDateTime currentDateTime = LocalDateTime.now();
            if (currentDateTime.isAfter(startTime)) {
                session.setAttribute("message", "开始时间不能早于当前时间");
                response.sendRedirect("searchmeetinglaunch");
                return;
            }
            Meeting meeting = new Meeting();
            meeting.setMeetname(meetname);
            meeting.setStarttime(starttime);
            meeting.setEndtime(endtime);
            meeting.setState("会议室申请中");
            meeting.setLaunchuser(launchuser);
            meeting.setPredictnumber(predictnumber);
            meeting.setNumber(0);
            MeetingDao dao = new MeetingDaoImpl();
            if (dao.launchmeeting(meeting)) {
                session.setAttribute("message", "添加会议成功");
                response.sendRedirect("searchmeetinglaunch");
            } else {
                session.setAttribute("message", "添加会议失败");
                response.sendRedirect("searchmeetinglaunch");
            }
        }else{
            session.setAttribute("message", "添加会议失败，请将信息填写完整！");
            response.sendRedirect("searchmeetinglaunch");
        }
    }
}
