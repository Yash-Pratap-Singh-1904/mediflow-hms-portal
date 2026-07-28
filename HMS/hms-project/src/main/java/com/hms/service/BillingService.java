package com.hms.service;

import com.hms.model.*;
import com.hms.repository.DataRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class BillingService {
    private final DataRepository repository;

    public BillingService(DataRepository repository) {
        this.repository = repository;
    }

    public Bill processPayment(User cashier, String prescriptionId, PaymentMethod paymentMethod) {
        // Enforce RBAC
        SecurityService.verifyRole(cashier, UserRole.CASHIER);

        Prescription prescription = repository.getPrescriptions().get(prescriptionId);
        if (prescription == null || !"PHARMACY_PROCESSED".equalsIgnoreCase(prescription.getStatus())) {
            throw new IllegalStateException("Prescription is not ready for billing.");
        }

        Patient patient = (Patient) repository.getUsers().get(prescription.getPatientId());
        
        // 1. Total Medicine Amount
        double medicineTotal = prescription.getItems().stream()
                .mapToDouble(item -> item.getPrice() != null ? item.getPrice() : 0.0)
                .sum();

        // 2. Total Laboratory Test Amount (Looked up from central LabRequest)
        LabRequest labRequest = repository.getLabRequests().values().stream()
                .filter(l -> l.getAppointmentId().equals(prescription.getAppointmentId()))
                .findFirst()
                .orElse(null);

        double labTotal = labRequest != null ? labRequest.getTestPrice() : 0.0;

        // 3. Subtotal
        double subtotal = medicineTotal + labTotal;

        // 4. Predefined Discount Calculation
        double discountRate = 0.0;
        if (patient != null && patient.getDiscountType() != null) {
            discountRate = patient.getDiscountType().getRate();
        }
        double discountAmount = subtotal * discountRate;

        // 5. Final Bill Amount
        double finalTotal = subtotal - discountAmount;

        String billId = "BILL-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        Bill bill = new Bill(billId, patient.getId(), prescription.getAppointmentId(), prescriptionId,
                             medicineTotal, labTotal, subtotal, discountAmount, finalTotal, paymentMethod, cashier.getId());

        bill.setBillStatus(BillStatus.PAID);
        prescription.setStatus("BILLED");

        repository.getInvoices().put(billId, bill);
        repository.saveState();

        return bill;
    }
}