package com.example.seat_service.service;

import com.example.seat_service.DTO.SeatRequestDTO;
import com.example.seat_service.DTO.SeatResponseDTO;

public interface SeatService {

    SeatResponseDTO createSeat(SeatRequestDTO seatRequestDTO);
}
