# Patient Workflow

## Overview

The Patient Portal provides patients with access to their own appointments, prescriptions, laboratory information, bills, payment information, and communication with the Receptionist.

The Patient can only access their own records.

---

# 1. Patient Login

The Patient logs into the Patient Portal using their credentials.

After successful login, the Patient can access their personal dashboard.

The Patient cannot access another patient's records.

---

# 2. Book Appointment

The Patient can book their own appointment directly through the Patient Portal.

The system automatically fills:

- Patient Name
- Patient ID
- Contact Number
- Address

The Patient selects:

- Discount / Privilege Category
- Doctor
- Problem / Reason for Visit
- Appointment Date
- Appointment Time

The Patient can only create an appointment for themselves.

The Patient cannot book an appointment for another patient.

---

# 3. My Appointments

The Patient can view a list of their appointments.

The list may contain:

- Doctor Name
- Doctor Specialization
- Appointment Date
- Appointment Time
- Problem
- Appointment Status
- View Appointment

---

# 4. View Appointment

The Patient can open an appointment to view its complete details.

The appointment may contain:

- Patient Information
- Doctor Information
- Appointment Details
- Prescription
- Laboratory Information
- Laboratory Report
- Billing Information
- Payment Information

---

# 5. Prescription

If the Doctor has created a prescription, the Patient can view:

- Medicine Name
- Number of Days
- Times Per Day
- Medicine Price

The Patient cannot modify the prescription.

---

# 6. Laboratory Test

If a laboratory test was requested, the Patient can view:

- Laboratory Test Type
- Laboratory Specialization
- Test Price
- LabRequest Status

---

# 7. Laboratory Report

When the Laboratory Specialist completes the test and uploads the report, the Patient can access it.

The Patient can:

- Open Laboratory Report
- View Remarks
- Preview Report
- Download Report where supported

The Patient cannot modify the report.

---

# 8. Billing Information

The Patient can view:

- Medicine Charges
- Laboratory Test Charges
- Subtotal
- Discount Category
- Discount Amount
- Final Bill
- Payment Status
- Payment Mode
- Payment Date

The Payment Mode can be:

- Cash
- Online

---

# 9. Close Appointment

The Patient Portal provides a patient-side:

"Close Appointment"

or acknowledgment option.

This action does not change the actual medical appointment status.

The Doctor remains responsible for changing:

PENDING → COMPLETED

The Patient's action represents that the Patient has completed or acknowledged their appointment information.

All records remain stored in the system.

---

# 10. Queries and Replies

The Patient Portal contains:

MY QUERIES & REPLIES

The Patient can view previous queries and replies from the Receptionist.

The Patient can also use:

SUBMIT QUERY TO RECEPTIONIST

The Patient enters a query and submits it.

The query is sent to the Receptionist.

The Receptionist can reply through the Receptionist Portal.

The Patient can then view the response.

---

# 11. Patient Data Privacy

The Patient can access only their own:

- Profile
- Appointments
- Prescriptions
- Laboratory Requests
- Laboratory Reports
- Bills
- Payment Records
- Queries

The Patient cannot:

- View another patient's information.
- Modify prescriptions.
- Modify medicine prices.
- Modify laboratory reports.
- Modify bills.
- Modify payment records.

---

# Complete Patient Workflow

```text

Patient Login
↓
Patient Portal
↓
Book Appointment
OR
View Existing Appointments
↓
Select View Appointment
↓
View Appointment Details
↓
View Prescription
↓
View Laboratory Information
↓
Open Laboratory Report if Completed
↓
View Final Bill
↓
View Discount
↓
View Payment Status
↓
View Payment Mode
↓
Close/Acknowledge Appointment

```

Separate Communication Workflow:

```text

Patient
↓
Submit Query
↓
Receptionist
↓
Reply to Query
↓
Patient Views Reply

```
