package com.controller;

import com.dao.liuyanDaoImpl;
import com.entity.liuyan;
import com.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(name = "addServlet",urlPatterns = "/add")
public class addServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            Connection connection = JDBCUtils.getConnection();
            String name = request.getParameter("name");
            String content = request.getParameter("content");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            liuyan liuyan = new liuyan();
            liuyan.setName(name);
            liuyan.setNr(content);
            liuyan.setTime(timestamp);
            liuyanDaoImpl liuyanDao = new liuyanDaoImpl();
            boolean isSuccess = liuyanDao.add(liuyan);
            connection.close();


            if (isSuccess) {
                response.sendRedirect("adminindex.jsp?message=success");
            } else {
                response.sendRedirect("adminindex.jsp?message=error");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}