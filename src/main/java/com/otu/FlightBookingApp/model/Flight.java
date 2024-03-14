package com.otu.FlightBookingApp.model;
import java.util.List;
import java.time.LocalDateTime;


public class Flight {
    private String flightNumber;
    private List<String> airports; // List of airports in the itinerary
    private List<Integer> layoverDurations; // List of layover durations in minutes
    private List<Integer> flightDurations; // List of flight durations in minutes
    private List<LocalDateTime> departureTimes; // List of departure times for each leg
    private List<LocalDateTime> arrivalTimes; // List of arrival times for each leg
    // Constructor, getters, and setters
    public Flight(String departureAirport, String arrivalAirport, double duration) {
        
    }
    
}
