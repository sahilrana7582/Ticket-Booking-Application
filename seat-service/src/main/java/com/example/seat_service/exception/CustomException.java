package com.example.seat_service.exception;

import com.example.seat_service.enums.ResponseStatus;

public class CustomException extends RuntimeException{
    private ResponseStatus responseStatus;
    private String message;

    public CustomException(ResponseStatus responseStatus, String message) {
        this.responseStatus = responseStatus;
        this.message = message;
    }

    public CustomException(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public String getMessage() {
        return message;
    }
}
