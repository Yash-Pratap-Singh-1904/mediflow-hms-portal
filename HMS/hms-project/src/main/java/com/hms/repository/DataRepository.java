package com.hms.repository;

import com.hms.model.*;

import java.io.*;
import java.util.*;

public class DataRepository implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATA_FILE = "hms_data.ser";

    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Appointment> appointments = new HashMap<>();
    private final Map<String, Prescription> prescriptions = new HashMap<>();
    private final Map<String, Medicine> inventory = new HashMap<>();
    private final Map<String, LabReport> labReports = new HashMap<>();
    private final Map<String, Billing> invoices = new HashMap<>();

    public Map<String, User> getUsers() { return users; }
    public Map<String, Appointment> getAppointments() { return appointments; }
    public Map<String, Prescription> getPrescriptions() { return prescriptions; }
    public Map<String, Medicine> getInventory() { return inventory; }
    public Map<String, LabReport> getLabReports() { return labReports; }
    public Map<String, Billing> getInvoices() { return invoices; }

    public void saveState() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Warning: Unable to serialize application state: " + e.getMessage());
        }
    }

    public static DataRepository loadState() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            return new DataRepository();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (DataRepository) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Warning: Failed to deserialize stored state. Initializing clean repository.");
            return new DataRepository();
        }
    }
}