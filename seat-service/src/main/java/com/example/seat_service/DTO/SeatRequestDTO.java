package com.example.seat_service.DTO;


import com.example.seat_service.enums.SeatClass;
import com.example.seat_service.enums.SeatType;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SeatRequestDTO {

    private String trainId;

    private String seatNumber;

    private String coach;

    private SeatType seatType;

    private SeatClass seatClass;

    private BigDecimal price;

    private boolean isAvailable;

    private boolean isBooked;
}
