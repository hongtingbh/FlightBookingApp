package com.otu.FlightBookingApp;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.ModelAndView;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootApplication
public class FlightBookingApp {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException  {
		SpringApplication.run(FlightBookingApp.class, args);
	// 	String jsonString = "[{\"departure_airport\":{\"name\":\"Toronto Pearson International Airport\",\"id\":\"YYZ\",\"time\":\"2024-04-20 10:00\"},\"arrival_airport\":{\"name\":\"Dulles International Airport\",\"id\":\"IAD\",\"time\":\"2024-04-20 11:37\"},\"duration\":97,\"airplane\":\"Embraer 175\",\"airline\":\"United\",\"airline_logo\":\"https://www.gstatic.com/flights/airline_logos/70px/UA.png\",\"travel_class\":\"Economy\",\"flight_number\":\"UA 3416\",\"legroom\":\"31 in\",\"extensions\":[\"Average legroom (31 in)\",\"Wi-Fi for a fee\",\"Stream media to your device\",\"Carbon emissions estimate: 96 kg\"]},{\"departure_airport\":{\"name\":\"Dulles International Airport\",\"id\":\"IAD\",\"time\":\"2024-04-20 12:25\"},\"arrival_airport\":{\"name\":\"Haneda Airport\",\"id\":\"HND\",\"time\":\"2024-04-21 15:25\"},\"duration\":840,\"airplane\":\"Boeing 777\",\"airline\":\"United\",\"airline_logo\":\"https://www.gstatic.com/flights/airline_logos/70px/UA.png\",\"travel_class\":\"Economy\",\"flight_number\":\"UA 803\",\"legroom\":\"31 in\",\"extensions\":[\"Average legroom (31 in)\",\"Wi-Fi for a fee\",\"In-seat power & USB outlets\",\"On-demand video\",\"Carbon emissions estimate: 998 kg\"]}]";

        
  //   ObjectMapper mapper = new ObjectMapper();
  //   JsonNode flightsNode = mapper.readTree(jsonString);

    // Iterate through each flight
    // for (JsonNode flightNode : flightsNode) {
    //   // Extract departure airport details
    //   JsonNode departureAirportNode = flightNode.get("departure_airport");
    //   System.out.println(departureAirportNode.get("name").asText());
    //   // String departureAirportId = departureAirportNode.get("id").asText();
    //   // String departureAirportTime = departureAirportNode.get("time").asText();
    // }
          
	}

}
