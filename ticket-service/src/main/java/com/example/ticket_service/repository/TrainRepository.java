package com.example.ticket_service.repository;

import com.example.ticket_service.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TrainRepository extends JpaRepository<Train, String> {



    @Query(
            """
            SELECT t from Train t
            LEFT JOIN t.intermediateStops s
            WHERE s.stationName = :station
            OR t.sourceStation = :station
            OR t.destinationStation = :station
            """
    )
    List<Train> findAllTrainsByStation(String station);
}
