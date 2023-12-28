package com.dao;

import com.entity.Filee;

import java.sql.SQLException;
import java.util.List;

public interface FileDao {
    public Boolean upload(Filee filee) throws SQLException, ClassNotFoundException;
    public List<Filee> searchfile(String meetname);
    public int searchfilecount(String meetname);
    public String searchfilename(int fileid);
    public String searchfilepath(int fileid);
    public List<Integer> searchfileid(String meetname);  //查找对应会议上传的文件的文件id
    public boolean delete(int fileid) throws SQLException, ClassNotFoundException ;   //删除数据表中对应文件
    public boolean updatemeetingfile(String meetname,String meetname01);  //修改会议内容，修改文件表中的会议名字
}
