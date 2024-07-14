// src/models/Reservation.java

package models;

import java.util.Date;
import java.util.List;

public class Reservation {
    private Customer customer;
    private List<Service> services;
    private Date reservationDate;
    private double totalPrice;

    // Constructor
    public Reservation(Customer customer, List<Service> services, Date reservationDate, double totalPrice) {
        this.customer = customer;
        this.services = services;
        this.reservationDate = reservationDate;
        this.totalPrice = totalPrice;
    }

    // Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", services=" + services +
                ", reservationDate=" + reservationDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
