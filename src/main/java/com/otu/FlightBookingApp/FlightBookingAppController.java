package com.otu.FlightBookingApp;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

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


@Controller
public class FlightBookingAppController {
    String responseBody = "";
    String flightResults = "";
    //Gets usernames
    @GetMapping("/")
    public String index(Model model) {
        
        model.addAttribute("user", new User("John")); // Add a user object to the model
        model.addAttribute("user2", new User("Billy")); // Add a user object to the model
        return "index";
    }

    @PostMapping("/submitForm")
    public String handleFormSubmission(@RequestParam String departingCity, @RequestParam String departureDate, 
    @RequestParam String arrivingCity, @RequestParam String returnDate, @RequestParam String flightType) {
        HttpClient httpClient = HttpClients.createDefault();
        String apiKey = "ecefaae728f585b8f05760bb13a7168b2fd5e9aeb00a15e09830989fb37b4148";

        departureDate = "2024-04-20";
        returnDate = "2024-04-25";
        
        // Process the form data
        System.out.println("Departing City: " + departingCity);
        System.out.println("Arriving City: " + arrivingCity);
        // Construct the URL with departure date and arrival date parameters
        String url = "https://serpapi.com/search.json?engine=google_flights"
                    + "&departure_id=" + departingCity 
                    + "&arrival_id=" + arrivingCity
                    + "&type=" + flightType
                    + "&outbound_date=" + departureDate
                    + "&return_date=" + returnDate
                    + "&api_key=" + apiKey;
        // System.out.println(url);
        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            // Check if the request was successful
            if (response.getStatusLine().getStatusCode() == 200) {
                ObjectMapper objectMapper = new ObjectMapper();
                // responseBody = EntityUtils.toString(response.getEntity());
                JsonNode responseBodyJson = objectMapper.readTree(response.getEntity().getContent());
                JsonNode bestFlights = responseBodyJson.get("best_flights");
                JsonNode flight1 = bestFlights.get(0).get("flights");
                String flight = flight1.toString();
      
                System.out.println(flight);
                
                // // Write the response to a file
                // String filePath = "response.txt";
                // try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
                //     writer.write(responseBody);
                    
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
        // Add data to the model
        
        model.addAttribute("Response", flightResults);
        
        // Return the view name
        return "showDataView"; // This corresponds to a view named "showDataView.html"
    }
}
