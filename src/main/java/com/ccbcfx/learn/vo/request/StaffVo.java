package com.ccbcfx.learn.vo.request;

import com.ccbcfx.learn.enums.DocumentType;
import com.ccbcfx.learn.enums.GenderType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@ApiModel(value = "staff对象", description = "员工对象")
public class StaffVo implements Serializable {
    @NotBlank(message = "姓名不能为空")
    @Length(min = 1, max = 20, message = "姓名不能超过20")
    @Pattern(regexp = "[a-zA-Z\\u4E00-\\u9FA5]*", message = "姓名格式不对")
    @ApiModelProperty(value = "名字", name = "name", example = "luzhiqing", notes = "长度20中英文")
    private String name;

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "生日", name = "birthday", example = "2018-01-10")
    private LocalDate birthday;

    @NotNull(message = "身份证类型不能为空")
    @ApiModelProperty(value = "身份证类型", name = "documentType", example = "identityId")
    private DocumentType documentType;

    @NotBlank(message = "证件好不能为空")
    @ApiModelProperty(value = "证件号", name = "documentNumber", example = "522122199503207416")
    private String documentNumber;

    @NotBlank(message = "电话不能为空")
    @ApiModelProperty(value = "电话", name = "phone", example = "18385067722")
    private String phone;

    @NotNull(message = "性别不能为空")
    @ApiModelProperty(value = "性别", name = "gender", example = "man")
    private GenderType gender;

}
