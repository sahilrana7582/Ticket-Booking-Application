package com.example.seat_service.mapper;


import com.example.seat_service.DTO.SeatRequestDTO;
import com.example.seat_service.DTO.SeatResponseDTO;
import com.example.seat_service.entity.Seat;
import org.springframework.stereotype.Component;

@Component
public class SeatMapper {


    public Seat seatRequestDtoToSeat(SeatRequestDTO seatRequestDTO) {

        return Seat.builder()
                .trainId(seatRequestDTO.getTrainId())
                .seatNumber(seatRequestDTO.getSeatNumber())
                .coach(seatRequestDTO.getCoach())
                .seatType(seatRequestDTO.getSeatType())
                .seatClass(seatRequestDTO.getSeatClass())
                .price(seatRequestDTO.getPrice())
                .isAvailable(seatRequestDTO.isAvailable())
                .isBooked(seatRequestDTO.isBooked())
                .build();
    }

    public SeatResponseDTO seatToSeatResponseDto(Seat seat) {
        return SeatResponseDTO.builder()
                .id(seat.getId())
                .trainId(seat.getTrainId())
                .seatNumber(seat.getSeatNumber())
                .coach(seat.getCoach())
                .seatType(seat.getSeatType())
                .seatClass(seat.getSeatClass())
                .price(seat.getPrice())
                .isAvailable(seat.isAvailable())
                .isBooked(seat.isBooked())
                .build();
    }


}
