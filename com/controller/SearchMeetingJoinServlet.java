package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.entity.Meeting;
import com.entity.Meetinginform;
import com.entity.Roomapply;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchMeetingJoinServlet" , urlPatterns = "/searchmeetingjoin")
public class SearchMeetingJoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        MeetingDao dao = new MeetingDaoImpl();
        try{
            List<Meetinginform> meetinginformjoinlist = dao.searchmeetingjoin(username);
            request.setAttribute("meetinginformjoinlist",meetinginformjoinlist);
            Integer pagecount = new Integer(dao.meetingmeetingjoincount(username));
            request.setAttribute("pagecount",pagecount);
            request.setAttribute("username",username);
            RequestDispatcher rd = request.getRequestDispatcher("searchmeetingjoin.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
