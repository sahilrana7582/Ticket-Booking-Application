package com.example.seat_service.entity;

import com.example.seat_service.enums.SeatClass;
import com.example.seat_service.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String trainId;  // Foreign key reference to Train

    private String seatNumber;  // Like A1, B2, etc.

    private String coach;  // Coach number/name

    private SeatType seatType;  // WINDOW, MIDDLE, AISLE, etc.

    private SeatClass seatClass;  // ECONOMY, BUSINESS, FIRST_CLASS, etc.

    private BigDecimal price;  // Price for this specific seat (may differ based on type/class)

    private boolean isAvailable;

    private boolean isBooked;



}