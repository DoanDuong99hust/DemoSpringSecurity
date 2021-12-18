package com.example.demosecurity.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;



    public ApiError(HttpStatus status) {
        timestamp = LocalDateTime.now();
        this.status = status;
    }

    public ApiError(HttpStatus status, Throwable ex) {
        timestamp = LocalDateTime.now();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiError(HttpStatus status, String message,List<ApiSubError> apiSubErrors, Throwable ex) {
        timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
        this.subErrors = apiSubErrors;
    }

    public ApiError(HttpStatus status, String message){
        timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }
}
