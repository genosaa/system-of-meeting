package com.controller;

import com.dao.RoomDao;
import com.dao.RoomDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateRoomServlet01" , urlPatterns = "/updateroom01")
public class UpdateRoomServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int roomid = Integer.parseInt(request.getParameter("roomid"));
        String roomname = request.getParameter("roomname");
        String hold01 = request.getParameter("hold");
        if (!roomname.equals("") && !hold01.equals("")) {
            int hold = Integer.parseInt(hold01);
            RoomDao roomdao = new RoomDaoImpl();
            if (roomdao.updateroom(roomid, roomname, hold)) {
                request.setAttribute("mmm","修改成功");
                RequestDispatcher rd = request.getRequestDispatcher("roomadmin");
                rd.forward(request, response);
            } else {
                request.setAttribute("mmm","修改失败");
                RequestDispatcher rd = request.getRequestDispatcher("roomadmin");
                rd.forward(request, response);
            }
        }else{
            request.setAttribute("mmm","修改失败，未将内容填写完整");
            RequestDispatcher rd = request.getRequestDispatcher("roomadmin");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
