package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusLineContractResponse {
    private int id;
    private String code;
    private String name;
}
