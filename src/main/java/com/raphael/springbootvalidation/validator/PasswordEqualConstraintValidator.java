package com.raphael.springbootvalidation.validator;

import com.raphael.springbootvalidation.dto.request.CreateUserRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordEqualConstraintValidator implements ConstraintValidator<PasswordEqualConstraint, Object>{

    @Override
    public boolean isValid(Object data, ConstraintValidatorContext constraintValidatorContext) {
        CreateUserRequest createUserRequest = (CreateUserRequest) data;
        return createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword());
    }
}