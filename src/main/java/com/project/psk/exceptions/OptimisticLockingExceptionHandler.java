package com.project.psk.exceptions;

import jakarta.persistence.OptimisticLockException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OptimisticLockingExceptionHandler {
    @ExceptionHandler(value = {OptimisticLockingFailureException.class, OptimisticLockException.class})
    public ResponseEntity<Object> handleOptimisticLockingException(OptimisticLockingFailureException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Conflict occurred due to concurrent updates: " + ex.getMessage());
    }
}
