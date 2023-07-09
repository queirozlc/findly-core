package com.br.findly.shared.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;

public class IsOlderThanValidator implements ConstraintValidator<IsOlderThan, Object> {

    private int value;

    /**
     * @param constraintAnnotation
     */
    @Override
    public void initialize(IsOlderThan constraintAnnotation) {
        this.value = constraintAnnotation.value();
    }

    /**
     * @param o
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        var localDate = LocalDate.parse(o.toString());
        var date = DateUtils.addYears(DateUtils.truncate(new java.util.Date(), java.util.Calendar.DAY_OF_MONTH), -this.value);
        return localDate.isBefore(LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate()));
    }
}
