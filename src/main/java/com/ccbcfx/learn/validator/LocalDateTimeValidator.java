package com.ccbcfx.learn.validator;

import com.ccbcfx.learn.annotation.PastLocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/4 15:31
 */
public class LocalDateTimeValidator implements ConstraintValidator<PastLocalDateTime, LocalDateTime> {
    @Override
    public void initialize(PastLocalDateTime constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDateTime value, ConstraintValidatorContext context) {
        return null != value && value.isBefore(LocalDateTime.now());
    }
}
