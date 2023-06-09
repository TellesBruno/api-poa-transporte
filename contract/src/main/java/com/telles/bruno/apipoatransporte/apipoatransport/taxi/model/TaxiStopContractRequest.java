package com.telles.bruno.apipoatransporte.apipoatransport.taxi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaxiStopContractRequest {
    private String name;
    private Double latitude;
    private Double longitude;
}
