package com.hms.model;

public class Doctor extends User {
    private DoctorSpecialization specialization;
    private String availabilityHours;

    public Doctor(String id, String name, String contact, int age, String password, 
                  DoctorSpecialization specialization, String availabilityHours) {
        super(id, name, contact, age, password, UserRole.DOCTOR);
        this.specialization = specialization;
        this.availabilityHours = availabilityHours;
    }

    public DoctorSpecialization getSpecialization() { return specialization; }
    public String getAvailabilityHours() { return availabilityHours; }
}