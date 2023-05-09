package com.itvedant.petstore.exceptions;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler 
        extends ResponseEntityExceptionHandler {
    @ExceptionHandler({TransactionSystemException.class})
    public ResponseEntity<?> handleConstraintViolation(Exception ex) {
    Throwable cause = ((TransactionSystemException) ex).getRootCause();
    List<String> violationMessages = null;
    if (cause instanceof ConstraintViolationException) {
        Set<ConstraintViolation<?>> constraintViolations = 
                ((ConstraintViolationException) cause).getConstraintViolations();
        violationMessages = constraintViolations.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
        }
    return ResponseEntity.ok(violationMessages);
    }
}
