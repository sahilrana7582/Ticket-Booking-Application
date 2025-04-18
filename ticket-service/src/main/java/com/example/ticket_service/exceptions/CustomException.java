package com.example.ticket_service.exceptions;


import com.example.ticket_service.enums.ResponseStatus;

public class CustomException extends RuntimeException {

    private ResponseStatus errorCode;
    private String message;


    public CustomException(ResponseStatus errorCode) {
        this.errorCode = errorCode; // Initialize the error code
    }


    public CustomException(String message, ResponseStatus errorCode) {
        this.message = message; // Initialize the detailed error message
        this.errorCode = errorCode; // Initialize the error code
    }

    public ResponseStatus getErrorCode() {
        return errorCode; // Return the stored error code
    }

    public String getMessage() {
        return message; // Return the stored error message
    }
}