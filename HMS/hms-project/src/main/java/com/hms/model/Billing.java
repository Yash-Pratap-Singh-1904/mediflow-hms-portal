package com.hms.model;

import java.io.Serializable;

public class Billing implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String invoiceId;
    private final String patientId;
    private final String prescriptionId;
    private final double medicineTotal;
    private final double labTotal;
    private final double subtotal;
    private final double discountAmount;
    private final double finalTotal;
    private boolean isPaid;

    public Billing(String invoiceId, String patientId, String prescriptionId, double medicineTotal, 
                   double labTotal, double discountAmount, double finalTotal) {
        this.invoiceId = invoiceId;
        this.patientId = patientId;
        this.prescriptionId = prescriptionId;
        this.medicineTotal = medicineTotal;
        this.labTotal = labTotal;
        this.subtotal = medicineTotal + labTotal;
        this.discountAmount = discountAmount;
        this.finalTotal = finalTotal;
        this.isPaid = false;
    }

    public String getInvoiceId() { return invoiceId; }
    public String getPatientId() { return patientId; }
    public String getPrescriptionId() { return prescriptionId; }
    public double getMedicineTotal() { return medicineTotal; }
    public double getLabTotal() { return labTotal; }
    public double getSubtotal() { return subtotal; }
    public double getDiscountAmount() { return discountAmount; }
    public double getFinalTotal() { return finalTotal; }
    public boolean isPaid() { return isPaid; }
    public void setPaid(boolean paid) { isPaid = paid; }
}