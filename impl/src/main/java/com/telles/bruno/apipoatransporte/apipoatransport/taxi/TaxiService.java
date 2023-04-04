package com.telles.bruno.apipoatransporte.apipoatransport.taxi;

import com.telles.bruno.apipoatransporte.apipoatransport.taxi.mapper.TaxiStopImplMapper;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopImplRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopImplResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
@AllArgsConstructor
public class TaxiService {

    TaxiIntegration taxiIntegration;

    public List<TaxiStopImplResponse> getTaxiStops() {
        List<TaxiStopImplResponse> taxiStops = new ArrayList<>();
        taxiIntegration.readTaxiStops().forEach(line -> {
            String[] split = line.split("#");
            TaxiStopImplResponse taxiStop = TaxiStopImplMapper.mapTaxiStop(split);
            taxiStops.add(taxiStop);
        });
        return taxiStops;
    }

    public List<TaxiStopImplResponse> findTaxiStopsByName(String name) {
        return getTaxiStops().stream()
                .filter(taxiStop -> taxiStop.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public void addTaxiStop(TaxiStopImplRequest taxiStopImplRequest) {
        taxiIntegration.addTaxiStop(TaxiStopImplMapper.mapTaxiStopString(taxiStopImplRequest));
    }
}
