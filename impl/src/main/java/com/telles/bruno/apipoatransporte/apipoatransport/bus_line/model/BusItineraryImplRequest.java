package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusItineraryImplRequest {
    private int id;
    private String code;
    private String name;
    private Map<String, BusStopImplRequest> itinerary;
}
