package com.otu.FlightBookingApp;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@SpringBootApplication
public class FlightBookingApp {

	public static void main(String[] args) {
		SpringApplication.run(FlightBookingApp.class, args);
		HttpClient httpClient = HttpClients.createDefault();
        String apiKey = "ecefaae728f585b8f05760bb13a7168b2fd5e9aeb00a15e09830989fb37b4148";
        String url = "https://serpapi.com/search?q=flights+from+New+York+to+Los+Angeles&api_key=" + apiKey;

        try {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);

            // Check if the request was successful
            if (response.getStatusLine().getStatusCode() == 200) {
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println(responseBody); // Print the response body (JSON)
            } else {
                System.err.println("Request failed with status code: " + response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
