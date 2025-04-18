package com.example.ticket_service.repository;

import com.example.ticket_service.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainRepository extends JpaRepository<Train, String> {
}
