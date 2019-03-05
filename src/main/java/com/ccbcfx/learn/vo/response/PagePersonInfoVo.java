package com.ccbcfx.learn.vo.response;


import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/5 15:38
 */
@Data
public class PagePersonInfoVo {
    Integer total;
    List<PersonInfoVo> personList;
}
