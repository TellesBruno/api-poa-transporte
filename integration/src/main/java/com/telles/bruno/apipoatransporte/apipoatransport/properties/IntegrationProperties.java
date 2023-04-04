package com.telles.bruno.apipoatransporte.apipoatransport.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class IntegrationProperties {
    @Value("${url.base.api-poa-url}")
    private String apiPoaBaseUrl;

    @Value("${bus-line.path.get-all}")
    private String getAllPath;

    @Value("${bus-line.path.get-itinerary-by-id}")
    private String getItineraryByIdPath;

    @Value("${spring.datasource.url}")
    private String getDataSourceUrl;

    @Value("${spring.datasource.username}")
    private String getDataSourceUsername;

    @Value("${spring.datasource.password}")
    private String getDataSourcePassword;

    @Value("${taxi.path.taxi-stops}")
    private String getTaxiStopsPath;
}
