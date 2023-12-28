package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao{

    @Override
    public boolean adminlogin(String adminname, String adminpwd) {
        boolean b = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "select * from admin where adminname=? and adminpwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,adminname);
            ps.setString(2,adminpwd);
            rs = ps.executeQuery();
            if(rs.next()){
                b=true;
            }else{
                b=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally{
            com.utils.JDBCUtils.release(rs,ps,conn);
        }
        return b;
    }
}
