package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusItineraryContractRequest {
    @NotEmpty(message = "A valid value must be provided for the id field")
    private int id;

    @NotEmpty(message = "A valid value must be provided for the code field")
    private String code;

    @NotEmpty(message = "A valid value must be provided for the name field")
    private String name;

    @NotEmpty(message = "A valid value must be provided for the itinerary field")
    private Map<String, BusStopContractRequest> itinerary;
}
