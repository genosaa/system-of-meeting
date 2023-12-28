package com.controller;

import com.dao.liuyanDao;
import com.dao.liuyanDaoImpl;
import com.entity.liuyan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "showallServlet", urlPatterns = "/showall")
public class showallServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String state = request.getParameter("state");
        liuyanDao liuyanDao = new liuyanDaoImpl();
        boolean success = liuyanDao.updateState(id,state) ;
        if (success) {
            response.sendRedirect("showall");
        } else {
            // handle error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        liuyanDaoImpl liuyanDao = new liuyanDaoImpl();
        List<liuyan> liuyanList = liuyanDao.selectall(null, null, null, null,null);
        request.setAttribute("liuyanList", liuyanList);
        request.getRequestDispatcher("showall.jsp").forward(request, response);
    }
}
