package com.controller;


import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "NoUploadFileServlet" , urlPatterns = "/nouploadfile")
public class NoUploadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String meetname = request.getParameter("meetname");
        MeetingDao meetdao = new MeetingDaoImpl();
        UserDao userdao = new UserDaoImpl();
        if(meetdao.nouploadfile(meetname) && userdao.userinformlaunch(username,meetname) && meetdao.addadd(meetname)){
            response.sendRedirect("searchmeetinglaunch");
        }else{
            response.sendRedirect("searchmeetinglaunch");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
