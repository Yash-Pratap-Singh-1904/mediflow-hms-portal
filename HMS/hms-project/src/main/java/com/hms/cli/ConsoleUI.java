package com.hms.cli;

import com.hms.model.*;
import com.hms.repository.DataRepository;
import com.hms.service.*;

//import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class ConsoleUI {
    private final DataRepository repository;
    private final PharmacyService pharmacyService;
    private final LabService labService;
    private final PatientService patientService;
    private final BillingService billingService;
    private final Scanner scanner;

    private User currentUser;

    public ConsoleUI(DataRepository repository) {
        this.repository = repository;
        this.pharmacyService = new PharmacyService(repository);
        this.labService = new LabService(repository);
        this.patientService = new PatientService(repository);
        this.billingService = new BillingService(repository);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=============================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM (ENTERPRISE)   ");
            System.out.println("=============================================");
            System.out.println("1. Login Session");
            System.out.println("2. Exit");
            int choice = CLIUtils.readInt(scanner, "Select choice: ");

            if (choice == 1) {
                loginSession();
            } else if (choice == 2) {
                repository.saveState();
                System.out.println("State synchronized. Terminating process.");
                break;
            }
        }
    }

    private void loginSession() {
        String userId = CLIUtils.readString(scanner, "Enter User ID (e.g. ADM01, P101, D201, REC301, LAB401, PH501, C601): ");
        String password = CLIUtils.readString(scanner, "Enter Password: ");

        User user = repository.getUsers().get(userId);
        if (user == null || !user.validatePassword(password)) {
            System.out.println("Authentication Failed: Invalid ID or Password.");
            return;
        }

        this.currentUser = user;
        System.out.println("Session Established. Authenticated: " + currentUser.getName() + " [" + currentUser.getRole() + "]");

        switch (currentUser.getRole()) {
            case ADMIN -> System.out.println("Admin Portal active. Use Web UI for full admin capabilities.");
            case PATIENT -> handlePatientMenu();
            case DOCTOR -> handleDoctorMenu();
            case RECEPTIONIST -> handleReceptionistMenu();
            case PHARMACIST -> handlePharmacistMenu();
            case LABORATORY_SPECIALIST -> handleLabMenu();
            case CASHIER -> handleCashierMenu();
        }
    }

    private void handlePatientMenu() {
        System.out.println("\n--- Patient Portal ---");
        System.out.println("1. View My Prescriptions");
        System.out.println("2. View My Lab Reports");
        System.out.println("3. View My Invoices");
        int choice = CLIUtils.readInt(scanner, "Action: ");

        if (choice == 1) {
            var list = patientService.viewPrescriptions(currentUser.getId());
            list.forEach(p -> System.out.println("Rx ID: " + p.getId() + " | Status: " + p.getStatus()));
        } else if (choice == 2) {
            var list = patientService.viewLabReports(currentUser.getId());
            list.forEach(r -> System.out.println("Report ID: " + r.getReportId() + " | Outcome: " + r.getResults()));
        } else if (choice == 3) {
            var list = patientService.viewBilling(currentUser.getId());
            list.forEach(b -> System.out.println("Invoice ID: " + b.getInvoiceId() + " | Total: $" + b.getFinalTotal()));
        }
    }

    private void handleDoctorMenu() {
        System.out.println("\n--- Doctor Hub ---");
        System.out.println("1. Create Prescription");
        System.out.println("2. Order Lab Test");
        int choice = CLIUtils.readInt(scanner, "Action: ");

        if (choice == 1) {
            String pid = CLIUtils.readString(scanner, "Patient ID: ");
            String medName = CLIUtils.readString(scanner, "Medicine Name: ");
            int days = CLIUtils.readInt(scanner, "Days: ");
            int times = CLIUtils.readInt(scanner, "Times per day: ");

            String rxId = "RX-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
            Prescription rx = new Prescription(rxId, "APT-101", currentUser.getId(), pid);
            rx.addItem(new PrescriptionItem(medName, days, times));
            repository.getPrescriptions().put(rxId, rx);
            repository.saveState();
            System.out.println("Prescription created and forwarded to Pharmacy: " + rxId);
        } else if (choice == 2) {
            String pid = CLIUtils.readString(scanner, "Patient ID: ");
            double price = CLIUtils.readDouble(scanner, "Test Price: ");
            String reportId = "LAB-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
            LabReport report = new LabReport(reportId, pid, currentUser.getId(), LabSpecialization.RADIOLOGY, price);
            repository.getLabReports().put(reportId, report);
            repository.saveState();
            System.out.println("Lab Request Created: " + reportId);
        }
    }

    private void handleReceptionistMenu() {
        System.out.println("\n--- Reception Console ---");
        String name = CLIUtils.readString(scanner, "Patient Name: ");
        String contact = CLIUtils.readString(scanner, "Contact: ");
        int age = CLIUtils.readInt(scanner, "Age: ");
        String pass = CLIUtils.readString(scanner, "Set Password: ");
        String pid = "P" + (repository.getUsers().size() + 101);

        Patient patient = new Patient(pid, name, contact, age, pass, "123 Main St", DiscountType.NONE);
        repository.getUsers().put(pid, patient);
        repository.saveState();
        System.out.println("Patient Registered Successfully! ID: " + pid);
    }

    private void handlePharmacistMenu() {
        System.out.println("\n--- Pharmacy Console ---");
        String rxId = CLIUtils.readString(scanner, "Prescription ID to fulfill: ");
        double price = CLIUtils.readDouble(scanner, "Enter Total Medicine Price ($): ");
        try {
            pharmacyService.updateMedicinePricesAndForward(currentUser, rxId, price);
            System.out.println("Prescription priced and sent to Cashier.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void handleLabMenu() {
        System.out.println("\n--- Diagnostics Terminal ---");
        String reportId = CLIUtils.readString(scanner, "Lab Report ID: ");
        String results = CLIUtils.readString(scanner, "Enter Findings: ");
        labService.submitLabResult(currentUser, reportId, results);
        System.out.println("Lab results finalized.");
    }

    private void handleCashierMenu() {
        System.out.println("\n--- Billing Desk ---");
        String pid = CLIUtils.readString(scanner, "Patient ID: ");
        String rxId = CLIUtils.readString(scanner, "Prescription ID: ");
        double medTotal = CLIUtils.readDouble(scanner, "Medicine Total ($): ");
        double labTotal = CLIUtils.readDouble(scanner, "Lab Total ($): ");

        Billing inv = billingService.generateInvoice(currentUser, pid, rxId, medTotal, labTotal);
        System.out.println("Invoice Generated: " + inv.getInvoiceId() + " | Final Total: $" + inv.getFinalTotal());
    }
}