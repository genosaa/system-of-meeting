package com.controller;

import com.dao.*;
import com.entity.Meeting;
import com.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InformUserServlet" , urlPatterns = "/informuser")
public class InformUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String meetname = request.getParameter("meetname");
        String meetroom = request.getParameter("meetroom");
        UserDao userdao = new UserDaoImpl();
        RoomDao roomdao = new RoomDaoImpl();
        MeetingDao meetingdao = new MeetingDaoImpl();
        try{
            List<User> userlist = userdao.searchuserinform();
            request.setAttribute("userlist",userlist);
            Integer pagecount = new Integer(userdao.userinformcount());
            List<String> usernamelist = userdao.searchmeetinginform(meetname);
            request.setAttribute("usernamelist",usernamelist);
            int roomhold = roomdao.roomhold(meetroom);
            int numbercount =  meetingdao.numbercount(meetname);
            request.setAttribute("meetname",meetname);
            request.setAttribute("meetroom",meetroom);
            request.setAttribute("roomhold",roomhold);
            request.setAttribute("pagecount",pagecount);
            request.setAttribute("numbercount",numbercount);
            RequestDispatcher rd = request.getRequestDispatcher("informuser.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
