package com.otu.FlightBookingApp.model;
import java.time.LocalDateTime;
import java.util.List;

public class Flight {
    private String flightNumber;
    private List<String> airports; // List of airports in the itinerary
    private List<Integer> layoverDurations; // List of layover durations in minutes
    private List<Integer> flightDurations; // List of flight durations in minutes
    private List<LocalDateTime> departureTimes; // List of departure times for each leg
    private List<LocalDateTime> arrivalTimes; // List of arrival times for each leg

    // Constructor, getters, and setters
    public Flight(String flightNumber, List<String> airports, List<Integer> layoverDurations,
                  List<Integer> flightDurations, List<LocalDateTime> departureTimes,
                  List<LocalDateTime> arrivalTimes) {
        this.flightNumber = flightNumber;
        this.airports = airports;
        this.layoverDurations = layoverDurations;
        this.flightDurations = flightDurations;
        this.departureTimes = departureTimes;
        this.arrivalTimes = arrivalTimes;
    }

    // Getters and setters
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public List<String> getAirports() {
        return airports;
    }

    public void setAirports(List<String> airports) {
        this.airports = airports;
    }

    public List<Integer> getLayoverDurations() {
        return layoverDurations;
    }

    public void setLayoverDurations(List<Integer> layoverDurations) {
        this.layoverDurations = layoverDurations;
    }

    public List<Integer> getFlightDurations() {
        return flightDurations;
    }

    public void setFlightDurations(List<Integer> flightDurations) {
        this.flightDurations = flightDurations;
    }

    public List<LocalDateTime> getDepartureTimes() {
        return departureTimes;
    }

    public void setDepartureTimes(List<LocalDateTime> departureTimes) {
        this.departureTimes = departureTimes;
    }

    public List<LocalDateTime> getArrivalTimes() {
        return arrivalTimes;
    }

    public void setArrivalTimes(List<LocalDateTime> arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
    }
}
