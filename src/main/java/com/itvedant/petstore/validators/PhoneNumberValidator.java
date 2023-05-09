package com.itvedant.petstore.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator 
    implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        if(value == null){
            return true;
        }
        return value.length() == 10 && value.matches("[0-9]+");
    } 
}
