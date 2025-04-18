package com.example.ticket_service.service;

import com.example.ticket_service.DTO.*;

import java.util.List;
import java.util.UUID;

public interface TrainService {

    TrainResponse createTrain(CreateTrainRequest request);
    TrainResponse updateTrain(UpdateTrainRequest request);
    void deleteTrain(String trainId);
    TrainResponse addIntermediateStop(String trainId, IntermediateStopDTO stop);
    List<TrainResponse> getAllTrains();
    TrainResponse getTrainById(String trainId);

}