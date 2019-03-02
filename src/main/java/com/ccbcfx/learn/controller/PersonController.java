package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.service.StaffService;
import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.StaffVo;
import com.ccbcfx.learn.vo.response.StaffInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Api(value = "员工controller", tags = {"员工操作接口"})
@RestController
public class PersonController {

    @Autowired
    StaffService staffService;


    /**
     * 根据查询条件查询数据
     *
     * @param conditions 查询条件
     * @return
     */
    @PostMapping(path = "/staff/search")
    @ApiOperation(value = "按条件查询数据")
    public List<StaffInfoVo> getStaffsByConditions(@Valid @RequestBody ConditionsVo conditions) {
        return staffService.getStaffs(conditions);
    }

    /**
     * 员工离职
     *
     * @param personLeaveVo 员工离职信息
     * @return
     */
    @RequestMapping(path = "/staff/leave", method = RequestMethod.POST)
    @ApiOperation(value = "员工离职")
    public boolean leave(@RequestBody PersonLeaveVo personLeaveVo) {
        return true;
    }

    /**
     * 删除员工
     *
     * @param id 员工唯一标识符
     * @return 是否删除
     */
    @DeleteMapping(path = "/staff/{id}")
    @ApiOperation(value = "删除员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public boolean delete(@PathVariable int id,HttpSession session) {
        int userId=getUserId(session);
        return staffService.delete(id,userId);
    }

    /**
     * 修改员工
     *
     * @param id
     * @param staffVo
     * @return
     */
    @PutMapping(path = "/staff/{id}")
    @ApiOperation(value = "修改员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public StaffInfoVo updatePerson(@PathVariable int id,
                                    @Valid @RequestBody StaffVo staffVo,
                                    HttpSession session) {
        int userId = getUserId(session);
        return staffService.updateStaff(id, staffVo, userId);
    }

    /**
     * 根据id查询单个员工
     *
     * @param id
     * @return
     */
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
    public int addStaff(@Valid @RequestBody StaffVo staff,
                        HttpSession session) {
        int userId = getUserId(session);
        return staffService.addStaff(staff, userId);
    }

    /**
     * 获取userID
     *
     * @param session
     * @return
     */
    private int getUserId(HttpSession session) {
        return 0;
    }
}


