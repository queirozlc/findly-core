package com.br.findly.shared.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Arrays;

public class ValidateOneNotNullValidator implements ConstraintValidator<ValidateOneNotNull, Object> {

    private String[] fields;

    /**
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ValidateOneNotNull constraintAnnotation) {
        this.fields = constraintAnnotation.fields();
    }

    /**
     * @param object
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(object);
        return Arrays.stream(fields).anyMatch(field -> beanWrapper.getPropertyValue(field) != null && !beanWrapper.getPropertyValue(field).toString().isEmpty());
    }
}
