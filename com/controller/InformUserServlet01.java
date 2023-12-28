package com.controller;

import com.dao.RoomDao;
import com.dao.RoomDaoImpl;
import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "InformUserServlet01" , urlPatterns = "/informuser01")
public class InformUserServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String meetname = request.getParameter("meetname");
        String meetroom = request.getParameter("meetroom");
        UserDao userdao = new UserDaoImpl();
        if(userdao.userinform(username,meetname,meetroom)){
            String encodedMeetname = URLEncoder.encode(String.valueOf(meetname), "UTF-8");
            String encodedMeetroom = URLEncoder.encode(String.valueOf(meetroom), "UTF-8");
            response.sendRedirect("informuser?meetname=" + encodedMeetname + "&meetroom=" + encodedMeetroom);
        }else{
            String encodedMeetname = URLEncoder.encode(String.valueOf(meetname), "UTF-8");
            String encodedMeetroom = URLEncoder.encode(String.valueOf(meetroom), "UTF-8");
            response.sendRedirect("informuser?meetname=" + encodedMeetname + "&meetroom=" + encodedMeetroom);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
