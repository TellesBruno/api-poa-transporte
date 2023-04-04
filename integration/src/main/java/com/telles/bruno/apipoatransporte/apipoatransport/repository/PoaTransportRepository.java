package com.telles.bruno.apipoatransporte.apipoatransport.repository;

import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusItineraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoaTransportRepository extends JpaRepository<BusItineraryEntity, Long> {
}