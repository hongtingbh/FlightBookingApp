package com.otu.FlightBookingApp;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.otu.FlightBookingApp.model.User;
import com.otu.FlightBookingApp.model.Flight;
import com.otu.FlightBookingApp.model.Leg;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class FlightBookingAppController {
    //Gets usernames
    List<Flight> flightsList = new ArrayList<>();
    @GetMapping("/")
    public String index(Model model) {
        
        model.addAttribute("user", new User("John")); // Add a user object to the model
        model.addAttribute("user2", new User("Billy")); // Add a user object to the model
        return "index";
    }

    public String convertMinToHrAndMin(int minutes) {
        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;
        return hours + "h " + remainingMinutes + "m";
    }

    public static String convertTo12HourTime(String inputTime) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = inputFormat.parse(inputTime);

            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
            return outputFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid input format";
        }
    }

    @PostMapping("/submitForm")
    public String handleFormSubmission(@RequestParam String departingCity, @RequestParam String departureDate, 
    @RequestParam String arrivingCity, @RequestParam String returnDate, @RequestParam String flightType,
    @RequestParam String numOfStops, @RequestParam Boolean useConvert) {
        HttpClient httpClient = HttpClients.createDefault();
        String apiKey = "ecefaae728f585b8f05760bb13a7168b2fd5e9aeb00a15e09830989fb37b4148";
        // Boolean useConvert = true;
        departureDate = "2024-04-30";
        returnDate = "2024-05-30";
        
        // Construct the URL with departure date and arrival date parameters
        String url = "https://serpapi.com/search.json?engine=google_flights"
                    + "&departure_id=" + departingCity 
                    + "&arrival_id=" + arrivingCity
                    + "&type=" + flightType
                    + "&outbound_date=" + departureDate
                    + "&return_date=" + returnDate
                    + "&stops=" + numOfStops
                    + "&api_key=" + apiKey;
        System.out.println(url);
        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            // Check if the request was successful
            if (response.getStatusLine().getStatusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode responseBodyJson = objectMapper.readTree(EntityUtils.toString(response.getEntity()));
                JsonNode bestFlights = responseBodyJson.get("best_flights");
                // String flights = bestFlights.get(0).get("flights").get(0).get("departure_airport").get("id").asText();
                
                
                for (JsonNode flightNode : bestFlights) {
                    Flight flight = new Flight();
                    flight.setTotalDuration(convertMinToHrAndMin(flightNode.get("total_duration").asInt()));
                    flight.setPrice(flightNode.get("price").asInt());
                    flight.setType(flightNode.get("type").asText());
                    List<Leg> legsList = new ArrayList<>();
                    JsonNode flightLeg = flightNode.get("flights"); // Extract flight details
                    for (JsonNode legNode : flightLeg) {
                        Leg leg = new Leg();
                        leg.setFlightNumber(legNode.get("flight_number").asText());
                        leg.setAirline(legNode.get("airline").asText());
                        leg.setAirplane(legNode.get("airplane").asText());
                        leg.setDuration(convertMinToHrAndMin(legNode.get("duration").asInt()));
                        leg.setDepartureAirportName(legNode.get("departure_airport").get("name").asText());
                        leg.setDepartureAirportCode(legNode.get("departure_airport").get("id").asText());
                        leg.setDepartureTime(useConvert ? convertTo12HourTime(legNode.get("departure_airport").get("time").asText()) : legNode.get("departure_airport").get("time").asText());
                        leg.setArrivalAirportName(legNode.get("arrival_airport").get("name").asText());
                        leg.setArrivalAirportCode(legNode.get("arrival_airport").get("id").asText());
                        leg.setArrivalTime(legNode.get("arrival_airport").get("time").asText());
                        legsList.add(leg);
                    }
                    flight.setLegs(legsList);
                    flightsList.add(flight);
                }

                
                // // Write the response to a file
                // String filePath = "response.txt";
                // try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
                //     writer.write(EntityUtils.toString(response.getEntity()));
                    
                // }
            } else {
                System.err.println("Request failed with status code: " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Redirect to a success page or return a view name
        return "redirect:/showData";
    }

    @GetMapping("/showData")
    // This method can be called from other controller methods
    public String showData(Model model) {
        model.addAttribute("flightsList", flightsList);
        // Return the view name
        return "showDataView"; // This corresponds to a view named "showDataView.html"
    }
}
