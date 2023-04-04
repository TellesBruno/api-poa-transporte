package com.telles.bruno.apipoatransporte.apipoatransport.bus_line;

import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.facade.BusLineFacade;
import com.telles.bruno.apipoatransporte.apipoatransport.bus_line.stub.BusLineContractStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class BusLineControllerTest {

    @Mock
    BusLineFacade busLineFacade;

    @InjectMocks
    BusLineController busLineController;

    @Test
    void shouldReturnAllBusLines() {
        final var stubResponse = BusLineContractStub.listOfBusLineContractResponse();

        Mockito.when(busLineFacade.getBusLines()).thenReturn(stubResponse);

        assertThat(busLineController.getBusLines()).isEqualTo(stubResponse);
    }

    @Test
    void shouldReturnBusLineById() {
        final var stubResponse = BusLineContractStub.listOfBusLineContractResponse().get(0);

        Mockito.when(busLineFacade.getBusLineById(1)).thenReturn(stubResponse);

        assertThat(busLineController.getBusLineById(1)).isEqualTo(stubResponse);
    }

    @Test
    void shouldReturnBusLinesByName() {
        final var stubResponse = BusLineContractStub.listOfBusLineContractResponse();

        Mockito.when(busLineFacade.searchBusLineByName("TESTE")).thenReturn(stubResponse);

        assertThat(busLineController.searchBusLineByName("TESTE")).isEqualTo(stubResponse);
    }

    @Test
    void shouldReturnBusLineItinerary() {
        final var stubResponse = BusLineContractStub.busItineraryContractResponse();

        Mockito.when(busLineFacade.getBusLineItinerary(1)).thenReturn(stubResponse);

        assertThat(busLineController.getBusLineItinerary(1)).isEqualTo(stubResponse);
    }

    @Test
    void shouldCreateBusLineInDatabase() {
        final var stubRequest = BusLineContractStub.busItineraryContractRequest();

        busLineController.createBusLine(stubRequest);

        Mockito.verify(busLineFacade, Mockito.times(1)).createBusLine(stubRequest);
    }

    @Test
    void shouldFindBusLineInDatabaseByName() {
        final var stubResponse = BusLineContractStub.listOfBusItineraryContractResponse();

        Mockito.when(busLineFacade.findBusItineraryByName("TESTE")).thenReturn(stubResponse);

        assertThat(busLineController.findBusItineraryByName("TESTE")).isEqualTo(stubResponse);
    }

    @Test
    void shouldFindBusLineInDatabaseById() {
        final var stubResponse = BusLineContractStub.busItineraryContractResponse();

        Mockito.when(busLineFacade.findBusItineraryById(1)).thenReturn(stubResponse);

        assertThat(busLineController.findBusItineraryById(1)).isEqualTo(stubResponse);
    }

    @Test
    void shouldReturnAllBusLinesInDatabase() {
        final var stubResponse = BusLineContractStub.listOfBusItineraryContractResponse();

        Mockito.when(busLineFacade.findAllBusItineraries()).thenReturn(stubResponse);

        assertThat(busLineController.findAllBusItineraries()).isEqualTo(stubResponse);
    }

    @Test
    void shouldUpdateBusLineInDatabase() {
        final var stubRequest = BusLineContractStub.busItineraryContractRequest();

        busLineController.updateBusLine(stubRequest);

        Mockito.verify(busLineFacade, Mockito.times(1)).updateBusLine(stubRequest);
    }

    @Test
    void shouldDeleteBusLineInDatabase() {
        busLineController.deleteBusLineById(1);

        Mockito.verify(busLineFacade, Mockito.times(1)).deleteBusLine(1);
    }

    @Test
    void shouldReturnBusLineInDatabaseByCoordinates() {
        final var stubResponse = BusLineContractStub.listOfBusItineraryContractResponse();
        final var stubRequest = BusLineContractStub.busLineCoordinateContractRequest();

        Mockito.when(busLineFacade.searchBusLineByCoordinate(stubRequest)).thenReturn(stubResponse);

        assertThat(busLineController.searchBusLineByCoordinate(stubRequest)).isEqualTo(stubResponse);
    }
}
