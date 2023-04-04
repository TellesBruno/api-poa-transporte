package com.telles.bruno.apipoatransporte.apipoatransport.bus_line;

import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.facade.BusLineFacade;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusItineraryContractRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusLineContractResponse;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusItineraryContractResponse;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.model.BusLineCoordinateContractRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/buslines")
@Tag(name = "Bus Lines", description = "API Poa Transport Bus Lines")
public class BusLineController {

    BusLineFacade busLineFacade;

    @GetMapping()
    @Operation(method = "GET",
            description = "Get all bus lines from Porto Alegre transport API",
            summary = "Get all bus lines",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus lines found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusLineContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus lines not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json")),
    })
    public List<BusLineContractResponse> getBusLines() {
        return busLineFacade.getBusLines();
    }

    @GetMapping("/{id}")
    @Operation(method = "GET",
            description = "Get bus line by id from Porto Alegre transport API",
            summary = "Get bus line by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus line found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusLineContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus line not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public BusLineContractResponse getBusLineById(@PathVariable("id") int id) {
        return busLineFacade.getBusLineById(id);
    }

    @GetMapping("/{id}/itinerary")
    @Operation(method = "GET",
            description = "Get bus line itinerary by id from Porto Alegre transport API",
            summary = "Get bus line itinerary by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus line itinerary found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusItineraryContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus line itinerary not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public BusItineraryContractResponse getBusLineItinerary(@PathVariable("id") int id) {
        return busLineFacade.getBusLineItinerary(id);
    }

    @GetMapping("/search/by-name")
    @Operation(method = "GET",
            description = "Search bus line by name from Porto Alegre transport API",
            summary = "Search bus line by name",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus line found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusLineContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus line not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public List<BusLineContractResponse> searchBusLineByName(@RequestParam(name = "name") String name) {
        return busLineFacade.searchBusLineByName(name);
    }

    @PostMapping("/register/create")
    @Operation(method = "POST",
            description = "Create bus line in poatransport database",
            summary = "Create bus line",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Bus line created"),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public void createBusLine(@RequestBody BusItineraryContractRequest busItineraryContractRequest) {
        busLineFacade.createBusLine(busItineraryContractRequest);
    }

    @GetMapping("/register/find")
    @Operation(method = "GET",
            description = "Find bus line in poatransport database",
            summary = "Find bus line",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus line found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusItineraryContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus line not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public BusItineraryContractResponse findBusItineraryById(@RequestParam(name = "id") int id) {
        return busLineFacade.findBusItineraryById(id);
    }

    @GetMapping("/register/find/all")
    @Operation(method = "GET",
            description = "Find all bus lines in poatransport database",
            summary = "Find all bus lines",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus lines found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusItineraryContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus lines not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public List<BusItineraryContractResponse> findAllBusItineraries() {
        return busLineFacade.findAllBusItineraries();
    }

    @GetMapping("/register/find/by-name")
    @Operation(method = "GET",
            description = "Find bus line by name in poatransport database",
            summary = "Find bus line by name",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus line found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusItineraryContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus line not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public List<BusItineraryContractResponse> findBusItineraryByName(@RequestParam(name = "name") String name) {
        return busLineFacade.findBusItineraryByName(name);
    }

    @PatchMapping("/register/update")
    @Operation(method = "PATCH",
            description = "Update bus line in poatransport database",
            summary = "Update bus line",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Bus line updated"),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public void updateBusLine(@RequestBody BusItineraryContractRequest busItineraryContractRequest) {
        busLineFacade.updateBusLine(busItineraryContractRequest);
    }

    @DeleteMapping("/register/delete")
    @Operation(method = "DELETE",
            description = "Delete bus line in poatransport database",
            summary = "Delete bus line",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Bus line deleted"),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public void deleteBusLineById(@RequestParam(name = "id") int id) {
        busLineFacade.deleteBusLine(id);
    }

    @GetMapping("/register/search/coordinate")
    @Operation(method = "GET",
            description = "Search bus lines by geographic coordinate and radius in kilometers on poatransport database",
            summary = "Search bus line by coordinate",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Bus lines found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BusItineraryContractResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Bus line not found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal server error",
                            content = @Content(mediaType = "application/json"))
    })
    public List<BusItineraryContractResponse> searchBusLineByCoordinate(@RequestBody BusLineCoordinateContractRequest busLineCoordinateContractRequest) {
        return busLineFacade.searchBusLineByCoordinate(busLineCoordinateContractRequest);
    }
}
