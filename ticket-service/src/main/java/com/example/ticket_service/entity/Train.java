package com.example.ticket_service.entity;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Train {

    @Id
    @GeneratedValue
    private UUID trainId;

    private String trainName;

    @Column(unique = true, nullable = false)
    private String trainNumber;

    private String sourceStation;

    private String destinationStation;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    private Integer totalSeats;

    private Integer availableSeats;

    private BigDecimal fare;

    @Enumerated(EnumType.STRING)
    private TrainStatus status;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "train_id") // foreign key in IntermediateStop table
    private List<IntermediateStop> intermediateStops;
}

