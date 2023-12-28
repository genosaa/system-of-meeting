package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CancelMeetingServlet" , urlPatterns = "/cancelmeeting")
public class CancelMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String meetname = request.getParameter("meetname");
        MeetingDao meetingdao = new MeetingDaoImpl();
        if(meetingdao.cancelmeeting(meetname)){
            response.sendRedirect("searchmeetinglaunch");
        }else{
            response.sendRedirect("searchmeetinglaunch");
        }
    }
}
