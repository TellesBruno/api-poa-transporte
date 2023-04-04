package com.telles.bruno.apipoatransporte.apipoatransport.bus_line;

import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusItineraryEntity;
import com.telles.bruno.apipoatransporte.apipoatransport.properties.IntegrationProperties;
import com.telles.bruno.apipoatransporte.apipoatransport.repository.PoaTransportRepository;
import com.telles.bruno.apipoatransporte.apipoatransport.commons.exception.HttpSimpleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class BusLineIntegration {

    @Autowired
    private final PoaTransportRepository poaTransportRepository;

    private static final String BUS_LINE_NOT_FOUND = "Bus line not found";

    IntegrationProperties integrationProperties;

    public BusLineIntegration(PoaTransportRepository poaTransportRepository, IntegrationProperties integrationProperties) {
        this.poaTransportRepository = poaTransportRepository;
        this.integrationProperties = integrationProperties;
    }
    public String getAllBusLines() {
        return new RestTemplate().getForObject(
                uriBuilder(integrationProperties.getGetAllPath()),
                String.class);
    }

    public String getBusLineItinerary(int id) {
        return new RestTemplate().getForObject(
                uriBuilder(integrationProperties.getGetItineraryByIdPath())+id,
                String.class);
    }

    private String uriBuilder(String path) {
        return integrationProperties.getApiPoaBaseUrl() + path;
    }

    public void createBusLine(BusItineraryEntity busItineraryEntity) {
        try {
            if(poaTransportRepository.existsById(busItineraryEntity.getId())){
                throw new IllegalArgumentException();
            } else {
                poaTransportRepository.save(busItineraryEntity);
            }
        } catch (IllegalArgumentException e) {
            throw new HttpSimpleException(
                    "Bus line already exists",
                    400,
                    HttpStatus.BAD_REQUEST);
        }
    }

    public BusItineraryEntity findBusItineraryById(Long id) {
        return poaTransportRepository.findById(id).orElseThrow(
                () -> new HttpSimpleException(
                        BUS_LINE_NOT_FOUND,
                        404,
                        HttpStatus.NOT_FOUND));
    }

    public void deleteBusLineById(Long id) {
        poaTransportRepository.deleteById(id);
    }

    public void updateBusLine(BusItineraryEntity busItineraryIntegrationRequest) {
        try{
            if(poaTransportRepository.existsById(busItineraryIntegrationRequest.getId())){
                poaTransportRepository.save(busItineraryIntegrationRequest);
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            throw new HttpSimpleException(
                    BUS_LINE_NOT_FOUND,
                    404,
                    HttpStatus.NOT_FOUND);
        }
        poaTransportRepository.existsById(busItineraryIntegrationRequest.getId());
    }

    public List<BusItineraryEntity> findAllBusItineraries() {
        return poaTransportRepository.findAll();
    }
}
