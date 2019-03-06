package com.ccbcfx.learn.vo.response;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/5 15:38
 */
@Data
public class PagePersonInfoVo {
    @ApiModelProperty(value = "total",  example = "15")
    Integer total;
    @ApiModelProperty(value = "personList")
    List<PersonInfoVo> personList;
}
