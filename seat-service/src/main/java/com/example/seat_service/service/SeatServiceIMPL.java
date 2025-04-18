package com.example.seat_service.service;

import com.example.seat_service.DTO.SeatRequestDTO;
import com.example.seat_service.DTO.SeatResponseDTO;
import com.example.seat_service.DTO.TrainSeatRecord;
import com.example.seat_service.entity.Seat;
import com.example.seat_service.enums.SeatClass;
import com.example.seat_service.enums.SeatType;
import com.example.seat_service.mapper.SeatMapper;
import com.example.seat_service.repository.SeatRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class SeatServiceIMPL implements SeatService{


    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;
//    private final KafkaTemplate<String, TrainSeatRecord> trainSeatRecordKafkaTemplate;

    @Override
    public SeatResponseDTO createSeat(SeatRequestDTO seatRequestDTO) {
        Seat newseat = seatRepository.save(seatMapper.seatRequestDtoToSeat(seatRequestDTO));
        return seatMapper.seatToSeatResponseDto(newseat);
    }

    @Override
    public List<SeatResponseDTO> allSeats() {
        List<Seat> allSeats = seatRepository.findAll();
        return allSeats.stream().map(seatMapper::seatToSeatResponseDto).toList();
    }

    @Override
    @Transactional
    @KafkaListener(topics = "train-creation-events", groupId = "seat-service")
    public String createSeatsForTrain(String message) {
        String trainId;
        int totalSeats;
        ObjectMapper mapper = new ObjectMapper();

        try {
            TrainSeatRecord trainSeatRecord = mapper.readValue(message, TrainSeatRecord.class);
            trainId = trainSeatRecord.getTrainId();
            totalSeats = trainSeatRecord.getTotalSeats();
            int acSeats = (int) Math.ceil((double)totalSeats * 0.35);
            int ecoSeats = totalSeats - acSeats;
            createSeatsForTrainById(trainId, ecoSeats, SeatClass.ECONOMY);
            createSeatsForTrainById(trainId, acSeats, SeatClass.AC);
            log.info("Seats created for train with ID: ->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + trainId);
            return "Seats created for train with ID: " + trainId;
        } catch (Exception e) {
            return "Error creating seats for train: " + e.getMessage();
        }
    }

    public void createSeatsForTrainById(String trainId, int numberOfSeats, SeatClass seatClass) {
        List<Seat> seatList = new ArrayList<>();
        int seatsPerCoach = 25;
        int numberOfCoaches = (int) Math.ceil((double) numberOfSeats / seatsPerCoach);

        for (int coachNumber = 1; coachNumber <= numberOfCoaches; coachNumber++) {
            String coachName = "Coach " + String.valueOf(coachNumber);

            for(int seatNumber = 1; seatNumber <= seatsPerCoach; seatNumber++) {
                String seatNumberString = coachName +": " + String.valueOf(seatNumber);

                Seat seat = Seat.builder()
                        .trainId(trainId)
                        .seatNumber(generateSeatNumber(seatNumber))
                        .coach(coachName)
                        .seatType(getSeatType(seatNumber))
                        .seatClass(seatClass)
                        .price(getPrice(getSeatType(seatNumber), seatClass))
                        .isAvailable(true)
                        .isBooked(false)
                        .build();
                seatList.add(seat);
                seatRepository.save(seat);

            }
        }
    }

    private String generateSeatNumber(int seatNum) {
        int rowNum = (seatNum - 1) % 6 + 1;
        char seatLetter = (char) ('A' + (seatNum - 1) / 6);
        return String.format("%c%d", seatLetter, rowNum);
    }

    private SeatType getSeatType(int seatNum) {
        int rowNum = (seatNum - 1) % 6 + 1;
        if (rowNum == 1 || rowNum == 6) {
            return SeatType.WINDOW;
        } else if (rowNum == 2 || rowNum == 5) {
            return SeatType.AISLE;
        } else {
            return SeatType.MIDDLE;
        }
    }

    private BigDecimal getPrice(SeatType seatType, SeatClass seatClass) {
        BigDecimal basePrice = new BigDecimal("500.00");

        if(seatType == SeatType.WINDOW) {
            basePrice = basePrice.multiply(new BigDecimal("1.5"));
        }else if(seatType == SeatType.AISLE) {
            basePrice = basePrice.multiply(new BigDecimal("1.1"));
        }

        if(seatClass == SeatClass.AC) {
            basePrice = basePrice.multiply(new BigDecimal("1.5"));
        }
        return basePrice;
    }


}
