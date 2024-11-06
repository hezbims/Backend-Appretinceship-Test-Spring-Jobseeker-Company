package com.jobseekerapprenticeship.spring_api_test.services.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HexStringObjectIdValidator implements ConstraintValidator<HexString, String> {

    private static final String HEX_PATTERN = "^[a-fA-F0-9]{24}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.matches(HEX_PATTERN);
    }
}