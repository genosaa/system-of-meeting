package com.controller;

import com.dao.liuyanDaoImpl;
import com.entity.liuyan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showServlet", urlPatterns = "/show")
public class showServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String state = request.getParameter("state");
        liuyanDaoImpl liuyanDao = new liuyanDaoImpl();
        boolean success = liuyanDao.updateState( id,state);
        if (success) {
            response.sendRedirect("show");
        } else {
            // handle error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        liuyanDaoImpl liuyanDao = new liuyanDaoImpl();
        List<liuyan> liuyanList = liuyanDao.selectall(null, null, null, null,null);
        request.setAttribute("liuyanList", liuyanList);
        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}
