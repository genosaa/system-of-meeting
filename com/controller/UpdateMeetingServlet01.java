package com.controller;

import com.dao.*;
import com.entity.Meeting;

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

@WebServlet(name = "UpdateMeetingServlet01" , urlPatterns = "/updatemeeting01")
public class UpdateMeetingServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String meetname = request.getParameter("meetname");
        String startTimeStr = request.getParameter("starttime");
        String endTimeStr = request.getParameter("endtime");
        String predictnumber001 = request.getParameter("predictnumber");
        String meetname01 = request.getParameter("meetname01");
        String startTimeStr01 = request.getParameter("starttime01");
        String endTimeStr01 = request.getParameter("endtime01");
        String predictnumber0001 = request.getParameter("predictnumber01");
        if (!meetname01.equals("") && !startTimeStr01.equals("") && !endTimeStr01.equals("") &&  !predictnumber0001.equals("")) {
            int predictnumber01 = Integer.parseInt(predictnumber0001);
            LocalDateTime startTime01 = LocalDateTime.parse(startTimeStr01);
            LocalDateTime endTime01 = LocalDateTime.parse(endTimeStr01);
            java.sql.Timestamp starttime01 = java.sql.Timestamp.valueOf(startTime01);
            java.sql.Timestamp endtime01 = java.sql.Timestamp.valueOf(endTime01);
            RoomDao roomdao = new RoomDaoImpl();
            if (startTime01.isAfter(endTime01)) {
                request.setAttribute("message", "修改失败开始时间不能晚于截至时间");
                RequestDispatcher rd = request.getRequestDispatcher("searchmeetinglaunch");
                rd.forward(request, response);
                return;
            }
            LocalDateTime currentDateTime = LocalDateTime.now();
            if (currentDateTime.isAfter(startTime01)) {
                request.setAttribute("message", "修改失败开始时间不能早于当前时间");
                RequestDispatcher rd = request.getRequestDispatcher("searchmeetinglaunch");
                rd.forward(request, response);
                return;
            }
            if(roomdao.checkupdateroom(meetname,starttime01,endtime01)!=0){
                request.setAttribute("message", "修改失败该时间段此会议被占用");
                RequestDispatcher rd = request.getRequestDispatcher("searchmeetinglaunch");
                rd.forward(request, response);
                return;
            }
            MeetingDao meetingdao = new MeetingDaoImpl();
            FileDao filedao = new FileDaoImpl();
            meetingdao.updatemeeting(meetname,meetname01,starttime01,endtime01,predictnumber01);
            meetingdao.updatemeetinginform(meetname,meetname01,starttime01,endtime01);
            roomdao.updatemeetingroom(meetname,meetname01,starttime01,endtime01);
            filedao.updatemeetingfile(meetname,meetname01);
            request.setAttribute("message","修改成功");
            RequestDispatcher rd = request.getRequestDispatcher("searchmeetinglaunch");
            rd.forward(request, response);
        }else{
            request.setAttribute("message","修改失败信息未填写完整");
            RequestDispatcher rd = request.getRequestDispatcher("searchmeetinglaunch");
            rd.forward(request, response);
        }
    }
}
