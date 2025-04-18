package com.example.ticket_service.controller;



import com.example.ticket_service.DTO.CreateTrainRequest;
import com.example.ticket_service.DTO.IntermediateStopDTO;
import com.example.ticket_service.DTO.TrainResponse;
import com.example.ticket_service.DTO.UpdateTrainRequest;
import com.example.ticket_service.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/trains")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService trainService;

    @PostMapping
    public ResponseEntity<TrainResponse> createTrain(@RequestBody CreateTrainRequest request) {
        TrainResponse response = trainService.createTrain(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<TrainResponse> updateTrain(@RequestBody UpdateTrainRequest request) {
        TrainResponse response = trainService.updateTrain(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{trainId}")
    public ResponseEntity<String> deleteTrain(@PathVariable String trainId) {
        trainService.deleteTrain(trainId);
        return ResponseEntity.ok("Train deleted successfully");
    }

    @PostMapping("/{trainId}/intermediate-stops")
    public ResponseEntity<TrainResponse> addIntermediateStop(
            @PathVariable String trainId,
            @RequestBody IntermediateStopDTO stopRequest) {
        TrainResponse response = trainService.addIntermediateStop(trainId, stopRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TrainResponse>> getAllTrains() {
        return ResponseEntity.ok(trainService.getAllTrains());
    }


    @GetMapping("/{trainId}")
    public ResponseEntity<TrainResponse> getTrainById(@PathVariable String trainId) {
        return ResponseEntity.ok(trainService.getTrainById(trainId));
    }

    @GetMapping("/station/{station}")
    public ResponseEntity<List<TrainResponse>> findAllTrainsByStation(@PathVariable String station) {
        return ResponseEntity.ok(trainService.findAllTrainsByStation(station));
    }

}
