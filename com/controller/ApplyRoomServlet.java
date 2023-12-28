package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.dao.RoomDao;
import com.dao.RoomDaoImpl;
import com.entity.Meeting;
import com.entity.Room;

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
import java.util.List;

@WebServlet(name = "ApplyRoomServlet" , urlPatterns = "/applyroom")
public class ApplyRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String meetname = request.getParameter("meetname");
        int predictnumber = Integer.parseInt(request.getParameter("predictnumber"));
        String startTimeStr = request.getParameter("starttime");
        String endTimeStr = request.getParameter("endtime");
        // 将获取到的时间字符串转换为LocalDateTime对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime startTime = LocalDateTime.parse(startTimeStr, formatter);
        LocalDateTime endTime = LocalDateTime.parse(endTimeStr, formatter);
// 将LocalDateTime对象转换为Timestamp对象
        java.sql.Timestamp starttime = java.sql.Timestamp.valueOf(startTime);
        java.sql.Timestamp endtime = java.sql.Timestamp.valueOf(endTime);
        MeetingDao dao = new MeetingDaoImpl();
        String meetstate = dao.checkmeetingstate(meetname);
        HttpSession session = request.getSession();
        request.setAttribute("meetstate", meetstate);
        request.setAttribute("meetname",meetname);
        request.setAttribute("predictnumber",predictnumber);
        request.setAttribute("starttime",starttime);
        request.setAttribute("endtime",endtime);
        RoomDao daoo = new RoomDaoImpl();
        List<Room> roomlist = daoo.searchroom(predictnumber,starttime,endtime);
        request.setAttribute("roomlist",roomlist);
        Integer pagecount = new Integer(daoo.roomcount(predictnumber,starttime,endtime));
        request.setAttribute("pagecount",pagecount);
        session.setAttribute("message", "");
        RequestDispatcher rd = request.getRequestDispatcher("applyroom.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
