package com.example.seat_service.exception;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private String status;
    private String errorMessage;
    private int statusCode;
    private String errorCode;
    private LocalDateTime timeStamp;

}
