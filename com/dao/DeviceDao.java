package com.dao;

import com.entity.Device;

import java.util.List;

public interface DeviceDao {
    public List<Device> searchdevice();    //查找所有的会议设备
    public int devicecount();   //查找所有的会议设备的条数
    public boolean adddevice(String devicename);   //添加会议设备
    public boolean regaindevice(int deviceid);   //收回设备
    public boolean deletemeetroom(String roomname);   //删除会议室收回设备
    public boolean assigndevice(int deviceid,String devicemeetroom);   //分配设备
    public List<Device> searchdeviceroom(String roomname);
    public int searchdeviceroomcount(String roomname);
}
