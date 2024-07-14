// src/models/SpecialOffer.java

package models;

import java.util.Date;

public class SpecialOffer {
    private String offerName;
    private String description;
    private double discount;
    private Date startDate;
    private Date endDate;

    // Constructor
    public SpecialOffer(String offerName, String description, double discount, Date startDate, Date endDate) {
        this.offerName = offerName;
        this.description = description;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "SpecialOffer{" +
                "offerName='" + offerName + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
