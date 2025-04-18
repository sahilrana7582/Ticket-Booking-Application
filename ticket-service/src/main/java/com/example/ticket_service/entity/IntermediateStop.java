package com.example.ticket_service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IntermediateStop {

    @Id
    @GeneratedValue
    private UUID id;

    private String stationName;

    private LocalDateTime arrivalTime;

    private LocalDateTime departureTime;
}
