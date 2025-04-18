package com.example.seat_service.enums;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {


    SEAT_NOT_FOUND(HttpStatus.NOT_FOUND, "Seat not found"),
    SEAT_NOT_AVAILABLE(HttpStatus.BAD_REQUEST, "Seat not available"),
    SEAT_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "Seat already exists"),
    SEAT_NOT_SAVED_IN_COLLECTION(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save seat in collection"),
    SEAT_NOT_UPDATED(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to update seat"),
    SEAT_ALREADY_BOOKED(HttpStatus.BAD_REQUEST, "Seat already booked");

    private final HttpStatus status;
    private final String message;

    ResponseStatus(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
