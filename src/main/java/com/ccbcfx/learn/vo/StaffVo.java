package com.ccbcfx.learn.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "staff对象", description = "员工对象")
public class StaffVo implements Serializable {

    @ApiModelProperty(value = "名字", name = "name", example = "luzhiqing", notes = "长度20中英文")

    private String name;

    @ApiModelProperty(value = "生日", name = "birthday", example = "yyyy-MM-dd HH:mm:ss")

    private Date birthday;

    @ApiModelProperty(value = "身份证类型", name = "documentType", example = "身份证")

    private String documentType;

    @ApiModelProperty(value = "证件号", name = "documentNumber", example = "522122199503207416")

    private String documentNumber;

    @ApiModelProperty(value = "电话", name = "phone", example = "18385067722")

    private String phone;

    @ApiModelProperty(value = "性别", name = "gender", example = "男")

    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
