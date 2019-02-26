package com.ccbcfx.learn.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "staff对象",description = "员工对象")
public class StaffVo implements Serializable {
    @NotBlank(message = "姓名不能为空")
    @Length(min=1,max = 20,message = "姓名不能超过20")
    @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]*",message = "姓名格式不对")
    @ApiModelProperty(value = "名字",name = "name",example = "luzhiqing",notes = "长度20中英文")
    private String name;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生日",name = "birthday",example = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    @NotBlank(message = "身份证类型不能为空")
    @ApiModelProperty(value = "身份证类型",name = "documentType",example = "身份证")
    private String documentType;
    @NotBlank(message = "证件好不能为空")
    @ApiModelProperty(value = "证件号",name = "documentNumber",example = "522122199503207416")
    private String documentNumber;
    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(value = "电话",name = "phone",example = "18385067722")
    private String phone;
    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(value = "性别",name = "gender",example = "男")
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
