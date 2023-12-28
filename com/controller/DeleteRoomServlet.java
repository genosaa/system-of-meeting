package com.controller;

import com.dao.DeviceDao;
import com.dao.DeviceDaoImpl;
import com.dao.RoomDao;
import com.dao.RoomDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteRoomServlet" , urlPatterns = "/deleteroom")
public class DeleteRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int roomid = Integer.parseInt(request.getParameter("roomid"));
        String roomname = request.getParameter("roomname");
        RoomDao roomdao = new RoomDaoImpl();
        DeviceDao devicedao = new DeviceDaoImpl();
        if(roomdao.deleteroom(roomid) && devicedao.deletemeetroom(roomname)){
            request.setAttribute("mmm","删除成功");
            RequestDispatcher rd = request.getRequestDispatcher("roomadmin");
            rd.forward(request, response);
        }else{
            request.setAttribute("mmm","删除失败");
            RequestDispatcher rd = request.getRequestDispatcher("roomadmin");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
