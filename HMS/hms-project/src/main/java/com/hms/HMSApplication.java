package com.hms;

import com.hms.cli.ConsoleUI;
import com.hms.model.*;
import com.hms.repository.DataRepository;

public class HMSApplication {
    public static void main(String[] args) {
        DataRepository repository = DataRepository.loadState();
        seedDataIfEmpty(repository);

        ConsoleUI console = new ConsoleUI(repository);
        console.start();
    }

    private static void seedDataIfEmpty(DataRepository repo) {
        if (repo.getUsers().isEmpty()) {
            // Seed Admin
            User admin = new User("ADM01", "System Admin", "555-0000", 40, "admin123", UserRole.ADMIN) {
                @Override
                public boolean validatePassword(String pass) { return super.validatePassword(pass); }
            };
            repo.getUsers().put(admin.getId(), admin);

            // Seed Patient P101
            Patient p1 = new Patient("P101", "Alice Smith", "555-0192", 28, "pass123", "123 Main St", DiscountType.STUDENT);
            repo.getUsers().put(p1.getId(), p1);

            // Seed Doctor D201
            Doctor d1 = new Doctor("D201", "Dr. Bob Vance", "555-0193", 45, "doc123", DoctorSpecialization.CARDIOLOGIST, "09:00 AM - 05:00 PM");
            repo.getUsers().put(d1.getId(), d1);

            // Seed Receptionist REC301
            User rec = new User("REC301", "Sarah Connor", "555-0194", 30, "rec123", UserRole.RECEPTIONIST) {};
            repo.getUsers().put(rec.getId(), rec);

            // Seed Lab Specialist LAB401
            LabSpecialist lab = new LabSpecialist("LAB401", "Diana Prince", "555-0195", 34, "lab123", LabSpecialization.RADIOLOGY, "08:00 AM - 04:00 PM");
            repo.getUsers().put(lab.getId(), lab);

            // Seed Pharmacist PH501
            User ph = new User("PH501", "Charlie Brown", "555-0196", 32, "ph123", UserRole.PHARMACIST) {};
            repo.getUsers().put(ph.getId(), ph);

            // Seed Cashier C601
            User cash = new User("C601", "Edward Nygma", "555-0197", 29, "cash123", UserRole.CASHIER) {};
            repo.getUsers().put(cash.getId(), cash);

            repo.saveState();
        }
    }
}