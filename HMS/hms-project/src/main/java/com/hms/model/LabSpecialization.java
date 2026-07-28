package com.hms.model;

public enum LabSpecialization {
    PATHOLOGY("Blood and Tissue Tests"),
    RADIOLOGY("X-ray"),
    NEURORADIOLOGY("MRI"),
    INTERVENTIONAL_RADIOLOGY("CT Scan or Ultrasound");

    private final String description;

    LabSpecialization(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }
}