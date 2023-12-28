package com.entity;

import java.sql.Timestamp;

public class Meetinginform {
    private int informid;
    private String meetname;
    private String meetroom;
    private java.sql.Timestamp starttime;
    private java.sql.Timestamp endtime;
    private String launchname;
    private String username;
    private String joincondition;

    public int getInformid() {
        return informid;
    }

    public void setInformid(int informid) {
        this.informid = informid;
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

    public String getLaunchname() {
        return launchname;
    }

    public void setLaunchname(String launchname) {
        this.launchname = launchname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJoincondition() {
        return joincondition;
    }

    public void setJoincondition(String joincondition) {
        this.joincondition = joincondition;
    }
}
