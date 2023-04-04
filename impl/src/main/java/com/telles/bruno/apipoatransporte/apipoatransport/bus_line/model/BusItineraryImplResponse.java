package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BusItineraryImplResponse {
    @SerializedName("idlinha")
    private int id;
    @SerializedName("codigo")
    private String code;
    @SerializedName("nome")
    private String name;

    private Map<String, BusStopImplResponse> itinerary;
}
