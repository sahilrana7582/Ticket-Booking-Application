package com.example.seat_service.service;

import com.example.seat_service.DTO.SeatRequestDTO;
import com.example.seat_service.DTO.SeatResponseDTO;
import com.example.seat_service.DTO.TrainSeatRecord;
import com.example.seat_service.entity.Seat;
import com.example.seat_service.enums.SeatClass;

import java.util.List;

public interface SeatService {

    SeatResponseDTO createSeat(SeatRequestDTO seatRequestDTO);
    List<SeatResponseDTO> allSeats();
    String createSeatsForTrain(String trainSeatRecord);
}
