package com.hms.service;

import com.hms.exception.PrescriptionNotFoundException;
import com.hms.exception.UnauthorizedAccessException;
import com.hms.model.*;
import com.hms.repository.DataRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class PharmacyService {
    private final DataRepository repository;

    public PharmacyService(DataRepository repository) {
        this.repository = repository;
    }

    public void processCentralPrescription(User pharmacist, String prescriptionId, Map<String, Double> itemPrices) {
        // Enforce Role-Based Access Control
        SecurityService.verifyRole(pharmacist, UserRole.PHARMACIST);

        Prescription centralRx = repository.getPrescriptions().get(prescriptionId);
        if (centralRx == null) {
            throw new PrescriptionNotFoundException("Central prescription record not found: " + prescriptionId);
        }

        if (!"SENT_TO_PHARMACY".equalsIgnoreCase(centralRx.getStatus())) {
            throw new IllegalStateException("Prescription is not in SENT_TO_PHARMACY status.");
        }

        // Field-Level Modification: Update ONLY medicine prices in central record
        for (PrescriptionItem item : centralRx.getItems()) {
            Double price = itemPrices.get(item.getMedicineName());
            if (price == null || price <= 0) {
                throw new IllegalArgumentException("Invalid or missing price for medicine: " + item.getMedicineName());
            }
            item.setPrice(price);
        }

        // Update Central State & Audit Info
        centralRx.setStatus("PHARMACY_PROCESSED");
        centralRx.setProcessedByPharmacistId(pharmacist.getId());
        centralRx.setProcessedTimestamp(LocalDateTime.now());

        repository.saveState();
    }
}