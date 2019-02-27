package com.ccbcfx.learn.vo.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

@ApiModel
public class ConditionsVo {

    @ApiModelProperty(value = "条件",name = "conditions",example = "luzhiqing",notes = "长度20中英文")
    private Conditions conditions;

    @ApiModelProperty(value = "开始",name = "offset")
    private int offset;

    @ApiModelProperty(value = "size",name = "size")
    private int size;

    public class Conditions{
        @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]*",message = "姓名格式不对")
        @ApiModelProperty(value = "名字",name = "name",example = "luzhiqing",notes = "长度20中英文")
        private String name;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        @ApiModelProperty(value = "生日",name = "birthday",example = "yyyy-MM-dd")
        private Date birthday;

        @ApiModelProperty(value = "身份证类型",name = "documentType",example = "身份证")
        private String documentType;

        @ApiModelProperty(value = "证件号",name = "documentNumber",example = "522122199503207416")
        private String documentNumber;

        @ApiModelProperty(value = "电话",name = "phone",example = "18385067722")
        private String phone;

        @ApiModelProperty(value = "性别",name = "gender",example = "男")
        private String gender;

        @ApiModelProperty(value = "员工状态",name = "status",example = "在职，离职")
        private String status;

        @ApiModelProperty(value = "创建时间",name = "createBegin",example = "yyyy-MM-dd HH:mm:ss")
        private Date createBegin;

        @ApiModelProperty(value = "创建时间",name = "createEnd",example = "yyyy-MM-dd HH:mm:ss")
        private Date createEnd;

        @ApiModelProperty(value = "修改时间",name = "updateBegin",example = "yyyy-MM-dd HH:mm:ss")
        private Date updateBegin;

        @ApiModelProperty(value = "修改时间",name = "updateEnd",example = "yyyy-MM-dd HH:mm:ss")
        private Date updateEnd;

        @ApiModelProperty(value = "删除时间",name = "deleteBengin",example = "yyyy-MM-dd HH:mm:ss")
        private Date deleteBengin;

        @ApiModelProperty(value = "删除时间",name = "deleteEnd",example = "yyyy-MM-dd HH:mm:ss")
        private Date deleteEnd;

        @ApiModelProperty(value = "删除标记",name = "enabled",example = "true,false")
        private boolean enabled;
    }


}
