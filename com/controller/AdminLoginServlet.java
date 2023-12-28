package com.controller;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet" , urlPatterns = "/adminlogin")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String adminname = request.getParameter("adminname");
        String adminpwd = request.getParameter("adminpwd");
        HttpSession session = request.getSession();
        session.setAttribute("adminname", adminname);
        AdminDao dao = new AdminDaoImpl();
        if(dao.adminlogin(adminname,adminpwd)){
            //根据返回结果选择合适的视图
            response.sendRedirect("adminindex.jsp");
        }else{
            response.sendRedirect("adminlogin.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
