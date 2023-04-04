package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusLineImplResponse {
    @SerializedName("id")
    private int id;
    @SerializedName("codigo")
    private String code;
    @SerializedName("nome")
    private String name;
}
