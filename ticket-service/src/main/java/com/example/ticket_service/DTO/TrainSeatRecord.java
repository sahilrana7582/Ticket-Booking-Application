package com.example.ticket_service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TrainSeatRecord {
    private String trainId;
    private int totalSeats;
}
