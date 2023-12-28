package com.controller;

import com.dao.RoomDao;
import com.dao.RoomDaoImpl;
import com.entity.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RoomAdminServlet01" , urlPatterns = "/roomadmin01")
public class RoomAdminServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        RoomDao roomdao = new RoomDaoImpl();
        try{
            List<Room> roomalllist = roomdao.searchroomall();
            request.setAttribute("roomalllist",roomalllist);
            Integer pagecount = new Integer(roomdao.roomcountall());
            request.setAttribute("pagecount",pagecount);
            RequestDispatcher rd = request.getRequestDispatcher("roomadmin01.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
