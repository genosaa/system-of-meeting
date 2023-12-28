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

@WebServlet(name = "RegainDeviceServlet" , urlPatterns = "/regaindevice")
public class RegainDeviceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int deviceid = Integer.parseInt(request.getParameter("deviceid"));
        DeviceDao devicedao = new DeviceDaoImpl();
        if (devicedao.regaindevice(deviceid)) {
            request.setAttribute("message","收回成功");
            RequestDispatcher rd = request.getRequestDispatcher("deviceadmin");
            rd.forward(request, response);
        } else {
            request.setAttribute("message","收回失败");
            RequestDispatcher rd = request.getRequestDispatcher("deviceadmin");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
