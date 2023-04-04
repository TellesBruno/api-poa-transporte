package com.telles.bruno.apipoatransporte.apipoatransport.taxi.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaxiStopImplResponse {
    private String name;
    private Double latitude;
    private Double longitude;
    private LocalDateTime createdAt;
}
