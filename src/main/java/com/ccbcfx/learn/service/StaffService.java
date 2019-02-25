package com.ccbcfx.learn.service;

import com.ccbcfx.learn.vo.StaffVo;

public interface StaffService {
    /**
     *
     * @param staffVo
     * @param createBy
     * @return
     */
     int addStaff(StaffVo staffVo,String createBy);
}
