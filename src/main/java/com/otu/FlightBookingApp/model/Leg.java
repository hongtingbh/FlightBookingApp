package com.otu.FlightBookingApp.model;

public class Leg {
    private String flightNumber;
    private String airline;
    private String airplane;
    private String duration;
    private String departureAirportName;
    private String departureAirportCode;
    private String departureTime;
    private String arrivalAirportName;
    private String arrivalAirportCode;
    private String arrivalTime;

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDepartureAirportName(String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalAirportName(String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getAirplane() {
        return airplane;
    }

    public String getDuration() {
        return duration;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
}
