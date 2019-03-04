package com.ccbcfx.learn.consumer;

import com.ccbcfx.learn.vo.request.ConditionsVo;
import com.ccbcfx.learn.vo.request.PersonLeaveVo;
import com.ccbcfx.learn.vo.request.PersonVo;
import com.ccbcfx.learn.vo.response.PersonInfoVo;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PersonService {
    /**
     * 添加员工
     * @param staffVo
     * @param createBy
     * @return
     */
    int addPerson(PersonVo staffVo, int createBy);


    /**
     * 删除员工
     *
     * @param id       被删除员工id
     * @param updateBy 删除人
     * @return
     */
    boolean delete(int id, int updateBy);


    /**
     * 修改员工
     *
     * @param id
     * @param staffVo
     * @param updateBy 修改人
     * @return
     */
    PersonInfoVo updatePerson(int id, PersonVo staffVo, int updateBy);

    /**
     * 根据id查询员工
     *
     * @param id 员工id
     * @return
     */
    PersonInfoVo getPerson(int id);

    /**
     * 查询满足查询条件的员工
     *
     * @param conditionsVo 查询体条件
     * @return
     */
    List<PersonInfoVo> getPersons(ConditionsVo conditionsVo);


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
