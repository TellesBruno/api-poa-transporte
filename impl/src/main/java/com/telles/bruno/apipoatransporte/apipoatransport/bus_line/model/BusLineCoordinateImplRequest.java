package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusLineCoordinateImplRequest {
    private double radius;
    private double latitude;
    private double longitude;
}
