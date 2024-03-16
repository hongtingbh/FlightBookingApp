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

import com.otu.FlightBookingApp.model.User;

@Controller
public class FlightBookingAppController {
    String responseBody = "";
    @GetMapping("/")
    public String index(Model model) {
        
        model.addAttribute("user", new User("John")); // Add a user object to the model
        model.addAttribute("user2", new User("Billy")); // Add a user object to the model
        return "index";
    }

    @PostMapping("/")
    public void handleFormSubmission(@RequestParam String departingCity, @RequestParam String arrivingCity) {
        HttpClient httpClient = HttpClients.createDefault();
        String apiKey = "ecefaae728f585b8f05760bb13a7168b2fd5e9aeb00a15e09830989fb37b4148";
        String departureDate = "2024-03-20";
        String arrivalDate = "2024-03-25";
        
        // Process the form data
        System.out.println("Departing City: " + departingCity);
        System.out.println("Arriving City: " + arrivingCity);
        // Construct the URL with departure date and arrival date parameters
        String url = "https://serpapi.com/search?q=flights+from+"
                    + departingCity + "+to+" + arrivingCity
                    + "&departure_date=" + departureDate
                    + "&return_date=" + arrivalDate
                    + "&api_key=" + apiKey;
        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            // Check if the request was successful
            if (response.getStatusLine().getStatusCode() == 200) {
                responseBody = EntityUtils.toString(response.getEntity());
                // System.out.println(responseBody); // Print the response body (JSON)

                // Write the response to a file
                String filePath = "response.txt";
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
                    writer.write(responseBody);
                    
                }
            } else {
                System.err.println("Request failed with status code: " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Redirect to a success page or return a view name
        
    }

    @GetMapping("/submitForm")
    public String handleAnotherRequest(Model model) {
        // Call the showData method from the other controller
        String viewName = showData(model);

        // Use the returned view name or handle the result as needed
        return viewName;
    }

    // This method can be called from other controller methods
    public String showData(Model model) {
        // Add data to the model
        model.addAttribute("message", "Hello, world!");
        model.addAttribute("number", 42);

        // Return the view name
        return "showDataView"; // This corresponds to a view named "showDataView.html"
    }
}
