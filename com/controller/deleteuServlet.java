package com.controller;

import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteuServlet",urlPatterns = "/deleteu")
public class deleteuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the ID of the row to be deleted from the request parameters
        int id = Integer.parseInt(request.getParameter("id"));

        // Create an instance of liuyanDaoImpl and call the delete method
        UserDaoImpl UserDao = new UserDaoImpl();
        boolean isSuccess = UserDao.delete(id);

        if (isSuccess) {
            response.sendRedirect("User?message=success");
        } else {
            response.sendRedirect("User?message=error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
