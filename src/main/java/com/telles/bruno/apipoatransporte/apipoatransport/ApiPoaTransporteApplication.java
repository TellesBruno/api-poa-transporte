package com.telles.bruno.apipoatransporte.apipoatransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.telles.bruno.apipoatransporte.apipoatransport.repository")
public class ApiPoaTransporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPoaTransporteApplication.class, args);
	}

}
