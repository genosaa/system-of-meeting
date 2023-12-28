package com.controller;

import com.dao.DeviceDao;
import com.dao.DeviceDaoImpl;
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

@WebServlet(name = "SearchDeviceServlet" , urlPatterns = "/searchdevice")
public class SearchDeviceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String roomname = request.getParameter("roomname");
        DeviceDao devicedao = new DeviceDaoImpl();
        try{
            List<Device> devicelist = devicedao.searchdeviceroom(roomname);
            request.setAttribute("devicelist",devicelist);
            Integer pagecount = new Integer(devicedao.searchdeviceroomcount(roomname));
            request.setAttribute("pagecount",pagecount);
            request.setAttribute("roomname",roomname);
            RequestDispatcher rd = request.getRequestDispatcher("searchdeviceroom.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
