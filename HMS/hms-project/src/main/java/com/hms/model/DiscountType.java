package com.hms.model;

public enum DiscountType {
    NONE(0.00), STUDENT(0.10), TEACHER(0.15), SENIOR_CITIZEN(0.20);

    private final double rate;

    DiscountType(double rate) { this.rate = rate; }
    public double getRate() { return rate; }
}