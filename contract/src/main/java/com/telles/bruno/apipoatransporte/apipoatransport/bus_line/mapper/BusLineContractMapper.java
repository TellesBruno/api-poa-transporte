package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.mapper;


import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.*;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class BusLineContractMapper {
    public static BusLineContractResponse toBusLineContractResponse(BusLineImplResponse busLineImplResponse) {
        return BusLineContractResponse.builder()
                .id(busLineImplResponse.getId())
                .code(busLineImplResponse.getCode())
                .name(busLineImplResponse.getName())
                .build();
    }

    public static BusItineraryContractResponse toBusLineItineraryContractResponse(BusItineraryImplResponse busLineItinerary) {
        return BusItineraryContractResponse.builder()
                .id(busLineItinerary.getId())
                .code(busLineItinerary.getCode())
                .name(busLineItinerary.getName())
                .itinerary(toBusStopContractResponse(busLineItinerary.getItinerary()))
                .build();
    }

    public static BusItineraryImplRequest toBusLineItineraryImplRequest(BusItineraryContractRequest busLineItinerary) {
        return BusItineraryImplRequest.builder()
                .id(busLineItinerary.getId())
                .code(busLineItinerary.getCode())
                .name(busLineItinerary.getName())
                .itinerary(toBusStopImplRequest(busLineItinerary.getItinerary()))
                .build();
    }

    private static Map<String, BusStopContractResponse> toBusStopContractResponse(Map<String, BusStopImplResponse> itinerary) {
        Map<String, BusStopContractResponse> mappedItinerary = new HashMap<>(Map.of());

        itinerary.forEach((key, value) -> mappedItinerary.put(key, BusStopContractResponse.builder()
                .lat(value.getLat())
                .lon(value.getLon())
                .build()));

        return mappedItinerary;
    }

    private static Map<String, BusStopImplRequest> toBusStopImplRequest(Map<String, BusStopContractRequest> itinerary) {
        Map<String, BusStopImplRequest> mappedItinerary = new HashMap<>(Map.of());

        itinerary.forEach((key, value) -> mappedItinerary.put(key, BusStopImplRequest.builder()
                .lat(value.getLat())
                .lon(value.getLon())
                .build()));

        return mappedItinerary;
    }

    public static BusLineCoordinateImplRequest toBusLineCoordinateImplRequest(BusLineCoordinateContractRequest busLineCoordinateContractRequest) {
        return BusLineCoordinateImplRequest.builder()
                .radius(busLineCoordinateContractRequest.getRadius())
                .latitude(busLineCoordinateContractRequest.getLatitude())
                .longitude(busLineCoordinateContractRequest.getLongitude())
                .build();
    }
}
