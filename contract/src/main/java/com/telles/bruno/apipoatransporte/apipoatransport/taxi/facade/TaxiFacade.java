package com.telles.bruno.apipoatransporte.apipoatransport.taxi.facade;

import com.telles.bruno.apipoatransporte.apipoatransport.taxi.TaxiService;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.mapper.TaxiContractMapper;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopContractRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopContractResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TaxiFacade {

    TaxiService taxiService;

    public List<TaxiStopContractResponse> getTaxiStops() {
        return taxiService.getTaxiStops().stream().map(TaxiContractMapper::toTaxiStopContractResponse).toList();
    }

    public List<TaxiStopContractResponse> findTaxiStopsByName(String name) {
        return taxiService.findTaxiStopsByName(name).stream().map(TaxiContractMapper::toTaxiStopContractResponse).toList();
    }

    public void addTaxiStop(TaxiStopContractRequest taxiStopContractRequest) {
        taxiService.addTaxiStop(TaxiContractMapper.toTaxiStopImplRequest(taxiStopContractRequest));
    }
}
