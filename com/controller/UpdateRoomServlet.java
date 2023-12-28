package com.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateRoomServlet" , urlPatterns = "/updateroom")
public class UpdateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int roomid = Integer.parseInt(request.getParameter("roomid"));
        String roomname = request.getParameter("roomname");
        int hold = Integer.parseInt(request.getParameter("hold"));
        request.setAttribute("roomid",roomid);
        request.setAttribute("roomname",roomname);
        request.setAttribute("hold",hold);
        RequestDispatcher rd = request.getRequestDispatcher("updateroom.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
