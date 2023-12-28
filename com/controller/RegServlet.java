package com.controller;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegServlet", urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("uname");
        String pwd = request.getParameter("upwd");
        User user = new User();
        user.setUsername(name);
        user.setUserpwd(pwd);

        UserDao dao = new UserDaoImpl();
        if (dao.reg(user)) {
            // 将消息信息作为参数传递给登录页面
            response.sendRedirect("userlogin.jsp?message=success");
        } else {
            // 将消息信息作为参数传递给注册页面
            response.sendRedirect("reg.jsp?message=failure");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
