package com.otu.FlightBookingApp.model;
import java.util.List;

public class Flight {
    private List<Leg> legs;
    private String totalDuration;
    private int price;
    private String type;

    // Setters
    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getters
    public List<Leg> getLegs() {
        return legs;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

}
