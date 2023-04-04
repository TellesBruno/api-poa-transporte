package com.telles.bruno.apipoatransporte.apipoatransport.bus_line;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.mapper.BusLineImplMapper;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.Double.parseDouble;

@Service
@AllArgsConstructor
public class BusLineService {

    BusLineIntegration busLineIntegration;

    public List<BusLineImplResponse> getAllBusLines() {
        BusLineImplResponse[] busLineRestResponses = new Gson().fromJson(
                busLineIntegration.getAllBusLines(),
                BusLineImplResponse[].class);

        return Arrays.stream(busLineRestResponses).toList();
    }

    public BusLineImplResponse getBusLineById(int id) {
        return getAllBusLines().stream()
                .filter(busLine -> busLine.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Bus line not found"));
    }
    public BusItineraryImplResponse getBusLineItinerary(int id) {
        Gson gson = new Gson();
        var busLineItineraryResponse = busLineIntegration.getBusLineItinerary(id);

        BusItineraryImplResponse busItinerary = gson.fromJson(
                busLineItineraryResponse,
                BusItineraryImplResponse.class);
        JsonObject itineraryCoordinates = gson.fromJson(busLineItineraryResponse, JsonObject.class);
        itineraryCoordinates.remove("idlinha");
        itineraryCoordinates.remove("nome");
        itineraryCoordinates.remove("codigo");

        Map<String, BusStopImplResponse> finalBusItinerary = new LinkedTreeMap<>();
        itineraryCoordinates.entrySet().forEach(entry -> {
            BusStopImplResponse itineraryResponse = gson.fromJson(entry.getValue(), BusStopImplResponse.class);
            finalBusItinerary.put(entry.getKey(), itineraryResponse);
        });

        busItinerary.setItinerary(finalBusItinerary);
        return busItinerary;
    }

    public List<BusLineImplResponse> searchBusLineByName(String name) {
        return getAllBusLines().stream()
                .filter(busLine -> busLine.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public void createBusLine(BusItineraryImplRequest busItineraryImplRequest) {
        busLineIntegration.createBusLine(BusLineImplMapper.toBusItineraryIntegrationRequest(busItineraryImplRequest));
    }

    public BusItineraryImplResponse findBusItineraryById(int id) {
        return BusLineImplMapper.toBusItineraryImplResponse(busLineIntegration.findBusItineraryById((long)id));
    }

    public void deleteBusLineById(int id) {
        busLineIntegration.deleteBusLineById((long)id);
    }

    public void updateBusLine(BusItineraryImplRequest busLineItineraryImplRequest) {
        busLineIntegration.updateBusLine(BusLineImplMapper.toBusItineraryIntegrationRequest(busLineItineraryImplRequest));
    }

    public List<BusItineraryImplResponse> findAllBusItineraries() {
        return busLineIntegration.findAllBusItineraries().stream()
                .map(BusLineImplMapper::toBusItineraryImplResponse)
                .toList();
    }

    public List<BusItineraryImplResponse> findBusItineraryByName(String name) {
        return findAllBusItineraries().stream()
                .filter(busLine -> busLine.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public List<BusItineraryImplResponse> searchBusLineByCoordinate(BusLineCoordinateImplRequest busLineCoordinateImplRequest) {
        Map<String, Double> range = calculateRange(busLineCoordinateImplRequest.getRadius(), busLineCoordinateImplRequest.getLatitude(), busLineCoordinateImplRequest.getLongitude());
        List<BusItineraryImplResponse> busLines = busLineIntegration.findAllBusItineraries().stream()
                .map(BusLineImplMapper::toBusItineraryImplResponse)
                .toList();

        return busLines.stream().filter(busLine -> busLine.getItinerary().values().stream().anyMatch(busStop -> parseDouble(busStop.getLat()) >= range.get("minLat") && parseDouble(busStop.getLat()) <= range.get("maxLat")
                && parseDouble(busStop.getLon()) >= range.get("minLon") && parseDouble(busStop.getLon()) <= range.get("maxLon"))).toList();
    }

    private static Map<String, Double> calculateRange(double radius, double lat, double lon) {
        double earthRadius = 6371;
        double latRange = Math.toDegrees(radius / earthRadius);
        double lonRange = Math.toDegrees(Math.asin(radius / earthRadius / Math.cos(Math.toRadians(lat))));

        double maxLat = lat + latRange;
        double minLat = lat - latRange;
        double maxLon = lon + lonRange;
        double minLon = lon - lonRange;

        Map<String, Double> range = new HashMap<>();
        range.put("maxLat", maxLat);
        range.put("minLat", minLat);
        range.put("maxLon", maxLon);
        range.put("minLon", minLon);

        return range;
    }
}
