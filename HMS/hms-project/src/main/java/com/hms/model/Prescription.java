package com.hms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Prescription implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String appointmentId;
    private final String doctorId;
    private final String patientId;
    private final List<PrescriptionItem> items = new ArrayList<>();
    private String status; // PENDING_PHARMACY, SENT_TO_CASHIER, COMPLETED

    public Prescription(String id, String appointmentId, String doctorId, String patientId) {
        this.id = id;
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.status = "PENDING_PHARMACY";
    }

    public String getId() { return id; }
    public String getAppointmentId() { return appointmentId; }
    public String getDoctorId() { return doctorId; }
    public String getPatientId() { return patientId; }
    public List<PrescriptionItem> getItems() { return items; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void addItem(PrescriptionItem item) { items.add(item); }
}