package com.example.user_service.enums;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {
    // Users
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "User not found"), // Indicates that the user was not found in the system
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "User already exists"), // Indicates that the user already exists in the system
    USER_NOT_SAVED_IN_COLLECTION(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save user in collection"), // Indicates a failure in saving user data
    PASSWORD_INCORRECT(HttpStatus.BAD_REQUEST, "Incorrect password"), // Indicates that the provided password is incorrect

    // Tickets
    TICKET_NOT_FOUND(HttpStatus.NOT_FOUND, "Ticket not found"), // Indicates that the ticket was not found in the system
    TICKET_NOT_BOOKED(HttpStatus.INTERNAL_SERVER_ERROR, "Ticket booking failed"), // Indicates a failure in booking the ticket
    TICKET_NOT_CANCELLED(HttpStatus.INTERNAL_SERVER_ERROR, "Ticket cancellation failed"), // Indicates a failure in canceling the ticket
    TICKET_NOT_SAVED_IN_COLLECTION(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save ticket in collection"), // Indicates a failure in saving ticket data
    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid input data"), // Indicates that the input data provided is invalid
    EMAIL_NOT_VALID(HttpStatus.BAD_REQUEST, "Invalid user email"); // Indicates that the provided email is not valid

    private final HttpStatus httpStatus; // HTTP status code associated with the response
    private final String message; // Descriptive message for the response status


    ResponseStatus(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}