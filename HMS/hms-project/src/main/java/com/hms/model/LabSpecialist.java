package com.hms.model;

public class LabSpecialist extends User {
    private String department;
    private LabSpecialization specialization;
    private String availabilityHours;

    public LabSpecialist(String id, String name, String contact, int age, String password, 
                         String department, LabSpecialization specialization, String availabilityHours) {
        super(id, name, contact, age, password, UserRole.LABORATORY_SPECIALIST);
                         LabSpecialization specialization, String availabilityHours) {
        super(id, name, contact, age, password, UserRole.LABORATORY_SPECIALIST); // department was missing here
        this.department = department;
        this.specialization = specialization;
        this.availabilityHours = availabilityHours;
    }

    public String getDepartment() { return department; }
    public LabSpecialization getSpecialization() { return specialization; }
    public String getAvailabilityHours() { return availabilityHours; }
}