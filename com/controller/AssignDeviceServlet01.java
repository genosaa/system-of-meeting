package com.controller;

import com.dao.DeviceDao;
import com.dao.DeviceDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AssignDeviceServlet01" , urlPatterns = "/assigndevice01")
public class AssignDeviceServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int deviceid = Integer.parseInt(request.getParameter("deviceid"));
        String devicemeetroom = request.getParameter("roomname");
        DeviceDao devicedao = new DeviceDaoImpl();
        if (devicedao.assigndevice(deviceid,devicemeetroom)) {
            request.setAttribute("message","分配成功");
            RequestDispatcher rd = request.getRequestDispatcher("deviceadmin");
            rd.forward(request, response);
        } else {
            request.setAttribute("message","分配失败");
            RequestDispatcher rd = request.getRequestDispatcher("deviceadmin");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
