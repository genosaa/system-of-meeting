package com.entity;

import java.sql.Timestamp;

public class Meeting {
    private int meetid;
    private String meetname;
    private String meetroom;
    private java.sql.Timestamp starttime;
    private java.sql.Timestamp endtime;
    private String state;
    private String launchuser;
    private int predictnumber;
    private int number;

    public int getMeetid() {
        return meetid;
    }

    public void setMeetid(int meetid) {
        this.meetid = meetid;
    }

    public String getMeetname() {
        return meetname;
    }

    public void setMeetname(String meetname) {
        this.meetname = meetname;
    }

    public String getMeetroom() {
        return meetroom;
    }

    public void setMeetroom(String meetroom) {
        this.meetroom = meetroom;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLaunchuser() {
        return launchuser;
    }

    public void setLaunchuser(String launchuser) {
        this.launchuser = launchuser;
    }

    public int getPredictnumber() {
        return predictnumber;
    }

    public void setPredictnumber(int predictnumber) {
        this.predictnumber = predictnumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
