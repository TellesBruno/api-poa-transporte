package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusStopContractRequest {
    @NotEmpty(message = "A valid value must be provided for the field lat")
    private String lat;
    @NotEmpty(message = "A valid value must be provided for the field lon")
    private String lon;
}
