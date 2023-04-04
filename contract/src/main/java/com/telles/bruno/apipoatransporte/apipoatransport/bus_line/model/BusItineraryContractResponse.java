package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BusItineraryContractResponse {
    private int id;
    private String code;
    private String name;

    private Map<String, BusStopContractResponse> itinerary;
}
