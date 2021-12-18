package com.example.demosecurity.constant.common;

import lombok.Data;

@Data
public class SystemResponse<T> {
    private int status;
    private String message;
    private T data;

    public SystemResponse() {
    }

    public SystemResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public SystemResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

}