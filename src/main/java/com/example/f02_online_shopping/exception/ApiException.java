package com.example.f02_online_shopping.exception;

public class ApiException extends RuntimeException{
    private int httpCode;

    public int getHttpCode() {
        return httpCode;
    }

    public ApiException(int httpCode, String message) {
        super(message);
        this.httpCode = httpCode;
    }
}
