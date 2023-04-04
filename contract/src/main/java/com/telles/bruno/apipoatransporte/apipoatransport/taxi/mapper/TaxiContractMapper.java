package com.telles.bruno.apipoatransporte.apipoatransport.taxi.mapper;

import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopContractRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopContractResponse;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopImplRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopImplResponse;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TaxiContractMapper {
    public static TaxiStopContractResponse toTaxiStopContractResponse(TaxiStopImplResponse taxiStopImplResponse) {
        return TaxiStopContractResponse.builder()
                .name(taxiStopImplResponse.getName())
                .latitude(taxiStopImplResponse.getLatitude())
                .longitude(taxiStopImplResponse.getLongitude())
                .createdAt(taxiStopImplResponse.getCreatedAt())
                .build();
    }

    public static TaxiStopImplRequest toTaxiStopImplRequest(TaxiStopContractRequest taxiStopContractRequest) {
        return TaxiStopImplRequest.builder()
                .name(taxiStopContractRequest.getName())
                .latitude(taxiStopContractRequest.getLatitude())
                .longitude(taxiStopContractRequest.getLongitude())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
