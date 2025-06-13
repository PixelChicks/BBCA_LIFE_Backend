package com.bbcalife.bbcalife.exceptions.user;

import com.bbcalife.bbcalife.exceptions.common.ValidationException;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class UserValidationException extends ValidationException {
    public UserValidationException(Set<ConstraintViolation<?>> validationErrors) {
        super(validationErrors);
    }
}
