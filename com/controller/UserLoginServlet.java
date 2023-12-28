package com.controller;

import com.dao.UserDao;
import com.dao.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet" , urlPatterns = "/userlogin")
public class UserLoginServlet extends HttpServlet {

    public UserLoginServlet() {
        super();
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        String usercheckcode = request.getParameter("checkcode");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        String info = "";
        String servercheckcode = (String) session.getAttribute("checkCode");
        UserDao dao = new UserDaoImpl();
        if (!servercheckcode.equalsIgnoreCase(usercheckcode)) {
            info = "验证码不正确，请重新输入";
            request.setAttribute("info", info);
            RequestDispatcher rd = request.getRequestDispatcher("/userlogin.jsp");
            rd.forward(request, response);
        } else if (dao.userlogin(username,userpwd)) {
            response.sendRedirect("userindex.jsp");
        } else {
            info = "用户名或密码不正确";
            request.setAttribute("info", info);
            RequestDispatcher rd = request.getRequestDispatcher("/userlogin.jsp");
            rd.forward(request, response);
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    public void init() throws ServletException {
        // Put your code here
    }

}

