package com.genericprojectmaven.exception.handler;

import com.genericprojectmaven.exception.custom.BatchOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BatchOperationException.class)
    public ResponseEntity<String> handleBatchOperation(BatchOperationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
