package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.entity.Meeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchMeetingLaunchServlet01" , urlPatterns = "/searchmeetinglaunch01")
public class SearchMeetingLaunchServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        MeetingDao dao = new MeetingDaoImpl();
        try{
            List<Meeting> meetinglist01 = dao.searchmeeting01(username);
            request.setAttribute("meetinglist01",meetinglist01);
            Integer pagecount01 = new Integer(dao.meetingcount01(username));
            request.setAttribute("pagecount01",pagecount01);
            RequestDispatcher rd = request.getRequestDispatcher("launchmeeting01.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
