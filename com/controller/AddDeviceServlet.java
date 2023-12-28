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

@WebServlet(name = "AddDeviceServlet" , urlPatterns = "/adddevice")
public class AddDeviceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String devicename = request.getParameter("devicename");
        if (!devicename.equals("")) {
            DeviceDao devicedao = new DeviceDaoImpl();
            if (devicedao.adddevice(devicename)) {
                request.setAttribute("message","添加成功");
                RequestDispatcher rd = request.getRequestDispatcher("deviceadmin");
                rd.forward(request, response);
            } else {
                request.setAttribute("message","添加失败");
                RequestDispatcher rd = request.getRequestDispatcher("deviceadmin");
                rd.forward(request, response);
            }
        }else{
            request.setAttribute("message","添加失败，未将内容填写完整");
            RequestDispatcher rd = request.getRequestDispatcher("deviceadmin");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
