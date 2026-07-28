package com.hms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LabRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String appointmentId;
    private final String patientId;
    private final String doctorId;
    private final String department;
    private final String specialization;
    private final double testPrice;
    private String assignedSpecialistId;
    private String status; // PENDING, IN_PROGRESS, COMPLETED

    public LabRequest(String id, String appointmentId, String patientId, String doctorId, 
                      String department, String specialization, double testPrice) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.department = department;
        this.specialization = specialization;
        this.testPrice = testPrice;
        this.status = "PENDING";
    }

    public String getId() { return id; }
    public String getAppointmentId() { return appointmentId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getDepartment() { return department; }
    public String getSpecialization() { return specialization; }
    public double getTestPrice() { return testPrice; }
    public String getAssignedSpecialistId() { return assignedSpecialistId; }
    public void setAssignedSpecialistId(String assignedSpecialistId) { this.assignedSpecialistId = assignedSpecialistId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}