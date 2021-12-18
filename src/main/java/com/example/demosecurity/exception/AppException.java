package com.example.demosecurity.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException{
    private final ApiError apiError;

    public AppException(ApiError apiError) {
        this.apiError = apiError;
    }

    public AppException(ApiError apiError, String message, Throwable cause) {
        super(message, cause);
        this.apiError = apiError;
    }

}
