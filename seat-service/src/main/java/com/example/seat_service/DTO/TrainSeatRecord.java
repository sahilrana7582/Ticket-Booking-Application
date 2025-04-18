package com.example.seat_service.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainSeatRecord {
    private String trainId;
    private int totalSeats;
}
