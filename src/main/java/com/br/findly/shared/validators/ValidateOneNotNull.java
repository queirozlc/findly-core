package com.br.findly.shared.validators;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidateOneNotNullValidator.class)
public @interface ValidateOneNotNull {

    String message() default "Pelo menos um dos campos deve ser preenchido";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

    String[] fields();

}
