package com.isc.TrackZillaMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.isc")
public class ApplicationCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCatalogApplication.class, args);
	}

}
