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

@RestController
@RequestMapping("/api/trains")
@RequiredArgsConstructor
public class TrainController {

    private final TrainService trainService;

    // ➕ Create New Train
    @PostMapping
    public ResponseEntity<TrainResponse> createTrain(@RequestBody CreateTrainRequest request) {
        TrainResponse response = trainService.createTrain(request);
        return ResponseEntity.ok(response);
    }

    // ♻️ Update Train
    @PutMapping
    public ResponseEntity<TrainResponse> updateTrain(@RequestBody UpdateTrainRequest request) {
        TrainResponse response = trainService.updateTrain(request);
        return ResponseEntity.ok(response);
    }

    // ❌ Delete Train
    @DeleteMapping("/{trainId}")
    public ResponseEntity<String> deleteTrain(@PathVariable String trainId) {
        trainService.deleteTrain(trainId);
        return ResponseEntity.ok("Train deleted successfully");
    }

    // 🚏 Add Intermediate Stop
    @PostMapping("/{trainId}/intermediate-stops")
    public ResponseEntity<TrainResponse> addIntermediateStop(
            @PathVariable String trainId,
            @RequestBody IntermediateStopDTO stopRequest) {
        TrainResponse response = trainService.addIntermediateStop(trainId, stopRequest);
        return ResponseEntity.ok(response);
    }

    // 📄 Get All Trains
    @GetMapping
    public ResponseEntity<List<TrainResponse>> getAllTrains() {
        return ResponseEntity.ok(trainService.getAllTrains());
    }

    // 🔍 Get Train By ID
    @GetMapping("/{trainId}")
    public ResponseEntity<TrainResponse> getTrainById(@PathVariable String trainId) {
        return ResponseEntity.ok(trainService.getTrainById(trainId));
    }
}
