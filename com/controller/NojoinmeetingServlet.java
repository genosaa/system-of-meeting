package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NojoinmeetingServlet" , urlPatterns = "/nojoinmeeting")
public class NojoinmeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String informid = request.getParameter("informid");
        String username = request.getParameter("username");
        String meetname = request.getParameter("meetname");
        MeetingDao meetingdao = new MeetingDaoImpl();
        if(meetingdao.nojoinmeeting(informid,username,meetname)){
            response.sendRedirect("searchmeetingjoin");
        }else{
            response.sendRedirect("searchmeetingjoin");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
