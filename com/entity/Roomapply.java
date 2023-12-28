package com.entity;

import java.sql.Timestamp;

public class Roomapply {
    private int applyid;
    private String roomname;
    private String meetname;
    private String launchname;
    private java.sql.Timestamp starttime;
    private java.sql.Timestamp endtime;
    private String roomtype;

    public int getApplyid() {
        return applyid;
    }

    public void setApplyid(int applyid) {
        this.applyid = applyid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getMeetname() {
        return meetname;
    }

    public void setMeetname(String meetname) {
        this.meetname = meetname;
    }

    public String getLaunchname() {
        return launchname;
    }

    public void setLaunchname(String launchname) {
        this.launchname = launchname;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }
}
