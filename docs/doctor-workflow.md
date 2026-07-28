# Doctor Workflow

## Overview

The Doctor is responsible for managing assigned patient appointments, diagnosing patients, creating prescriptions, requesting laboratory tests, and completing medical consultations.

The Doctor can access only patients who have appointments assigned to that Doctor.

---

# 1. Doctor Login

The Doctor logs into the Doctor Portal using their credentials.

After successful authentication, the Doctor sees their personal dashboard.

The Doctor does not have access to another Doctor's private patient list.

---

# 2. My Appointments

The Doctor sees only their assigned appointments.

Each appointment may display:

- Patient Name
- Age
- Problem
- Appointment Date
- Appointment Time
- Status
- View Patient

---

# 3. View Patient

The Doctor can select an appointment and view authorized patient information.

The information may include:

- Patient Name
- Patient ID
- Age
- Contact Number
- Address
- Discount / Privilege Category
- Problem / Reason for Visit
- Appointment Date
- Appointment Time
- Appointment Status
- Doctor Name
- Doctor Specialization

Patient passwords are never displayed.

---

# 4. Create Prescription

The Doctor opens the diagnosis and prescription section.

The system automatically loads information from the appointment.

The Doctor creates a central Prescription record.

The Prescription contains MedicineItem objects.

Each MedicineItem contains:

- Medicine Name
- Number of Days
- Times Per Day
- Medicine Price

The Doctor enters:

- Medicine Name
- Number of Days
- Times Per Day

The Medicine Price remains empty for the Pharmacist.

---

# 5. Add Medicines

The Doctor can dynamically add multiple medicines.

Example:

| Medicine | Days | Times Per Day | Price |
|---|---:|---:|---|
| Medicine A | 5 | 2 | Pharmacist |
| Medicine B | 7 | 3 | Pharmacist |

The Doctor can remove a medicine before submitting the prescription.

---

# 6. Laboratory Test

The Doctor decides whether a laboratory test is required.

If No:

- No LabRequest is created.

If Yes:

- The Doctor selects the test type.
- The system determines the appropriate specialization.
- An appropriate Laboratory Specialist is assigned.
- The Doctor enters the laboratory test price.

Examples:

Blood/Tissue → Pathology

X-ray → Radiology

MRI → Neuroradiology

CT Scan/Ultrasound → Interventional Radiology

---

# 7. Central Prescription

The Doctor creates one central Prescription record.

The record is linked to:

- Patient
- Doctor
- Appointment

The Prescription is not duplicated when accessed by the Pharmacist or Cashier.

The workflow status may be:

CREATED
→
SENT_TO_PHARMACY
→
PHARMACY_PROCESSED
→
READY_FOR_BILLING
→
BILLED
→
COMPLETED

---

# 8. Submit Prescription

After completing the prescription, the Doctor submits it.

The system:

1. Saves the Prescription.
2. Changes the status to SENT_TO_PHARMACY.
3. Makes it available to the Pharmacist.

If a LabRequest exists, it is also saved and assigned to the appropriate Laboratory Specialist.

---

# 9. Close Appointment

The Doctor can close the medical appointment after completing the consultation.

The appointment changes:

PENDING → COMPLETED

The appointment remains stored in the system.

The LabRequest continues independently if a laboratory test is still pending.

---

# 10. Important Restrictions

The Doctor cannot:

- Access unrelated patients.
- Access another Doctor's private patients.
- View patient passwords.
- Enter medicine prices.
- Modify laboratory reports.
- Process payments.
- Modify Cashier bills.

---

# Complete Doctor Workflow

```text

Doctor Login
↓
Doctor Portal
↓
My Appointments
↓
View Patient
↓
View Authorized Details
↓
Diagnose Patient
↓
Create Prescription
↓
Add Medicines
↓
Decide on Laboratory Test
↓
Create LabRequest if Required
↓
Enter Laboratory Test Price
↓
Submit Prescription
↓
Send Prescription to Pharmacist
↓
Send LabRequest to Laboratory Specialist
↓
Complete Consultation
↓
Appointment = COMPLETED

```
