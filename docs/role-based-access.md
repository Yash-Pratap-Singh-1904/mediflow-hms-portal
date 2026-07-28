# MediFlow HMS — Role-Based Access Control

## Overview

MediFlow HMS uses role-based access control (RBAC).

Each user is assigned a specific role, and the system determines which features and records that user can access.

The main roles are:

- Admin
- Receptionist
- Doctor
- Laboratory Specialist
- Pharmacist
- Cashier
- Patient

Users should only access information required for their responsibilities.

---

# Admin

## Admin Can

- Manage hospital staff
- Add authorized staff members
- Remove staff members
- View hospital staff directory
- View registered patients
- View financial statistics
- View completed transactions
- View hospital revenue statistics

## Admin Cannot

The Admin should not modify another user's medical records unless explicitly required by administrative functionality.

---

# Receptionist

## Receptionist Can

- Register new patients
- Book appointments
- View appointment information
- Handle patient queries
- Reply to patient queries

## Receptionist Cannot

- View private medical diagnosis
- Modify prescriptions
- Modify laboratory reports
- Modify medicine prices
- Process payments
- Access patient passwords

---

# Doctor

## Doctor Can

- View assigned appointments
- View assigned patients
- View authorized patient information
- Diagnose patients
- Create prescriptions
- Add medicines
- Specify medicine duration
- Specify medicine frequency
- Request laboratory tests
- Enter laboratory test prices
- Close medical appointments
- View completed appointment history

## Doctor Cannot

- View unrelated patients
- View another Doctor's private patient list
- View patient passwords
- Enter medicine prices
- Modify laboratory reports
- Process payments
- Modify Cashier-generated bills

---

# Laboratory Specialist

## Laboratory Specialist Can

- View assigned laboratory requests
- View necessary patient information
- Perform assigned laboratory tests
- Enter laboratory results
- Add remarks
- Upload laboratory reports
- Submit completed laboratory reports

## Laboratory Specialist Cannot

- Access unrelated laboratory requests
- Modify Doctor prescriptions
- Modify medicine prices
- Modify Cashier bills
- View patient passwords

---

# Pharmacist

## Pharmacist Can

- View prescriptions submitted for pharmacy processing
- View prescribed medicines
- View medicine instructions
- Enter medicine prices
- Process prescriptions
- Send processed prescription information to Cashier

## Pharmacist Cannot

- Modify Doctor's medical instructions
- Change medicine names
- Change medicine duration
- Change medicine frequency
- Modify laboratory test prices
- Modify laboratory reports
- Process final payment

---

# Cashier

## Cashier Can

- View billing records forwarded for billing
- View medicine charges
- View laboratory charges
- Calculate subtotal
- Apply applicable discounts
- Generate final bill
- Select payment mode
- Record payment
- Mark bill as paid
- View payment history

Payment modes:

- Cash
- Online

## Cashier Cannot

- Modify prescriptions
- Modify medicine prices
- Modify laboratory test prices
- Modify laboratory reports
- Modify medical diagnosis
- Access patient passwords
- Permanently delete completed financial records

---

# Patient

## Patient Can

- View their own profile
- Book their own appointments
- View their appointments
- View appointment details
- View prescriptions
- View medicine prices
- View laboratory test information
- View completed laboratory reports
- View bills
- View discounts
- View payment status
- View payment mode
- Submit queries
- View Receptionist replies

## Patient Cannot

- View another patient's records
- Modify prescriptions
- Modify medicine prices
- Modify laboratory reports
- Modify bills
- Modify payment records
- Access staff-only portals

---

# Data Privacy Rules

The system must ensure:

1. Patients can access only their own records.
2. Doctors can access only their assigned patients.
3. Laboratory Specialists can access only assigned laboratory requests.
4. Pharmacists can access only prescriptions in the pharmacy workflow.
5. Cashiers can access only billing records available for billing.
6. Receptionists cannot access private medical information.
7. Passwords must never be displayed to unauthorized users.

---

# Workflow-Based Access

Access is not based only on user role.

The current workflow status also determines access.

For example:

```text

Prescription
    ↓
SENT_TO_PHARMACY
    ↓
Pharmacist Processing
    ↓
PHARMACY_PROCESSED
    ↓
Cashier Billing

```

A Cashier should not receive a prescription that has not completed the required pharmacy workflow.

Similarly, a Pharmacist should not process prescriptions that have not been submitted to the pharmacy workflow.

---

# Patient Data Privacy

The system follows the principle of least privilege.

Each user should receive only the information necessary to perform their role.

Sensitive information such as patient passwords should never be exposed to:

- Doctors
- Pharmacists
- Cashiers
- Laboratory Specialists
- Receptionists
- Other Patients
