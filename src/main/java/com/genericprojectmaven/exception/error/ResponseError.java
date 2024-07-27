package com.genericprojectmaven.exception.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseError {
    private String message;
    private Instant timestamp;
    private List<Error> errors;

    public static ResponseError generateResponseError(String message, Instant timestamp, List<Error> errors) {
        return new ResponseError(message, timestamp, errors);
    }

    @Getter
    @AllArgsConstructor
    public static class Error {
        private String message;
    }
}
