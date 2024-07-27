package com.genericprojectmaven.exception.custom;

public class BatchOperationException extends RuntimeException {
    public BatchOperationException(Exception exception) { super(exception); }
}
