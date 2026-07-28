package com.hms.model;

import java.io.Serializable;

public class LabReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String reportId;
    private final String patientId;
    private final String referringDoctorId;
    private final LabSpecialization labType;
    private String assignedSpecialistId;
    private double testPrice;
    private String results;
    private String status; // PENDING, IN_PROGRESS, COMPLETED

    public LabReport(String reportId, String patientId, String referringDoctorId, LabSpecialization labType, double testPrice) {
        this.reportId = reportId;
        this.patientId = patientId;
        this.referringDoctorId = referringDoctorId;
        this.labType = labType;
        this.testPrice = testPrice;
        this.results = "Pending Examination";
        this.status = "PENDING";
    }

    public String getReportId() { return reportId; }
    public String getPatientId() { return patientId; }
    public String getReferringDoctorId() { return referringDoctorId; }
    public LabSpecialization getLabType() { return labType; }
    public String getAssignedSpecialistId() { return assignedSpecialistId; }
    public void setAssignedSpecialistId(String assignedSpecialistId) { this.assignedSpecialistId = assignedSpecialistId; }
    public double getTestPrice() { return testPrice; }
    public String getResults() { return results; }
    public void setResults(String results) { this.results = results; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}