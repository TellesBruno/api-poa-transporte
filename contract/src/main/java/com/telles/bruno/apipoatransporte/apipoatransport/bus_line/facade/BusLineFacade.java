package com.telles.bruno.apipoatransporte.apipoatransport.bus_line.facade;

import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.mapper.BusLineContractMapper;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusItineraryContractRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusLineContractResponse;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.BusLineService;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusItineraryContractResponse;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusLineCoordinateContractRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class BusLineFacade {

    private final BusLineService busService;
    public List<BusLineContractResponse> getBusLines() {
        return busService.getAllBusLines().stream()
                .map(BusLineContractMapper::toBusLineContractResponse)
                .toList();
    }

    public BusLineContractResponse getBusLineById(int id) {
        return BusLineContractMapper.toBusLineContractResponse(busService.getBusLineById(id));
    }

    public BusItineraryContractResponse getBusLineItinerary(int id) {
        return BusLineContractMapper.toBusLineItineraryContractResponse(busService.getBusLineItinerary(id));
    }

    public List<BusLineContractResponse> searchBusLineByName(String name) {
        return busService.searchBusLineByName(name).stream()
                .map(BusLineContractMapper::toBusLineContractResponse)
                .toList();
    }

    public void createBusLine(BusItineraryContractRequest busItineraryContractRequest) {
        busService.createBusLine(BusLineContractMapper.toBusLineItineraryImplRequest(busItineraryContractRequest));
    }

    public BusItineraryContractResponse findBusItineraryById(int id) {
        return BusLineContractMapper.toBusLineItineraryContractResponse(busService.findBusItineraryById(id));
    }

    public void deleteBusLine(int id) {
        busService.deleteBusLineById(id);
    }

    public void updateBusLine(BusItineraryContractRequest busItineraryContractRequest) {
        busService.updateBusLine(BusLineContractMapper.toBusLineItineraryImplRequest(busItineraryContractRequest));
    }

    public List<BusItineraryContractResponse> findAllBusItineraries() {
        return busService.findAllBusItineraries().stream()
                .map(BusLineContractMapper::toBusLineItineraryContractResponse)
                .toList();
    }

    public List<BusItineraryContractResponse> findBusItineraryByName(String name) {
        return busService.findBusItineraryByName(name).stream()
                .map(BusLineContractMapper::toBusLineItineraryContractResponse)
                .toList();
    }

    public List<BusItineraryContractResponse> searchBusLineByCoordinate(BusLineCoordinateContractRequest busLineCoordinateContractRequest) {
        return busService.searchBusLineByCoordinate(
                BusLineContractMapper.toBusLineCoordinateImplRequest(busLineCoordinateContractRequest)).stream()
                .map(BusLineContractMapper::toBusLineItineraryContractResponse)
                .toList();
    }
}
