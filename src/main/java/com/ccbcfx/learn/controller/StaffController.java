package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.service.StaffService;
import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.StaffVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "员工controller", tags = {"员工操作接口"})
@RestController
public class StaffController {

    @Autowired
    StaffService staffService;

    /**
     * 根据id查询员工 test
     *
     * @param
     * @return
     */
    @RequestMapping(
            path = "/staff/list",
            method = RequestMethod.GET)
    @ApiOperation(value = "批量查询所有员工")
    public List<StaffVo> getStaffs(int offset, int size) {
        return staffService.getStaffs();
    }

    @GetMapping(path = "/staff/list")
    @ApiOperation(value = "批量查询所有员工")
    public List<StaffVo> getStaffsByConditions(@Valid @RequestBody ConditionsVo conditions, int offset, int size) {
        return null;
    }

    @RequestMapping(path = "/staff/leave", method = RequestMethod.POST)
    @ApiOperation(value = "员工离职")
    public boolean leave(@RequestBody PersonLeaveVo personLeaveVo) {
        return true;
    }

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = "/staff/{id}")
    @ApiOperation(value = "删除员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public boolean delete(@PathVariable int id) {
        return staffService.delete(id);
    }

    @PutMapping(path = "/staff/{id}")
    @ApiOperation(value = "修改员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public boolean updatePerson(@PathVariable int id,
                                @Valid @RequestBody StaffVo staffVo) {
        return true;
    }

    @GetMapping(path = "/staff/{id}")
    @ApiOperation(value = "查询单个员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public StaffVo getStaff(@PathVariable int id) {
        return null;
    }

    /**
     * 添加一名员工
     *
     * @param staff
     * @return
     */
    @PostMapping(path = "/staff")
    @ApiOperation(value = "添加员工")
    @ApiImplicitParam(name = "staff", value = "员工实体staff", required = true, dataType = "StaffVo")
    public int addStaff(@Valid @RequestBody StaffVo staff) {
        return staffService.addStaff(staff, "luzhiqing");
    }
}
