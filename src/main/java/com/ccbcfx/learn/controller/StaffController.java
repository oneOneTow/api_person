package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.service.StaffService;
import com.ccbcfx.learn.vo.StaffVo;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "员工controller",tags = {"员工操作接口"})
@RestController
public class StaffController {

    @Autowired
    StaffService staffService;
    /**
     * 根据id查询员工 test
     * @param
     * @return
     */
    @RequestMapping(path = "/staff/list",
            method = RequestMethod.GET)
    @ApiOperation(value = "查询所有员工" )
    public List<StaffVo> getStaffs(){
        return staffService.getStaffs();
    }

    @DeleteMapping(path = "/staff/{id}")
    @ApiOperation(value = "删除员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public boolean delete(@PathVariable int id){
        return staffService.delete(id);
    }

    /**
     * 添加一名员工
     * @param staff
     * @return
     */
    @PostMapping(path = "/staff")
    @ApiOperation(value = "添加员工" )
    public int addStaff(@RequestBody StaffVo staff){
        return staffService.addStaff(staff,"luzhiqing");
    }
}
