package com.dao;

import com.entity.Device;
import com.entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeviceDaoImpl implements DeviceDao{
    @Override
    public List<Device> searchdevice() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Device> devicelist = new ArrayList<Device>();
        try{
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "select * from device";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Device device = new Device();
                device.setDeviceid(rs.getInt(1));
                device.setDevicename(rs.getString(2));
                device.setDevicemeetroom(rs.getString(3));
                devicelist.add(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            com.utils.JDBCUtils.release(rs,ps,conn);
        }
        return devicelist;
    }

    @Override
    public int devicecount() {
        int b = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "select count(*) from device";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            rs.next();
            b = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            com.utils.JDBCUtils.release(rs,ps,conn);
        }
        return b;
    }

    @Override
    public boolean adddevice(String devicename) {
        Boolean b = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "insert into device(devicename,devicemeetroom) values(?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,devicename);
            ps.setString(2,"无");
            int i=ps.executeUpdate();
            if(i>0){
                b=true;
            }else{
                b=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            com.utils.JDBCUtils.release(rs,ps,conn);
        }
        return b;
    }

    @Override
    public boolean regaindevice(int deviceid) {
        boolean b = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "UPDATE device SET devicemeetroom=? WHERE deviceid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "无");
            ps.setInt(2,deviceid);
            int i = ps.executeUpdate();
            if (i > 0) {
                b = true;
            } else {
                b = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            com.utils.JDBCUtils.release(ps, conn);
        }
        return b;
    }

    @Override
    public boolean deletemeetroom(String roomname) {
        boolean b = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "UPDATE device SET devicemeetroom=? WHERE devicemeetroom=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "无");
            ps.setString(2,roomname);
            int i = ps.executeUpdate();
            if (i > 0) {
                b = true;
            } else {
                b = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            com.utils.JDBCUtils.release(ps, conn);
        }
        return b;
    }

    @Override
    public boolean assigndevice(int deviceid, String devicemeetroom) {
        boolean b = false;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "UPDATE device SET devicemeetroom=? WHERE deviceid=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, devicemeetroom);
            ps.setInt(2,deviceid);
            int i = ps.executeUpdate();
            if (i > 0) {
                b = true;
            } else {
                b = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            com.utils.JDBCUtils.release(ps, conn);
        }
        return b;
    }

    @Override
    public List<Device> searchdeviceroom(String roomname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Device> devicelist = new ArrayList<Device>();
        try{
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "select * from device where devicemeetroom=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,roomname);
            rs=ps.executeQuery();
            while(rs.next()){
                Device device = new Device();
                device.setDeviceid(rs.getInt(1));
                device.setDevicename(rs.getString(2));
                device.setDevicemeetroom(rs.getString(3));
                devicelist.add(device);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            com.utils.JDBCUtils.release(rs,ps,conn);
        }
        return devicelist;
    }

    @Override
    public int searchdeviceroomcount(String roomname) {
        int b = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = com.utils.JDBCUtils.getConnection();
            String sql = "select count(*) from device where devicemeetroom=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,roomname);
            rs=ps.executeQuery();
            rs.next();
            b = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            com.utils.JDBCUtils.release(rs,ps,conn);
        }
        return b;
    }
}
