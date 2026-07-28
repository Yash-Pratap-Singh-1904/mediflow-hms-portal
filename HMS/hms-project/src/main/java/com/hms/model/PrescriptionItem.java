package com.hms.model;

import java.io.Serializable;

public class PrescriptionItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String medicineName;
    private int numberOfDays;
    private int timesPerDay;
    private Double price; // Nullable; populated exclusively by Pharmacist

    public PrescriptionItem(String medicineName, int numberOfDays, int timesPerDay) {
        this.medicineName = medicineName;
        this.numberOfDays = numberOfDays;
        this.timesPerDay = timesPerDay;
        this.price = null;
    }

    public String getMedicineName() { return medicineName; }
    public int getNumberOfDays() { return numberOfDays; }
    public int getTimesPerDay() { return timesPerDay; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}