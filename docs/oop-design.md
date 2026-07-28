# MediFlow HMS — Java OOP Design

## Overview

MediFlow HMS is designed using Object-Oriented Programming principles.

The system separates responsibilities into different classes and modules instead of placing all functionality inside a single class.

The main OOP concepts used include:

- Classes and Objects
- Encapsulation
- Inheritance
- Abstraction
- Interfaces
- Polymorphism
- Association
- Composition

---

# 1. User Hierarchy

The system can use a common User abstraction for authentication and shared identity information.

Conceptually:

```text

User
|
|-- Patient
|
|-- Staff
      |
      |-- Admin
      |-- Doctor
      |-- Receptionist
      |-- LaboratorySpecialist
      |-- Pharmacist
      |-- Cashier

```

This structure allows common functionality to be shared while maintaining role-specific behavior.

---

# 2. Encapsulation

Sensitive data should be encapsulated inside classes.

For example:

- Password
- Patient contact information
- Billing information
- Medical information

Fields should generally be private and accessed through controlled methods.

This prevents unauthorized direct modification.

---

# 3. Inheritance

Staff members can inherit common properties from a Staff or User class.

For example:

```text

Staff
|
|-- Doctor
|-- Receptionist
|-- LaboratorySpecialist
|-- Pharmacist
|-- Cashier

```

Common properties may include:

- Register ID
- Name
- Password
- Role

Each subclass provides role-specific behavior.

---

# 4. Abstraction

Abstract classes or interfaces can define common behavior.

For example:

```text

Authentication
    |
    |-- login()
    |-- logout()

```

Role-specific implementations can provide their own behavior.

---

# 5. Polymorphism

Polymorphism allows different user roles to provide different implementations of common behavior.

For example, different staff members may have different portal access and workflow operations while following a common role structure.

---

# 6. Appointment

The Appointment class represents a patient's scheduled consultation.

It can contain:

- Appointment ID
- Patient
- Doctor
- Date
- Time
- Problem
- Discount Category
- Appointment Status

The Appointment is associated with both Patient and Doctor.

---

# 7. Prescription

The Prescription is a central persistent record.

It is linked to:

- Patient
- Doctor
- Appointment

A Prescription contains multiple MedicineItem objects.

Conceptually:

```text

Prescription
    |
    |-- MedicineItem
    |-- MedicineItem
    |-- MedicineItem

```

The same Prescription record is used throughout:

```text

Doctor
↓
Pharmacist
↓
Cashier
↓
Patient

```

The Prescription is not physically duplicated between roles.

---

# 8. MedicineItem

MedicineItem represents one prescribed medicine.

It contains:

- Medicine Name
- Number of Days
- Times Per Day
- Medicine Price

The Doctor creates the medical instructions.

The Pharmacist provides the medicine price.

This separation of responsibility maintains workflow integrity.

---

# 9. LabRequest

LabRequest represents a laboratory test requested by the Doctor.

It contains:

- Lab Request ID
- Patient
- Doctor
- Appointment
- Test Type
- Specialization
- Assigned Laboratory Specialist
- Test Price
- Status

The LabRequest is separate from Prescription but linked to the same appointment.

---

# 10. LabReport

LabReport represents the result of a laboratory test.

It is linked to:

- LabRequest
- Patient
- Laboratory Specialist

It may contain:

- Result
- Remarks
- Report File
- Completion Date
- Status

The Laboratory Specialist creates the report.

The Doctor and Patient may view the report according to access permissions.

---

# 11. Bill

The Bill represents the final financial record.

The Bill uses charges from:

- Prescription / Medicine Items
- LabRequest / Laboratory Charges

Conceptually:

```text

Prescription
    |
    | Medicine Charges
    |
LabRequest
    |
    | Laboratory Charges
    |
    v
Bill

```

The Bill contains:

- Bill ID
- Patient
- Appointment
- Medicine Total
- Laboratory Total
- Subtotal
- Discount
- Final Amount
- Payment Status
- Payment Mode
- Payment Date

---

# 12. Payment

Payment information records the completion of the financial transaction.

The payment mode can be:

- Cash
- Online

The Bill stores the payment status and payment mode.

---

# 13. Role-Based Access

The system separates responsibilities by role.

Doctor:
- Creates Prescription
- Creates LabRequest

Pharmacist:
- Adds Medicine Prices

Laboratory Specialist:
- Creates LabReport

Cashier:
- Creates and processes Bill
- Records Payment

Patient:
- Views own records

Admin:
- Manages administrative and financial information

---

# 14. Data Relationships

The main relationships are:

```text

Patient
    |
    | has
    v
Appointment
    |
    | assigned to
    v
Doctor

Appointment
    |
    | creates
    v
Prescription
    |
    | contains
    v
MedicineItem

Appointment
    |
    | creates
    v
LabRequest
    |
    | produces
    v
LabReport

Prescription + LabRequest
    |
    | provide charges
    v
Bill
    |
    | records
    v
Payment

```

---

# 15. Separation of Responsibilities

Each class should have a focused responsibility.

Examples:

Doctor:
Medical consultation and prescription creation.

Pharmacist:
Medicine pricing.

Laboratory Specialist:
Laboratory testing and reports.

Cashier:
Billing and payment.

Patient:
Access to personal records and patient-side actions.

Receptionist:
Registration, appointment support, and queries.

Admin:
Administrative management and financial statistics.

This separation improves maintainability and reduces coupling.

---

# 16. Central Record Architecture

The system uses centralized records.

The Prescription is created once and updated through authorized workflow stages.

The LabRequest is created once and processed by the assigned Laboratory Specialist.

The Bill is created after required charges become available.

This prevents duplicate records and maintains data consistency.

---

# 17. Recommended Architecture

The project can be organized into layers such as:

```text

Models
    ↓
Services
    ↓
Repositories / Data Managers
    ↓
Portal / UI

```

Models represent domain entities.

Services contain business logic.

Repositories or Data Managers handle data storage and retrieval.

Portal or UI classes handle user interaction.

This structure keeps the system modular and maintainable.
