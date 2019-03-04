package com.ccbcfx.learn.vo.request;


import com.ccbcfx.learn.annotation.PastLocalDate;
import com.ccbcfx.learn.annotation.PastLocalDateTime;
import com.ccbcfx.learn.enums.DocumentType;
import com.ccbcfx.learn.enums.GenderType;
import com.ccbcfx.learn.enums.StaffStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@ApiModel(value = "查询条件")
public class ConditionsVo {

    private Conditions conditions;

    @ApiModelProperty(value = "开始",name = "offset",example = "0")
    private int offset;

    @ApiModelProperty(value = "size",name = "size",example = "10")
    private int size;

    @Data
    public class Conditions{

        @Length(min = 1, max = 20, message = "姓名不能超过20")
        @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]*",message = "姓名格式不对")
        @ApiModelProperty(value = "名字",name = "name",example = "luzhiqing")
        private String name;

        @PastLocalDate
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @JsonFormat(pattern = "yyyy-MM-dd")
        @ApiModelProperty(value = "生日",name = "birthday",example = "2018-11-10")
        private LocalDate birthday;

        @ApiModelProperty(value = "身份证类型",name = "documentType",example = "identityId")
        private DocumentType documentType;

        @ApiModelProperty(value = "证件号",name = "documentNumber",example = "522122199503207416")
        private String documentNumber;

        @ApiModelProperty(value = "电话",name = "phone",example = "18385067722")
        private String phone;

        @ApiModelProperty(value = "性别",name = "gender",example = "man")
        private GenderType gender;

        @ApiModelProperty(value = "员工状态",name = "status",example = "working")
        private StaffStatusType status;

        @PastLocalDateTime
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "创建时间",name = "createBegin",example = "2018-12-12 12:12:12")
        private LocalDateTime createBegin;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "创建时间",name = "createEnd",example = "2019-12-12 12:12:12")
        private LocalDateTime createEnd;

        @PastLocalDateTime
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "修改时间",name = "updateBegin",example = "2018-12-12 12:12:12")
        private LocalDateTime updateBegin;


        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "修改时间",name = "updateEnd",example = "2019-12-12 12:12:12")
        private LocalDateTime updateEnd;

        @PastLocalDateTime
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "删除时间",name = "deleteBengin",example = "2018-12-12 12:12:12")
        private LocalDateTime deleteBengin;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @ApiModelProperty(value = "删除时间",name = "deleteEnd",example = "2019-12-12 12:12:12")
        private LocalDateTime deleteEnd;

        @ApiModelProperty(value = "删除标记",name = "enabled",example = "true")
        private Boolean enabled;

    }
}
