package com.ccbcfx.learn.vo.response;

import com.ccbcfx.learn.enums.DocumentType;
import com.ccbcfx.learn.enums.GenderType;
import com.ccbcfx.learn.enums.StaffStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
public class StaffInfoVo {

    @ApiModelProperty(value = "id", name = "id", example = "1")
    private int id;

    @ApiModelProperty(value = "名字", name = "name", example = "luzhiqing")
    private String name;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "生日", name = "birthday", example = "2018-01-10")
    private Date birthday;


    @ApiModelProperty(value = "身份证类型", name = "documentType", example = "identityId")
    private DocumentType documentType;


    @ApiModelProperty(value = "证件号", name = "documentNumber", example = "522122199503207416")
    private String documentNumber;


    @ApiModelProperty(value = "电话", name = "phone", example = "18385067722")
    private String phone;

    @ApiModelProperty(value = "员工状态", name = "status", example = "leave")
    private StaffStatusType status;


    @ApiModelProperty(value = "性别", name = "gender", example = "man")
    private GenderType gender;
}
