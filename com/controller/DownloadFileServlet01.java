package com.controller;

import com.dao.FileDao;
import com.dao.FileDaoImpl;
import com.oreilly.servlet.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "DownloadFileServlet01" , urlPatterns = "/downloadfile01")
public class DownloadFileServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int fileid = Integer.parseInt(request.getParameter("fileid"));
        FileDao dao = new FileDaoImpl();
        String filename = dao.searchfilename(fileid);
        String filepath = dao.searchfilepath(fileid)+"\\";
        String guessCharset = "utf-8";
        try{
            String isofilename = new String(filename.getBytes(guessCharset),"iso-8859-1");
            response.setContentType("application/octet-stream");
            response.setHeader("content-Disposition","attachment;filename="+isofilename);
            ServletOutputStream out = null;
            out = response.getOutputStream();
            ServletUtils.returnFile(filepath+filename,out);
        }catch(UnsupportedEncodingException ex){
            ex.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
