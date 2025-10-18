package com.garbi.coursero.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//We want ot be only applied to field and be available at run time
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = MultipartFileValidator.class )
public @interface MultipartIsValid {
    String message() default "Invalid Multi part File ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
