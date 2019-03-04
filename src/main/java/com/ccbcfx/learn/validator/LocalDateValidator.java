package com.ccbcfx.learn.validator;

import com.ccbcfx.learn.annotation.PastLocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

/**
 * @Description:
 * @Author: 陆志庆
 * @CreateDate: 2019/3/3 21:00
 */
public class LocalDateValidator implements ConstraintValidator<PastLocalDate, LocalDate> {
    @Override
    public void initialize(PastLocalDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
         return null != value && value.isBefore(LocalDate.now());
    }
}
