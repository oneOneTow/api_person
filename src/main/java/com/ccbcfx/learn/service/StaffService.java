package com.ccbcfx.learn.service;

import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.StaffVo;
import com.ccbcfx.learn.vo.response.StaffInfoVo;

import java.util.List;

public interface StaffService {
    /**
     *
     * @param staffVo
     * @param createBy
     * @return
     */
     int addStaff(StaffVo staffVo,int createBy);

     List<StaffVo> getStaffs();
     boolean delete(int id,int updateBy);
    List<StaffInfoVo> getStaffs(ConditionsVo conditionsVo);
    StaffInfoVo updateStaff(int id,StaffVo staffVo,int updateBy);


}
