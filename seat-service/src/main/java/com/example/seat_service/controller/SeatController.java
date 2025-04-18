package com.example.seat_service.controller;


import com.example.seat_service.DTO.SeatRequestDTO;
import com.example.seat_service.DTO.SeatResponseDTO;
import com.example.seat_service.service.SeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/seat")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatResponseDTO> createSeat(@RequestBody SeatRequestDTO seatRequestDTO) {
        return ResponseEntity.ok(seatService.createSeat(seatRequestDTO));
    }
}
