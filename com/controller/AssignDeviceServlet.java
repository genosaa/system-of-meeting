package com.controller;

import com.dao.RoomDao;
import com.dao.RoomDaoImpl;
import com.entity.Meetinginform;
import com.entity.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AssignDeviceServlet" , urlPatterns = "/assigndevice")
public class AssignDeviceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int deviceid = Integer.parseInt(request.getParameter("deviceid"));
        RoomDao roomdao = new RoomDaoImpl();
        try{
            List<Room> roomlist = roomdao.searchroomall();
            request.setAttribute("roomlist",roomlist);
            Integer pagecount = new Integer(roomdao.roomcountall());
            request.setAttribute("pagecount",pagecount);
            request.setAttribute("deviceid",deviceid);
            RequestDispatcher rd = request.getRequestDispatcher("assigndevice.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
