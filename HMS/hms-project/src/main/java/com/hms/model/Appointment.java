package com.hms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String patientId;
    private final String doctorId;
    private final String reasonForVisit;
    private final LocalDateTime dateTime;
    private String status; // SCHEDULED, COMPLETED, CANCELLED

    public Appointment(String id, String patientId, String doctorId, String reasonForVisit, LocalDateTime dateTime) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.reasonForVisit = reasonForVisit;
        this.dateTime = dateTime;
        this.status = "SCHEDULED";
    }

    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getReasonForVisit() { return reasonForVisit; }
    public LocalDateTime getDateTime() { return dateTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}