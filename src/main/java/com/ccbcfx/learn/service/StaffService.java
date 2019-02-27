package com.ccbcfx.learn.service;

import com.ccbcfx.learn.vo.request.StaffVo;

import java.util.List;

public interface StaffService {
    /**
     *
     * @param staffVo
     * @param createBy
     * @return
     */
     int addStaff(StaffVo staffVo,String createBy);

     List<StaffVo> getStaffs();
     boolean delete(int id);
}
