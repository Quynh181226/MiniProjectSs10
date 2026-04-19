package com.Ss10.MiniProject2.equipmentborrowingmana.custom_validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentIdValidator implements ConstraintValidator<StudentIdValid, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()){
            return true;
        }

        return value.matches("^SV\\d+$");
    }
}
