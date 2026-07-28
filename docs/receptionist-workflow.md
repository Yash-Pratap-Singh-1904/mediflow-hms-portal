# Receptionist Workflow

## Overview

The Receptionist manages patient registration, appointment booking, and patient queries.

The Receptionist does not manage medical diagnosis, prescriptions, laboratory reports, pharmacy pricing, or final billing.

---

# 1. Receptionist Login

The Receptionist logs into the Receptionist Portal.

The Receptionist can access only receptionist-authorized functionality.

---

# 2. New Patient Registration

The Receptionist can register a new patient.

The system collects information such as:

- Patient Name
- Contact Number
- Address
- Age
- Password

The system generates a unique Patient ID.

The Patient can then use the credentials to access the Patient Portal.

---

# 3. Existing Patient Appointment

The Receptionist can book an appointment for an existing patient.

The system identifies the patient using authorized patient information.

The Receptionist can select:

- Discount / Privilege Category
- Doctor
- Problem / Reason for Visit
- Appointment Date
- Appointment Time

The appointment is linked to the selected patient and Doctor.

---

# 4. Appointment Booking

The system creates an Appointment record.

The Appointment contains:

- Appointment ID
- Patient
- Doctor
- Discount Category
- Problem
- Date
- Time
- Status

The initial status is:

PENDING

---

# 5. Patient Queries

The Patient can submit a query to the Receptionist.

The Receptionist receives the query through the Receptionist Portal.

The Receptionist can reply to the query.

The Patient can view the reply in:

MY QUERIES & REPLIES

---

# 6. Access Restrictions

The Receptionist cannot:

- Modify Doctor prescriptions.
- Modify medicine prices.
- Modify laboratory reports.
- Modify laboratory test prices.
- Process payments.
- Access patient passwords.
- Access unrelated private medical records.

---

# Complete Workflow

``text

New Patient
↓
Patient Registration
↓
Patient ID Created
↓
Patient Account Available

```

OR

```text

Existing Patient
↓
Appointment Booking
↓
Select Doctor
↓
Enter Problem
↓
Select Date and Time
↓
Appointment Created
↓
Appointment Status = PENDING
↓
Doctor Receives Appointment

```
