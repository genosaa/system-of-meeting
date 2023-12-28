package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.entity.Meetinginform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchmeetingjoinServlet01" , urlPatterns = "/searchmeetingjoin01")
public class SearchmeetingjoinServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        MeetingDao dao = new MeetingDaoImpl();
        try{
            List<Meetinginform> meetinginformjoinlist01 = dao.searchmeetingjoin01(username);
            request.setAttribute("meetinginformjoinlist01",meetinginformjoinlist01);
            Integer pagecount01 = new Integer(dao.meetingmeetingjoincount01(username));
            request.setAttribute("pagecount01",pagecount01);
            request.setAttribute("username",username);
            RequestDispatcher rd = request.getRequestDispatcher("searchmeetingjoin01.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
