package com.hms.service;

import com.hms.model.*;
import com.hms.repository.DataRepository;

public class LabService {
    private final DataRepository repository;

    public LabService(DataRepository repository) {
        this.repository = repository;
    }

    public void submitLabResult(User user, String reportId, String results) {
        SecurityService.verifyRole(user, UserRole.LABORATORY_SPECIALIST);
        LabReport report = repository.getLabReports().get(reportId);
        if (report != null) {
            report.setResults(results);
            report.setStatus("COMPLETED");
            repository.saveState();
        }
    }
}