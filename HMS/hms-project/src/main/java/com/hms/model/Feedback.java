package com.hms.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private final String patientId;
    private final String staffId;
    private final String staffRole;
    private final String description;
    private final LocalDate date;
    private boolean isRead;

    public Feedback(String id, String patientId, String staffId, String staffRole, String description) {
        this.id = id;
        this.patientId = patientId;
        this.staffId = staffId;
        this.staffRole = staffRole;
        this.description = description;
        this.date = LocalDate.now();
        this.isRead = false;
    }

    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public String getStaffId() { return staffId; }
    public String getStaffRole() { return staffRole; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }
    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
}