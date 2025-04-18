package com.example.seat_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetails> handleCustomException(CustomException ex){

        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(ex.getResponseStatus().getHttpStatus().name())
                .errorMessage(ex.getMessage() == null?  ex.getResponseStatus().getMessage():ex.getMessage())
                .statusCode(ex.getResponseStatus().getHttpStatus().value())
                .errorCode(ex.getResponseStatus().name())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorDetails, ex.getResponseStatus().getHttpStatus());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex) {

        ErrorDetails errorDetails = ErrorDetails.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .errorMessage(ex.getMessage())
                .statusCode(500)
                .errorCode("INTERNAL_ERROR")
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
