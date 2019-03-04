package com.ccbcfx.learn.annotation;

import com.ccbcfx.learn.validator.LocalDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/4 15:21
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {LocalDateValidator.class})
public @interface PastLocalDate {
    String message() default "时间超过当前时间";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
