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

@WebServlet(name = "NoapplyServlet" , urlPatterns = "/noapply")
public class NoapplyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int applyid = Integer.parseInt(request.getParameter("applyid"));
        String meetname = request.getParameter("meetname");
        MeetingDao meetdao = new MeetingDaoImpl();
        RoomDao roomdao = new RoomDaoImpl();
        if(meetdao.noapplymeeting(meetname) && roomdao.noapplyroomapply(applyid)){
            response.sendRedirect("auditroom");
        }else{
            response.sendRedirect("auditroom");
        }
    }
}
