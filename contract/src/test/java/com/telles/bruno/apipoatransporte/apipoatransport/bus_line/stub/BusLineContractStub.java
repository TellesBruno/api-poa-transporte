package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.stub;

import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.*;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public class BusLineContractStub {

    public static List<BusLineContractResponse> listOfBusLineContractResponse() {
        return List.of(
                BusLineContractResponse.builder()
                        .id(1)
                        .code("TEST-1")
                        .name("TESTE BUS LINE 1")
                        .build(),
                BusLineContractResponse.builder()
                        .id(2)
                        .code("TEST-2")
                        .name("TESTE BUS LINE 2")
                        .build()
        );
    }

    public static List<BusItineraryContractResponse> listOfBusItineraryContractResponse() {
        return List.of(
                BusItineraryContractResponse.builder()
                        .id(1)
                        .code("TEST-1")
                        .name("TESTE BUS LINE 1")
                        .itinerary(Map.of(
                                "0", BusStopContractResponse.builder().lat("-30.123633798178").lon("-51.222560282341").build()
                        ))
                        .build(),
                BusItineraryContractResponse.builder()
                        .id(2)
                        .code("TEST-2")
                        .name("TESTE BUS LINE 2")
                        .itinerary(Map.of(
                                "0", BusStopContractResponse.builder().lat("-30.123633998178").lon("-51.222560482341").build()
                        ))
                        .build()
        );
    }

    public static BusItineraryContractRequest busItineraryContractRequest() {
        return BusItineraryContractRequest.builder()
                .id(1)
                .code("TEST-1")
                .name("TESTE BUS LINE 1")
                .itinerary(Map.of(
                        "0", BusStopContractRequest.builder().lat("-30.123633798178").lon("-51.222560282341").build()
                ))
                .build();
    }

    public static BusItineraryContractResponse busItineraryContractResponse() {
        return BusItineraryContractResponse.builder()
                .id(1)
                .code("TEST-1")
                .name("TESTE BUS LINE 1")
                .itinerary(Map.of(
                        "0", BusStopContractResponse.builder().lat("-30.123633798178").lon("-51.222560282341").build()
                ))
                .build();
    }

    public static BusLineCoordinateContractRequest busLineCoordinateContractRequest() {
        return BusLineCoordinateContractRequest.builder()
                .radius(2.0)
                .latitude(-30.123633798178)
                .longitude(-51.222560282341)
                .build();
    }
}
