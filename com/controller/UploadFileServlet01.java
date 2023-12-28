package com.controller;

import com.dao.FileDao;
import com.dao.FileDaoImpl;
import com.entity.Filee;
import com.oreilly.servlet.MultipartRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet(name = "UploadFileServlet01" , urlPatterns = "/uploadfile01")
public class UploadFileServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String saveDirectory = this.getServletContext().getRealPath("") + "\\upload";  // 获取服务器上的存储目录的路径，将文件上传到该目录中
        File savedir = new File(saveDirectory);
        if (!savedir.exists()) {
            savedir.mkdirs();
        }
// 如果存储目录不存在，则创建存储目录
        int maxPostSize = 3 * 5 * 1024 * 1024;  // 定义请求上传的数据的最大容量为15MB
        MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "utf-8");  // 处理多部分请求，即处理文件上传请求，将上传的文件保存到指定路径中
        HttpSession session = request.getSession();
        String meetname = (String) session.getAttribute("meetname");   //获取会议名称
        String launchuser = (String) session.getAttribute("username");   //获取文件上传者
        String filename = "";
        Enumeration files = multi.getFileNames();
        if (files.hasMoreElements()) {
            String fieldName = (String) files.nextElement();
            filename = multi.getFilesystemName(fieldName);
            // 处理上传文件的名称
        }   //获取上传文件的名称
        Filee filee = new Filee();
        filee.setFilename(filename);
        filee.setFilepath(saveDirectory);
        filee.setMeetname(meetname);
        filee.setLaunchuser(launchuser);
        FileDao dao = new FileDaoImpl();
        request.setAttribute("message","会议文件上传失败");
        try {
            if(dao.upload(filee)){
                request.setAttribute("message","会议文件上传成功");
            }else{
                request.setAttribute("message","会议文件上传失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/uploadfile.jsp").forward(request, response);  // 将请求转发到 upload.jsp 页面，以将上传成功的消息显示在页面上
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
