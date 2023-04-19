package com.estukalov.assessment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ValidationControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorContainerResponse handleValidationError(ConstraintViolationException constraintViolationException) {
        ErrorContainerResponse errorContainerResponse = new ErrorContainerResponse();
        for (ConstraintViolation<?> constraintViolation : constraintViolationException.getConstraintViolations()) {
            Error error = new Error(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
            errorContainerResponse.getErrors().add(error);
        }
        return errorContainerResponse;
    }
}
