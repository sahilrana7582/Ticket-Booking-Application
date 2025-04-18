package com.example.ticket_service.DTO;


import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddIntermediateStopRequest {

    private String trainId;
    private String stationName;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
}
