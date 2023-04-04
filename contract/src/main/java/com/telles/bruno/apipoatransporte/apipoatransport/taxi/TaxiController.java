package com.telles.bruno.apipoatransporte.apipoatransport.taxi;

import com.telles.bruno.apipoatransporte.apipoatransport.taxi.facade.TaxiFacade;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopContractRequest;
import com.telles.bruno.apipoatransporte.apipoatransport.taxi.model.TaxiStopContractResponse;
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
@RequestMapping("/taxi")
@Tag(name = "Taxi", description = "API Poa Transport Taxi Stops")
public class TaxiController {

    TaxiFacade taxiFacade;

    @GetMapping
    @Operation(method = "GET",
            description = "Get all taxi stops from file in disk",
            summary = "Get all taxi stops",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Taxi stops list",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaxiStopContractResponse.class))),
                    @ApiResponse(responseCode= "400", description = "Bad Request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(mediaType = "application/json")),
            })
    public List<TaxiStopContractResponse> getTaxiStops() {
        return taxiFacade.getTaxiStops();
    }

    @GetMapping("/search")
    @Operation(method = "GET",
            description = "Search taxi stops by name from file in disk",
            summary = "Search taxi stops by name",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Taxi stops list",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaxiStopContractResponse.class))),
                    @ApiResponse(responseCode= "400", description = "Bad Request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(mediaType = "application/json")),
            })
    public List<TaxiStopContractResponse> findTaxiStopsByName(@RequestParam("name") String name) {
        return taxiFacade.findTaxiStopsByName(name);
    }
    @PostMapping("/add")
    @Operation(method = "POST",
            description = "Add taxi stop to file in disk",
            summary = "Add taxi stop",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Taxi stop added",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TaxiStopContractResponse.class))),
                    @ApiResponse(responseCode= "400", description = "Bad Request",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "404", description = "Not Found",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(mediaType = "application/json")),
            })
    public void addTaxiStop(@RequestBody TaxiStopContractRequest taxiStopContractRequest) {
        taxiFacade.addTaxiStop(taxiStopContractRequest);
    }
}
