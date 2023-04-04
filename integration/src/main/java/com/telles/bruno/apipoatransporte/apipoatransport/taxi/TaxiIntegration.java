package com.telles.bruno.apipoatransporte.apipoatransport.taxi;

import com.telles.bruno.apipoatransporte.apipoatransport.properties.IntegrationProperties;
import com.telles.bruno.apipoatransporte.apipoatransport.commons.exception.HttpSimpleException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;


@Component
@AllArgsConstructor
public class TaxiIntegration {

    IntegrationProperties integrationProperties;

    public Stream<String> readTaxiStops() {
        try {
            return Files.lines(Paths.get(integrationProperties.getGetTaxiStopsPath()));
        } catch (IOException e) {
            throw new HttpSimpleException("Error reading file", HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void addTaxiStop(String s) {
        try{
            BufferedWriter bw = Files.newBufferedWriter(Paths.get(integrationProperties.getGetTaxiStopsPath()), StandardOpenOption.APPEND);
            bw.write(s);
            bw.close();
        } catch (IOException e) {
            throw new HttpSimpleException("Error writing file", HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
