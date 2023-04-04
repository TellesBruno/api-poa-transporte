package com.telles.bruno.apipoatransporte.apipoatransport.taxi.mapper;

import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopImplRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopImplResponse;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TaxiStopImplMapper {
    public static TaxiStopImplResponse mapTaxiStop(String[] data) {
        return TaxiStopImplResponse.builder()
                .name(data[0])
                .latitude(Double.parseDouble(data[1]))
                .longitude(Double.parseDouble(data[2]))
                .createdAt(LocalDateTime.parse(data[3]))
                .build();
    }

    public static String mapTaxiStopString(TaxiStopImplRequest taxiStopImplRequest) {
        return taxiStopImplRequest.getName() +
                "#" +
                taxiStopImplRequest.getLatitude() +
                "#" +
                taxiStopImplRequest.getLongitude() +
                "#" +
                taxiStopImplRequest.getCreatedAt() +
                "\n";
    }
}
