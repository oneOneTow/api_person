package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.service.StaffService;
import com.ccbcfx.learn.vo.StaffVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class StaffController {

    @Autowired
    StaffService staffService;
    /**
     * 根据id查询员工 test
     * @param id
     * @return
     */
    @RequestMapping(path = "/staff/{id}",
            method = RequestMethod.GET)
    public StaffVo getStaffById(@PathVariable String id){
        StaffVo staffVo=new StaffVo();
        return staffVo;
    }

    /**
     * 添加一名员工
     * @param staff
     * @return
     */
    @PostMapping(path = "/staff")
    public int addStaff(@RequestBody StaffVo staff){
        return staffService.addStaff(staff,"luzhiqing");
    }
}
