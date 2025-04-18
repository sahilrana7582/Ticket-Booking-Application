package com.example.ticket_service.service;


import com.example.ticket_service.DTO.*;
import com.example.ticket_service.entity.Train;
import com.example.ticket_service.mapper.TrainMapper;
import com.example.ticket_service.repository.TrainRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;
    private final TrainMapper trainMapper;
    private final KafkaTemplate<String, TrainSeatRecord> trainSeatRecordKafkaTemplate;

    @Override
    public TrainResponse createTrain(CreateTrainRequest request) {
        Train train = trainRepository.save(trainMapper.mapToEntity(request));
        trainSeatRecordKafkaTemplate.send("train-creation-events", new TrainSeatRecord(train.getTrainId(), train.getTotalSeats()));
        return trainMapper.toResponse(train);
    }

    @Override
    public TrainResponse getTrainById(String trainId) {
        Train train = trainRepository.findById(trainId).orElseThrow(() -> new RuntimeException("Train not found"));
        return trainMapper.toResponse(train);
    }


    @Override
    public TrainResponse updateTrain(UpdateTrainRequest request) {
        Train train = trainRepository.findById(request.getTrainId())
                .orElseThrow(() -> new RuntimeException("Train not found"));

        train.setTrainName(request.getTrainName());
        train.setSourceStation(request.getSourceStation());
        train.setDestinationStation(request.getDestinationStation());
        train.setDepartureTime(request.getDepartureTime());
        train.setArrivalTime(request.getArrivalTime());
        train.setTotalSeats(request.getTotalSeats());
        train.setAvailableSeats(request.getAvailableSeats());
        train.setFare(request.getFare());
        train.setStatus(request.getStatus());

        return trainMapper.toResponse(trainRepository.save(train));
    }

    @Override
    public void deleteTrain(String trainId) {
        trainRepository.deleteById(trainId);
    }

    @Override
    public TrainResponse addIntermediateStop(String trainId, IntermediateStopDTO stop) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train not found"));

        train.getIntermediateStops().addAll(trainMapper.toIntermediateStopEntities(List.of(stop)));
        return trainMapper.toResponse(trainRepository.save(train));
    }

    @Override
    public List<TrainResponse> getAllTrains() {
        return trainRepository.findAll()
                .stream()
                .map(trainMapper::toResponse)
                .toList();
    }


    @Override
    public List<TrainResponse> findAllTrainsByStation(String station) {
        return trainRepository.findAllTrainsByStation(station)
                .stream().map(trainMapper::toResponse)
                .toList();
    }


}
