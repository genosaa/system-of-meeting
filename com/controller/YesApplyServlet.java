package com.controller;

import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.dao.RoomDao;
import com.dao.RoomDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "YesApplyServlet" , urlPatterns = "/yesapply")
public class YesApplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int applyid = Integer.parseInt(request.getParameter("applyid"));
        String meetname = request.getParameter("meetname");
        MeetingDao meetdao = new MeetingDaoImpl();
        RoomDao roomdao = new RoomDaoImpl();
        if(meetdao.yesapplymeeting(meetname) && roomdao.yesapplyroomapply(applyid)){
            response.sendRedirect("auditroom");
        }else{
            response.sendRedirect("auditroom");
        }
    }
}
