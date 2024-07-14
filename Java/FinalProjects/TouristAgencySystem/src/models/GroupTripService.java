// src/models/GroupTripService.java

package models;

import java.util.Date;
import java.util.List;

public class GroupTripService {
    private String tripName;
    private List<Customer> participants;
    private Date tripDate;
    private double pricePerPerson;
    private String destination;

    // Constructor
    public GroupTripService(String tripName, List<Customer> participants, Date tripDate, double pricePerPerson, String destination) {
        this.tripName = tripName;
        this.participants = participants;
        this.tripDate = tripDate;
        this.pricePerPerson = pricePerPerson;
        this.destination = destination;
    }

    // Getters and Setters
    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public List<Customer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Customer> participants) {
        this.participants = participants;
    }

    public Date getTripDate() {
        return tripDate;
    }

    public void setTripDate(Date tripDate) {
        this.tripDate = tripDate;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "GroupTripService{" +
                "tripName='" + tripName + '\'' +
                ", participants=" + participants +
                ", tripDate=" + tripDate +
                ", pricePerPerson=" + pricePerPerson +
                ", destination='" + destination + '\'' +
                '}';
    }
}
