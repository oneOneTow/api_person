package com.ccbcfx.learn.vo.request;

import lombok.Data;

import java.util.Date;
@Data
public class PersonLeaveVo {
    private int id;
    private String name;
    private Date leaveTime;
    private String leaveReason;
}
