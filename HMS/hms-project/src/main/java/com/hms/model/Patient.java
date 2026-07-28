package com.hms.model;

public class Patient extends User {
    private String address;
    private DiscountType discountType;
    private boolean firstLogin;

    public Patient(String id, String name, String contact, int age, String password, String address, DiscountType discountType) {
        super(id, name, contact, age, password, UserRole.PATIENT);
        this.address = address;
        this.discountType = discountType != null ? discountType : DiscountType.NONE;
        this.firstLogin = true; // Set firstLogin to true on account creation
    }

    public String getAddress() { return address; }
    public DiscountType getDiscountType() { return discountType; }
    public void setDiscountType(DiscountType discountType) { this.discountType = discountType; }
    
    public boolean isFirstLogin() { return firstLogin; }
    public void setFirstLogin(boolean firstLogin) { this.firstLogin = firstLogin; }
}