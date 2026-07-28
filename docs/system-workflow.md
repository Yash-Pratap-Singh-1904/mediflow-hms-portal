# MediFlow HMS — Complete System Workflow

## Overview

MediFlow HMS is a role-based Hospital Management System designed to manage the complete hospital workflow from patient registration and appointment booking to medical consultation, prescription processing, laboratory testing, pharmacy processing, billing, payment, and patient access to medical records.

The system follows a centralized workflow in which each hospital role performs only the tasks assigned to that role.

The main roles in the system are:

1. System Admin
2. Receptionist
3. Doctor
4. Laboratory Specialist
5. Pharmacist
6. Cashier
7. Patient

The system uses role-based access control to ensure that each user can access only the information and functionality authorized for their role.

---

# 1. Patient Registration

A new patient can be registered through the Patient Registration functionality.

During registration, the system creates a unique Patient ID.

The patient can then use their credentials to access the Patient Portal.

For demonstration purposes, the system uses predefined credentials and locally managed patient accounts.

The system does not depend on external email or SMS services for authentication or password delivery.

---

# 2. Patient Appointment Booking

An appointment can be created through the Receptionist Portal.

The Receptionist can book an appointment for:

- A new patient
- An existing patient

The Patient Portal also allows a logged-in patient to book their own appointment.

When booking an appointment, the system stores information such as:

- Patient
- Doctor
- Discount / Privilege Category
- Problem / Reason for Visit
- Appointment Date
- Appointment Time

The appointment is associated with the selected patient and doctor.

---

# 3. Doctor Consultation

After an appointment is created, it becomes available to the assigned Doctor.

The Doctor can view only appointments assigned to that Doctor.

The Doctor can open the appointment and view authorized patient information.

The Doctor can then:

- Examine the patient
- Diagnose the patient
- Create a prescription
- Add medicines
- Specify medicine duration
- Specify medicine frequency
- Request laboratory tests when required

The Doctor does not enter medicine prices.

---

# 4. Prescription Workflow

The Doctor creates one central Prescription record.

The prescription contains medicine items such as:

- Medicine Name
- Number of Days
- Times Per Day
- Medicine Price

The Doctor enters:

- Medicine Name
- Number of Days
- Times Per Day

The Medicine Price remains empty for the Doctor.

After submission, the Prescription status changes to:

SENT_TO_PHARMACY

The Pharmacist then processes the same central Prescription record.

The Pharmacist enters the price of each medicine.

The Pharmacist does not create a new prescription.

---

# 5. Laboratory Workflow

If a laboratory test is required, the Doctor creates a LabRequest.

The Doctor selects the appropriate laboratory test type and specialization.

Examples include:

- Blood and Tissue Tests → Pathology
- X-ray → Radiology
- MRI → Neuroradiology
- CT Scan / Ultrasound → Interventional Radiology

The Doctor enters the laboratory test price.

The LabRequest is linked to:

- Patient
- Doctor
- Appointment

The LabRequest is then assigned to an appropriate Laboratory Specialist.

The Laboratory Specialist processes the test and creates a Laboratory Report.

The Doctor does not modify the Laboratory Report.

---

# 6. Pharmacy Workflow

After the Doctor submits the Prescription, it appears in the Pharmacist Portal.

The Pharmacist:

1. Opens the Prescription.
2. Views the Doctor's medicine instructions.
3. Enters medicine prices.
4. Verifies that all required medicine prices are available.
5. Processes the prescription.
6. Sends the finalized pharmacy information to the Cashier workflow.

The Pharmacist cannot modify:

- Medicine Name
- Number of Days
- Times Per Day
- Doctor's medical instructions
- Laboratory Test Price

---

# 7. Billing Workflow

After pharmacy processing, the billing information becomes available to the Cashier.

The Cashier reviews:

- Medicine charges
- Laboratory test charges
- Discount / Privilege Category

The system calculates:

Total Medicine Amount
+
Total Laboratory Test Amount
=
Subtotal

The applicable discount is then calculated.

Finally:

Final Bill = Subtotal - Discount

The Cashier then records the patient's payment.

The payment mode can be:

- Cash
- Online

The selected payment mode is stored with the Bill.

---

# 8. Payment Workflow

The Cashier confirms the payment after selecting the payment mode.

The system records:

- Payment Status
- Payment Mode
- Payment Date

The payment status becomes:

PAID

The completed bill is stored permanently in the system.

The bill becomes visible to the corresponding patient in the Patient Portal.

---

# 9. Patient Portal

The Patient can access their own records through the Patient Portal.

The Patient can:

- Book appointments
- View appointments
- View appointment details
- View prescriptions
- View medicine prices
- View laboratory test information
- View laboratory reports
- View bills
- View discounts
- View payment information
- View payment mode
- Submit queries to the Receptionist
- View replies from the Receptionist

The Patient cannot modify medical records, prescriptions, laboratory reports, or billing information.

---

# 10. Appointment Completion

The Doctor is responsible for changing the medical appointment status.

The Doctor can change:

PENDING → COMPLETED

The Patient Portal provides a patient-side "Close Appointment" or acknowledgment option.

This does not change the actual medical appointment status.

The Patient-side action represents that the patient has finished viewing or acknowledging the appointment.

All appointment, prescription, laboratory, and billing records remain stored in the system.

---

# 11. Complete Workflow

```text

The overall system workflow is:

Patient Registration
    ↓
Appointment Booking
    ↓
Doctor Consultation
    ↓
Diagnosis
    ↓
Prescription Creation
    ↓
Optional Laboratory Test Request
    ↓
Pharmacist Processes Prescription
    ↓
Medicine Prices Added
    ↓
Laboratory Test Processed Separately
    ↓
Billing Information Available
    ↓
Cashier Generates Final Bill
    ↓
Discount Applied
    ↓
Payment Mode Selected
    ↓
Payment Completed
    ↓
Bill Marked as Paid
    ↓
Patient Views Final Bill
    ↓
Admin Financial Statistics Updated

```

---

# 12. Central Data Model

```text

The main workflow relationships are:

Patient
    ↓
Appointment
    ↓
Doctor
    ↓
Prescription
    ↓
MedicineItem

Patient
    ↓
Appointment
    ↓
Doctor
    ↓
LabRequest
    ↓
LabReport

Prescription + LabRequest
    ↓
Bill
    ↓
Payment

```

The Prescription and LabRequest remain separate domain objects but are linked to the same Patient, Doctor, and Appointment.

---

# 13. Important Design Principle

The system uses centralized persistent records.

A Prescription is not physically transferred or duplicated between the Doctor, Pharmacist, Cashier, and Patient.

Instead, the same Prescription record moves through different workflow states.

Similarly, the LabRequest remains linked to the original appointment and continues independently until the laboratory process is completed.

This design maintains data consistency and prevents duplicate medical records.
