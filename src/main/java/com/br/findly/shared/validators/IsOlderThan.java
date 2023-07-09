package com.br.findly.shared.validators;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsOlderThanValidator.class)
public @interface IsOlderThan {

    int value();


    String message() default "Age must be greater than {value}";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

}
