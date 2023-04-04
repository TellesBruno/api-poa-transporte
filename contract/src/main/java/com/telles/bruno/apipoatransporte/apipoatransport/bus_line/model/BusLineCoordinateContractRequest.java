package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusLineCoordinateContractRequest {
    private double radius;
    private double latitude;
    private double longitude;
}
