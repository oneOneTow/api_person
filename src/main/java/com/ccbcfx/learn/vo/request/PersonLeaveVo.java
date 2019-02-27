package com.ccbcfx.learn.vo.request;

import java.util.Date;

public class PersonLeaveVo {
    private int id;
    private String name;
    private Date leaveTime;
    private String leaveReson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeaveReson() {
        return leaveReson;
    }

    public void setLeaveReson(String leaveReson) {
        this.leaveReson = leaveReson;
    }
}
