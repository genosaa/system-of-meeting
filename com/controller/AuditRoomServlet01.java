package com.controller;

import com.dao.RoomDao;
import com.dao.RoomDaoImpl;
import com.entity.Roomapply;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AuditRoomServlet01" , urlPatterns = "/auditroom01")
public class AuditRoomServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        RoomDao dao = new RoomDaoImpl();
        try{
            List<Roomapply> roomapplylist01 = dao.searchroomapply01();
            request.setAttribute("roomapplylist01",roomapplylist01);
            Integer pagecount01 = new Integer(dao.roomapplycount01());
            request.setAttribute("pagecount01",pagecount01);
            RequestDispatcher rd = request.getRequestDispatcher("auditroom01.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
