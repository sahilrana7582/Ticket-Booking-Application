package com.example.seat_service.service;

import com.example.seat_service.DTO.SeatRequestDTO;
import com.example.seat_service.DTO.SeatResponseDTO;
import com.example.seat_service.entity.Seat;
import com.example.seat_service.mapper.SeatMapper;
import com.example.seat_service.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class SeatServiceIMPL implements SeatService{


    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;

    @Override
    public SeatResponseDTO createSeat(SeatRequestDTO seatRequestDTO) {
        Seat newseat = seatRepository.save(seatMapper.seatRequestDtoToSeat(seatRequestDTO));
        return seatMapper.seatToSeatResponseDto(newseat);
    }


}
