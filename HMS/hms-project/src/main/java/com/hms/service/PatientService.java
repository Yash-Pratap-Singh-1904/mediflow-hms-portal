package com.hms.service;

import com.hms.exception.UnauthorizedAccessException;
import com.hms.model.*;
import com.hms.repository.DataRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PatientService {
    private final DataRepository repository;

    public PatientService(DataRepository repository) {
        this.repository = repository;
    }

    // 9.2 Book Own Appointment with Schedule Validation
    public Appointment bookOwnAppointment(User authenticatedPatient, String doctorId, 
                                           DiscountType discountType, String reason, LocalDateTime dateTime) {
        SecurityService.verifyRole(authenticatedPatient, UserRole.PATIENT);

        Doctor doctor = (Doctor) repository.getUsers().get(doctorId);
        if (doctor == null || !"Active".equalsIgnoreCase(doctor.getStatus())) {
            throw new IllegalArgumentException("Selected doctor is currently unavailable.");
        }

        // 9.5 Anti Double-Booking Validation
        boolean isOccupied = repository.getAppointments().values().stream()
                .filter(a -> a.getDoctorId().equals(doctorId))
                .filter(a -> "SCHEDULED".equalsIgnoreCase(a.getStatus()) || "PENDING".equalsIgnoreCase(a.getStatus()))
                .anyMatch(a -> a.getDateTime().equals(dateTime));

        if (isOccupied) {
            throw new IllegalStateException("Appointment slot conflict: Doctor is already booked at " + dateTime);
        }

        String apptId = "APP-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        Appointment appointment = new Appointment(apptId, authenticatedPatient.getId(), doctorId, reason, dateTime);
        
        repository.getAppointments().put(apptId, appointment);
        repository.saveState();

        return appointment;
    }

    // 9.19 Strict Patient-Level Data Retrievals
    public List<Appointment> getPatientAppointments(User authenticatedPatient) {
        SecurityService.verifyRole(authenticatedPatient, UserRole.PATIENT);
        return repository.getAppointments().values().stream()
                .filter(a -> a.getPatientId().equals(authenticatedPatient.getId()))
                .collect(Collectors.toList());
    }

    public List<Prescription> getPatientPrescriptions(User authenticatedPatient) {
        SecurityService.verifyRole(authenticatedPatient, UserRole.PATIENT);
        return repository.getPrescriptions().values().stream()
                .filter(p -> p.getPatientId().equals(authenticatedPatient.getId()))
                .collect(Collectors.toList());
    }

    public List<LabRequest> getPatientLabRequests(User authenticatedPatient) {
        SecurityService.verifyRole(authenticatedPatient, UserRole.PATIENT);
        return repository.getLabRequests().values().stream()
                .filter(l -> l.getPatientId().equals(authenticatedPatient.getId()))
                .collect(Collectors.toList());
    }

    public List<Bill> getPatientBills(User authenticatedPatient) {
        SecurityService.verifyRole(authenticatedPatient, UserRole.PATIENT);
        return repository.getInvoices().values().stream()
                .filter(b -> b.getPatientId().equals(authenticatedPatient.getId()))
                .collect(Collectors.toList());
    }
}