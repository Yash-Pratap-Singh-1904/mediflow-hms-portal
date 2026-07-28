package com.hms.service;

import com.hms.exception.UnauthorizedAccessException;
import com.hms.model.*;
import com.hms.repository.DataRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class AppointmentService {
    private final DataRepository repository;

    public AppointmentService(DataRepository repository) {
        this.repository = repository;
    }

    public Appointment bookAppointment(User receptionist, String patientId, String doctorId, 
                                       String reasonForVisit, LocalDateTime dateTime) {
        SecurityService.verifyRole(receptionist, UserRole.RECEPTIONIST);

        Doctor doctor = (Doctor) repository.getUsers().get(doctorId);
        if (doctor == null || !"Active".equalsIgnoreCase(doctor.getStatus())) {
            throw new IllegalArgumentException("Selected doctor is inactive or invalid.");
        }

        // Check Anti-Double-Booking Policy
        boolean slotOccupied = repository.getAppointments().values().stream()
                .filter(a -> a.getDoctorId().equals(doctorId))
                .filter(a -> "SCHEDULED".equalsIgnoreCase(a.getStatus()))
                .anyMatch(a -> a.getDateTime().equals(dateTime));

        if (slotOccupied) {
            throw new IllegalStateException("Appointment conflict: Doctor " + doctor.getName() + " is already booked at this time slot.");
        }

        String apptId = "APT-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        Appointment appointment = new Appointment(apptId, patientId, doctorId, reasonForVisit, dateTime);
        repository.getAppointments().put(apptId, appointment);
        repository.saveState();

        return appointment;
    }
}