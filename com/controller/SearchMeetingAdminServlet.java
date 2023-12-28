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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchMeetingAdminServlet" , urlPatterns = "/searchmeetingadmin")
public class SearchMeetingAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        MeetingDao dao = new MeetingDaoImpl();
        try{
            List<Meeting> meetingalllist = dao.searchmeetingadmin();
            request.setAttribute("meetingalllist",meetingalllist);
            Integer pagecount = new Integer(dao.meetingadmincount());
            request.setAttribute("pagecount",pagecount);
            RequestDispatcher rd = request.getRequestDispatcher("searchmeetingadmin.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
