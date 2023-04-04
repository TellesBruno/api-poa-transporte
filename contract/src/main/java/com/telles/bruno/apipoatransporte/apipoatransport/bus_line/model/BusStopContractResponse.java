package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusStopContractResponse {
    private String lat;
    private String lon;
}
