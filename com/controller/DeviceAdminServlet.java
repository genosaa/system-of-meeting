package com.controller;

import com.dao.DeviceDao;
import com.dao.DeviceDaoImpl;
import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.entity.Device;
import com.entity.Meeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeviceAdminServlet" , urlPatterns = "/deviceadmin")
public class DeviceAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        DeviceDao devicedao = new DeviceDaoImpl();
        try{
            List<Device> devicelist = devicedao.searchdevice();
            request.setAttribute("devicelist",devicelist);
            Integer pagecount = new Integer(devicedao.devicecount());
            request.setAttribute("pagecount",pagecount);
            RequestDispatcher rd = request.getRequestDispatcher("deviceadmin.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
