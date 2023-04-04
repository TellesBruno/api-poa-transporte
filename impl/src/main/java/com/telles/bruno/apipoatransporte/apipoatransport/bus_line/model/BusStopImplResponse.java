package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusStopImplResponse {
    @SerializedName("lat")
    private String lat;
    @SerializedName(value = "lng", alternate = "lon")
    private String lon;
}
