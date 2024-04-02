package com.otu.FlightBookingApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
public class FlightBookingApp {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException  {
		SpringApplication.run(FlightBookingApp.class, args);
        
	}

}
