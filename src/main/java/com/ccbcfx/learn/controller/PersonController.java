package com.ccbcfx.learn.controller;

import com.ccbcfx.learn.consumer.PersonService;
import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.PersonVo;
import com.ccbcfx.learn.vo.response.PersonInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Api(value = "员工controller", tags = {"员工操作接口"})
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
    public List<PersonInfoVo> getPersonsByConditions(@Valid @RequestBody ConditionsVo conditions) {
        return personService.getPersons(conditions);
    }

    /**
     * 员工离职
     *
     * @param personLeaveVo 员工离职信息
     * @return
     */
    @RequestMapping(path = "/person/leave", method = RequestMethod.POST)
    @ApiOperation(value = "员工离职")
    public boolean leave(@RequestBody PersonLeaveVo personLeaveVo) {
        return personService.leave(personLeaveVo);
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
    public boolean delete(@PathVariable int id,HttpSession session) {
        int userId=getUserId(session);
        return personService.delete(id,userId);
    }

    /**
     * 修改员工
     *
     * @param id
     * @param staffVo
     * @return
     */
    @PutMapping(path = "/person/{id}")
    @ApiOperation(value = "修改员工")
    @ApiParam(name = "id", value = "员工唯一标识符", required = true)
    public PersonInfoVo updatePerson(@PathVariable int id,
                                     @Valid @RequestBody PersonVo staffVo,
                                     HttpSession session) {
        int userId = getUserId(session);
        return personService.updatePerson(id, staffVo, userId);
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
    public PersonInfoVo getPerson(@PathVariable int id) {
        return personService.getPerson(id);
    }

    /**
     * 添加一名员工
     *
     * @param staff
     * @return
     */
    @PostMapping(path = "/person")
    @ApiOperation(value = "添加员工")
    public int addPerson(@Valid @RequestBody PersonVo staff,
                        HttpSession session) {
        int userId = getUserId(session);
        return personService.addPerson(staff, userId);
    }

    @ApiOperation("上传头像")
    @PutMapping(path = "/Portrait/{id}")
    public String uploadPortrait(@RequestParam(required = true) MultipartFile profile,
                             @PathVariable int id){
        return personService.uploadPortrait(profile,id);
    }

    @ApiOperation("获取头像")
    @GetMapping(path = "/Portrait")
    @ApiParam(name = "fileName", value = "员工头像唯一标识符", required = true)
    public ResponseEntity showPortrait(@RequestParam String fileName){
        return ResponseEntity.ok(personService.getPortrait(fileName));
    }


    public int getUserId(HttpSession session){
        return 0;
    }

}


