package com.controller;

import com.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateuserServlet",urlPatterns = "/updateuser")
public class updateuserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String user = request.getParameter("user");
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");

        UserDaoImpl userDao = new UserDaoImpl();
        boolean updateUsernameSuccess = userDao.updateUsername(user, username);
        boolean updateUserpwdSuccess = userDao.updateUserpwd(user, userpwd);

        if (updateUsernameSuccess && updateUserpwdSuccess) {
            response.sendRedirect("userlogin.jsp?message=success");
        } else {
            response.sendRedirect("userlogin.jsp?message=error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
