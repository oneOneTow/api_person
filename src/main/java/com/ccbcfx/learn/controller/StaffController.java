package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.vo.StaffVo;
import org.springframework.web.bind.annotation.*;

@RestController
public class StaffController {
    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @RequestMapping(path = "/staff/{id}",
            method = RequestMethod.GET)
    public StaffVo getStaffById(@PathVariable String id){
        StaffVo staffVo=new StaffVo("luzhiqing","14101310");
        return staffVo;
    }
}
