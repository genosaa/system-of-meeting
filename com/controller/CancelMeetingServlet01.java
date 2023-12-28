package com.controller;

import com.dao.*;
import com.entity.Meeting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CancelMeetingServlet01" , urlPatterns = "/cancelmeeting01")
public class CancelMeetingServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String meetname = request.getParameter("meetname");
        MeetingDao meetingdao = new MeetingDaoImpl();
        RoomDao roomdao = new RoomDaoImpl();
        FileDao filedao = new FileDaoImpl();
        meetingdao.cancelmeeting(meetname);
        meetingdao.cancelmeetinginform(meetname);
        roomdao.cancelmeeting(meetname);
        List<Integer> fileidlist = filedao.searchfileid(meetname);
        for (int i = 0; i < fileidlist.size(); i++) {
            Integer fileid = fileidlist.get(i);
            String filename = filedao.searchfilename(fileid);
            String filepath = filedao.searchfilepath(fileid)+"\\";
            String guessCharset = "utf-8";
            File file = new File(filepath,filename);
            if(file.exists()){
                file.delete();
            }
            try {
                filedao.delete(fileid);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("searchmeetinglaunch");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
