package com.ccbcfx.learn.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class StaffVo {
    @NotBlank(message = "姓名不能为空")
    @Length(min=1,max = 20,message = "姓名不能超过20")
    @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]*",message = "姓名格式不对")
    private String name;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    @NotBlank(message = "身份证类型不能为空")
    private String documentType;
    @NotBlank(message = "证件好不能为空")
    private String documentNumber;
    @NotBlank(message = "电话不能为空")
    private String phone;

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
}
