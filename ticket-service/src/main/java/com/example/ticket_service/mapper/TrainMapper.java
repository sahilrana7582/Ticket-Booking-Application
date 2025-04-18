package com.example.ticket_service.mapper;


import com.example.ticket_service.DTO.CreateTrainRequest;
import com.example.ticket_service.DTO.IntermediateStopDTO;
import com.example.ticket_service.DTO.TrainResponse;
import com.example.ticket_service.entity.IntermediateStop;
import com.example.ticket_service.entity.Train;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainMapper {


    public Train mapToEntity(CreateTrainRequest request) {
        return Train.builder()
                .trainName(request.getTrainName())
                .trainNumber(request.getTrainNumber())
                .sourceStation(request.getSourceStation())
                .destinationStation(request.getDestinationStation())
                .departureTime(request.getDepartureTime())
                .arrivalTime(request.getArrivalTime())
                .totalSeats(request.getTotalSeats())
                .availableSeats(request.getTotalSeats())
                .fare(request.getFare())
                .intermediateStops(toIntermediateStopEntities(request.getIntermediateStops()))
                .build();
    }

    public TrainResponse toResponse(Train train) {
        return TrainResponse.builder()
                .trainId(train.getTrainId())
                .trainName(train.getTrainName())
                .trainNumber(train.getTrainNumber())
                .sourceStation(train.getSourceStation())
                .destinationStation(train.getDestinationStation())
                .departureTime(train.getDepartureTime())
                .arrivalTime(train.getArrivalTime())
                .totalSeats(train.getTotalSeats())
                .availableSeats(train.getAvailableSeats())
                .fare(train.getFare())
                .status(train.getStatus())
                .intermediateStops(toIntermediateStopDTOs(train.getIntermediateStops()))
                .build();
    }

    public List<IntermediateStop> toIntermediateStopEntities(List<IntermediateStopDTO> dtos) {
        return dtos.stream().map(dto -> IntermediateStop.builder()
                .stationName(dto.getStationName())
                .arrivalTime(dto.getArrivalTime())
                .departureTime(dto.getDepartureTime())
                .build()).collect(Collectors.toList());
    }

    public List<IntermediateStopDTO> toIntermediateStopDTOs(List<IntermediateStop> stops) {
        return stops.stream().map(stop -> IntermediateStopDTO.builder()
                .stationName(stop.getStationName())
                .arrivalTime(stop.getArrivalTime())
                .departureTime(stop.getDepartureTime())
                .build()).collect(Collectors.toList());
    }
}
