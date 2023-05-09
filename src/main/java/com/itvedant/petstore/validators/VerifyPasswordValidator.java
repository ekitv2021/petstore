package com.itvedant.petstore.validators;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VerifyPasswordValidator 
    implements ConstraintValidator<VerifyPassword, Object>{
    private String field;
    private String matchingField;

    @Override
    public void initialize(VerifyPassword constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.matchingField = constraintAnnotation.matchingField();
    }
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
       Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
       Object matchingFieldValue = new BeanWrapperImpl(value).getPropertyValue(matchingField); 
        if(fieldValue != null){
            return fieldValue.equals(matchingFieldValue);
        }
        return matchingFieldValue != null;
    }    
}
