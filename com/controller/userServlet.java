package com.controller;

import com.dao.UserDaoImpl;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/User")
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDaoImpl userDao = new UserDaoImpl();
        boolean success = userDao.delete(id);  // Updated method call
        if (success) {
            response.sendRedirect(request.getContextPath() + "/User");
        } else {
            // handle error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        if (keyword != null && !keyword.isEmpty()) {
            // If a keyword is provided, forward the request to the searchServlet
            request.getRequestDispatcher("/search").forward(request, response);
        } else {
            // If no keyword is provided, retrieve all users and display the user.jsp page
            UserDaoImpl userDao = new UserDaoImpl();
            List<User> userList = userDao.selectAllUsers(null, null, null, null, null, null, null);
            request.setAttribute("UserList", userList);
            request.getRequestDispatcher("user.jsp").forward(request, response);
        }
    }
}
