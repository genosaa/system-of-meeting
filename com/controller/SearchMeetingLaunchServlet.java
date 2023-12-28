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

@WebServlet(name = "SearchMeetingLaunchServlet" , urlPatterns = "/searchmeetinglaunch")
public class SearchMeetingLaunchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        MeetingDao dao = new MeetingDaoImpl();
        try{
            List<Meeting> meetinglist = dao.searchmeeting(username);
            request.setAttribute("meetinglist",meetinglist);
            Integer pagecount = new Integer(dao.meetingcount(username));
            request.setAttribute("pagecount",pagecount);
            RequestDispatcher rd = request.getRequestDispatcher("launchmeeting.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
