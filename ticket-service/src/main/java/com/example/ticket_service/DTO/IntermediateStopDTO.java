package com.example.ticket_service.DTO;


import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntermediateStopDTO {
    private String stationName;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
}
