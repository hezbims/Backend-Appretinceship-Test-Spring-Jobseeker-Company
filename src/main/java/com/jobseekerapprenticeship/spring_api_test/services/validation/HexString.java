package com.jobseekerapprenticeship.spring_api_test.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HexStringObjectIdValidator.class)
public @interface HexString {
    String message() default "The field must be a valid 24-character hexadecimal string (MongoDB ObjectId)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
