package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.*;
import lombok.NoArgsConstructor;

import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BusLineImplMapper {
    public static BusItineraryEntity toBusItineraryIntegrationRequest(BusItineraryImplRequest busItineraryImplRequest) {
        return BusItineraryEntity.builder()
                .id((long)busItineraryImplRequest.getId())
                .code(busItineraryImplRequest.getCode())
                .name(busItineraryImplRequest.getName())
                .itinerary(toItineraryString(busItineraryImplRequest.getItinerary()))
                .build();
    }

    public static BusItineraryImplResponse toBusItineraryImplResponse(BusItineraryEntity busItineraryEntity) {
        return BusItineraryImplResponse.builder()
                .id(busItineraryEntity.getId().intValue())
                .code(busItineraryEntity.getCode())
                .name(busItineraryEntity.getName())
                .itinerary(toItineraryMap(busItineraryEntity.getItinerary()))
                .build();
    }

    private static String toItineraryString(Map<String, BusStopImplRequest> itinerary) {
        return new Gson().toJson(itinerary);
    }

    private static Map<String, BusStopImplResponse> toItineraryMap(String itinerary) {
        var gson = new Gson();
        Map<String, BusStopImplResponse> mappedItinerary = new LinkedTreeMap<>();

        gson.fromJson(itinerary, JsonObject.class).entrySet().forEach(entry -> {
            BusStopImplResponse busStop = gson.fromJson(entry.getValue(), BusStopImplResponse.class);
            mappedItinerary.put(entry.getKey(), busStop);
        });

        return mappedItinerary;
    }
}
