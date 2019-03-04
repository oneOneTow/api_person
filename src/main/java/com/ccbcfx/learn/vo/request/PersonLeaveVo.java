package com.ccbcfx.learn.vo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;


public class PersonLeaveVo {
    @NotNull(message = "id不能为空")
    @Pattern(regexp = "[0-9]*", message = "id格式不对")
    @ApiModelProperty(value = "员工唯一标识符", name = "id", example = "22")
    private Integer id;

    @NotBlank(message = "姓名不能为空")
    @Length(min = 1, max = 20, message = "姓名不能超过20")
    @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]*", message = "姓名格式不对")
    @ApiModelProperty(value = "名字", name = "name", example = "luzhiqing", notes = "长度20中英文")
    private String name;

    @NotNull(message = "离职时间不能为空")
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "离职时间", name = "leaveTime", example = "2018-12-12 12:12:12")
    private Date leaveTime;

    @NotBlank(message = "离职原因不能为空")
    @Length(min = 20, max = 50, message = "姓名不能超过50个字")
    @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]*", message = "姓名格式不对")
    @ApiModelProperty(value = "离职原因", name = "leaveReason", example = "个人原因")
    private String leaveReason;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }
}
