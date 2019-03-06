package com.ccbcfx.learn.service;

import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.PersonVo;
import com.ccbcfx.learn.vo.response.PagePersonInfoVo;
import com.ccbcfx.learn.vo.response.PersonInfoVo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;


public interface PersonService {
    /**
     * 添加员工
     *
     * @param staffVo
     * @return
     */
    int addPerson(PersonVo staffVo);


    /**
     * 删除员工
     *
     * @param id       被删除员工id
     * @return
     */
    boolean delete(int id);


    /**
     * 修改员工
     *
     * @param id
     * @param staffVo
     * @return
     */
    boolean updatePerson(int id, PersonVo staffVo);

    /**
     * 根据id查询员工
     *
     * @param id 员工id
     * @return
     */
    PersonInfoVo getPerson(int id);

    /**
     * 批量查询员工
     *
     * @param offset
     * @param size
     * @return
     */
    PagePersonInfoVo getPersonList(int offset, int size);

    /**
     * 查询满足查询条件的员工
     *
     * @param conditionsVo 查询体条件
     * @return
     */
    PagePersonInfoVo getPersons(ConditionsVo conditionsVo);


    boolean leave(PersonLeaveVo personLeaveVo);

    /**
     * 上传头像
     *
     * @param profile
     * @param id      上传头像员工的id
     * @return
     */
    String uploadPortrait(MultipartFile profile, int id);

    /**
     * 获取头像资源
     *
     * @param source
     * @return
     */
    Resource getPortrait(String source);


}
