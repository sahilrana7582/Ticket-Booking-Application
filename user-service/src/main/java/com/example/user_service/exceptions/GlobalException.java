package com.example.user_service.exceptions;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetails> handleCustomException(CustomException ex) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(ex.getErrorCode().getHttpStatus().name()) // HTTP status as a string
                .errorMessage(ex.getMessage() == null?  ex.getErrorCode().getMessage():ex.getMessage()) // Error message from the exception
                .statusCode(ex.getErrorCode().getHttpStatus().value()) // HTTP status code as an integer
                .errorCode(ex.getErrorCode().name()) // Custom error code
                .timeStamp(LocalDateTime.now()) // Current timestamp
                .build();

        return new ResponseEntity<>(errorDetails, ex.getErrorCode().getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name()) // HTTP 500 status as a string
                .errorMessage(ex.getMessage()) // Error message from the exception
                .statusCode(500) // HTTP 500 status code as an integer
                .errorCode("INTERNAL_ERROR") // Generic error code for internal server errors
                .timeStamp(LocalDateTime.now()) // Current timestamp
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}