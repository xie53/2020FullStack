package com.ibm.business.validator.impl;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.business.validator.ValidateService;

@Service
public class ValidateServiceImpl implements ValidateService {

    @Autowired
    Validator validator;

    @Override
    public <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
