package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.bean.ResultBean;
import com.ccbcfx.learn.service.PersonService;
import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.PersonVo;
import com.ccbcfx.learn.vo.response.PagePersonInfoVo;
import com.ccbcfx.learn.vo.response.PersonInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(value = "员工controller")
@RestController
public class PersonController {

    @Autowired
    PersonService personService;


    /**
     * 根据查询条件查询数据
     *
     * @param conditions 查询条件
     * @return
     */
    @PostMapping(path = "/person/search")
    @ApiOperation(value = "按条件查询数据")
    public ResultBean<PagePersonInfoVo> getPersonsByConditions(@Valid @RequestBody ConditionsVo conditions) {
        return new ResultBean<>(personService.getPersons(conditions));
    }

    /**
     * 员工离职
     *
     * @param personLeaveVo 员工离职信息
     * @return
     */
    @RequestMapping(path = "/person/leave", method = RequestMethod.POST)
    @ApiOperation(value = "员工离职")
    public ResultBean<Boolean> leave(@RequestBody PersonLeaveVo personLeaveVo) {
        return new ResultBean<>(personService.leave(personLeaveVo));
    }

    /**
     * 删除员工
     *
     * @param id 员工唯一标识符
     * @return 是否删除
     */
    @DeleteMapping(path = "/person/{id}")
    @ApiOperation(value = "删除员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public ResultBean<Boolean> delete(@PathVariable int id) {
        return new ResultBean<>(personService.delete(id));
    }

    /**
     * 修改员工
     *
     * @param id
     * @param person
     * @return
     */
    @PutMapping(path = "/person/{id}")
    @ApiOperation(value = "修改员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public ResultBean<Boolean> updatePerson(@PathVariable int id,
                                            @Valid @RequestBody PersonVo person) {
        return new ResultBean<>(personService.updatePerson(id, person));
    }

    /**
     * 根据id查询单个员工
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/person/{id}")
    @ApiOperation(value = "查询单个员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public ResultBean<PersonInfoVo> getPerson(@PathVariable int id) {
        return new ResultBean<>(personService.getPerson(id));
    }

    /**
     * 查询所有员工
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/person/list")
    @ApiOperation(value = "查询所有员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public ResultBean<PagePersonInfoVo> getPersonList(int offset, int size) {
        return new ResultBean<>(personService.getPersonList(offset, size));
    }

    /**
     * 添加一名员工
     *
     * @param person
     * @return
     */
    @PostMapping(path = "/person")
    @ApiOperation(value = "添加员工")
    public ResultBean<Integer> addPerson(@Valid @RequestBody PersonVo person) {
        return new ResultBean<>(personService.addPerson(person));
    }

    /**
     * 上传员工头像
     *
     * @param id
     * @param profile
     * @return
     */
    @ApiOperation("上传头像")
    @PutMapping(path = "/Portrait/{id}")
    public ResultBean<String> uploadPortrait(@PathVariable int id,
                                             @RequestParam(required = true)
                                                     MultipartFile profile) {
        return new ResultBean<>(personService.uploadPortrait(profile, id));
    }

    /**
     * 模拟login
     *
     * @param name
     * @param password
     * @return
     */
    @ApiOperation("Login")
    @PutMapping(path = "/login")
    public ResultBean<PersonInfoVo> login(@RequestParam String name,
                                          @RequestParam String password,
                                          HttpServletRequest request, HttpServletResponse response) {
        System.out.println("login_________________________");
        System.out.println(request.getSession().getId());
        request.getSession().setAttribute("user",14101310);
        PersonInfoVo personInfoVo=new PersonInfoVo();
        personInfoVo.setName("luzhiqing");
        return new ResultBean<>(personInfoVo);
    }
}


