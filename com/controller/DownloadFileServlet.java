package com.controller;

import com.dao.FileDao;
import com.dao.FileDaoImpl;
import com.dao.MeetingDao;
import com.dao.MeetingDaoImpl;
import com.entity.Filee;
import com.entity.Meeting;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DownloadFileServlet" , urlPatterns = "/downloadfile")
public class DownloadFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String meetname = request.getParameter("meetname");
        FileDao dao = new FileDaoImpl();
        try{
            List<Filee> filelist = dao.searchfile(meetname);
            request.setAttribute("filelist",filelist);
            Integer pagecount = new Integer(dao.searchfilecount(meetname));
            request.setAttribute("pagecount",pagecount);
            RequestDispatcher rd = request.getRequestDispatcher("searchfile.jsp");
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
