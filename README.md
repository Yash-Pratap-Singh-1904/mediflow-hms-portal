# Hospital Management System

A role-based Hospital Management System developed using Java and Object-Oriented Programming (OOP) concepts.

The system is designed to digitally manage the complete hospital workflow, including patient registration, appointment booking, doctor consultation, prescriptions, laboratory tests, pharmacy processing, billing, payments, patient queries, and administrative financial statistics.

The project follows a structured role-based access control system where every user can access only the features and information authorized for their role.

---

## 🌐 Live Demo

🔗 **Live Website:** [Add Your Deployed Website URL Here]

---

## 📌 Project Overview

The Hospital Management System provides a centralized platform for managing different hospital operations through separate portals for different users.

The system supports the following roles:

- System Admin
- Receptionist
- Doctor
- Laboratory Specialist
- Pharmacist
- Cashier
- Patient

Each role has its own dedicated portal and responsibilities.

The main objective of this project is to create a secure and organized hospital workflow where information moves between departments while maintaining data privacy and role-based access control.

---

# 🔑 Demo Login Credentials

The following default accounts are available for testing the deployed application.

> **Important:** These credentials are provided only for demonstration and educational purposes.

## System Admin

- **Role:** System Admin
- **Register ID:** `ADM01`
- **Password:** `admin123`

## Receptionist

- **Role:** Receptionist
- **Register ID:** `REC001`
- **Password:** `rec123`

## Doctor 1

- **Role:** Doctor
- **Register ID:** `DOC001`
- **Password:** `doc123`

## Doctor 2

- **Role:** Doctor
- **Register ID:** `DOC002`
- **Password:** `doc002`

## Laboratory Specialist

- **Role:** Laboratory Specialist
- **Register ID:** `LAB001`
- **Password:** `lab123`

## Pharmacist

- **Role:** Pharmacist
- **Register ID:** `PHM001`
- **Password:** `ph123`

## Cashier

- **Role:** Cashier
- **Register ID:** `CAS001`
- **Password:** `cash123`

## Patient 1

- **Role:** Patient
- **Register ID:** `PAT001`
- **Password:** `pass123`

## Patient 2

- **Role:** Patient
- **Register ID:** `PAT002`
- **Password:** `pat002`

## Patient 3

- **Role:** Patient
- **Register ID:** `PAT003`
- **Password:** `pat003`

> These are demo credentials for the deployed project. Do not use real personal information or real passwords in a public repository.

---

## 👥 System Roles

### 1. System Admin

The System Admin manages the overall hospital system and staff.

The Admin can:

- Manage hospital staff.
- Add Doctors.
- Remove Doctors.
- Add Receptionists.
- Remove Receptionists.
- Add Laboratory Specialists.
- Remove Laboratory Specialists.
- View active hospital staff.
- View registered patients.
- View patient information authorized for administrative purposes.
- View hospital financial statistics.
- View completed transactions.
- View total medicine sales.
- View laboratory test charges.
- View discounts granted.
- View total amount collected.
- View overall hospital revenue/business statistics.

The Admin is responsible for overall system administration and monitoring.

---

### 2. Receptionist

The Receptionist manages patient registration and appointment-related operations.

The Receptionist can:

- Register new patients.
- Book appointments for old patients.
- Book appointments for newly registered patients.
- View patient information required for appointment management.
- Select a Doctor.
- Enter the patient's problem or reason for visit.
- Select appointment date and time.
- Manage patient queries.
- Receive queries submitted by patients.
- Send replies to patients.

The Receptionist cannot access sensitive medical information such as:

- Doctor prescriptions.
- Laboratory reports.
- Patient medical history.
- Diagnosis details.
- Pharmacy processing information.
- Cashier payment processing.

---

### 3. Doctor

The Doctor manages patients and appointments assigned to that particular Doctor.

After logging in, the Doctor can view only patients who have appointments assigned to them.

The Doctor can:

- View assigned appointments.
- View assigned patients.
- Open patient details.
- View patient name.
- View patient ID.
- View age.
- View contact number.
- View address.
- View discount/privilege category.
- View problem or reason for visit.
- View appointment date and time.
- Diagnose patients.
- Create prescriptions.
- Add multiple medicines.
- Enter medicine name.
- Enter number of days.
- Enter number of times per day.
- Request laboratory tests.
- Select laboratory test type.
- Select appropriate laboratory specialization.
- Assign an appropriate Laboratory Specialist.
- Enter laboratory test price.
- Submit prescriptions.
- Submit laboratory requests.
- Close completed appointments.
- View completed appointment history.

The Doctor cannot:

- View another Doctor's private patient list.
- View unrelated patients.
- View patient passwords.
- Enter medicine prices.
- Modify medicine prices entered by the Pharmacist.
- Modify laboratory reports.
- Process payments.
- Modify Cashier-generated bills.

---

### 4. Laboratory Specialist

The Laboratory Specialist handles laboratory test requests assigned according to their specialization.

The Laboratory Specialist can:

- View assigned laboratory requests.
- View required patient information.
- View requested laboratory test.
- Perform the assigned laboratory test.
- Enter laboratory test results.
- Add remarks to the laboratory report.
- Upload the laboratory report.
- Submit the completed laboratory report.

Laboratory requests are routed according to specialization.

Examples include:

- Pathology Specialist → Blood and Tissue Tests
- Radiology Specialist → X-Ray
- Neuroradiologist → MRI
- Interventional Radiologist → CT Scan or Ultrasound

The Laboratory Specialist cannot modify:

- Doctor prescriptions.
- Medicine prices.
- Cashier bills.
- Patient passwords.
- Other unrelated laboratory requests.

---

### 5. Pharmacist

The Pharmacist processes prescriptions submitted by Doctors.

The Pharmacist can:

- View pending prescriptions submitted by Doctors.
- View required patient information.
- View prescribed medicines.
- View medicine dosage instructions.
- Enter the price of each medicine.
- View laboratory test information associated with the patient's treatment.
- View the laboratory test price entered by the Doctor.
- Send the processed prescription to the Cashier.

The Pharmacist cannot:

- Modify prescribed medicines.
- Change medicine dosage instructions.
- Modify the number of medication days.
- Modify the number of times medicine should be taken per day.
- Modify laboratory test prices entered by the Doctor.
- Modify laboratory reports.
- Process patient payments.
- Access unrelated prescriptions.

---

### 6. Cashier

The Cashier manages the final billing and payment process.

The Cashier receives billing information after the Pharmacist completes the pharmacy processing.

The Cashier can:

- View pending billing records.
- View patient billing information.
- View medicine charges.
- View laboratory test charges.
- View the patient's discount/privilege category.
- Calculate total medicine charges.
- Calculate total laboratory charges.
- Calculate subtotal.
- Apply the applicable discount.
- Calculate the final bill.
- Select the payment mode.
- Record payment as Cash or Online.
- Mark the bill as Paid.
- Maintain payment history.
- Make the final bill available to the Patient Portal.

The Cashier cannot modify:

- Doctor prescriptions.
- Medicine names.
- Medicine dosage instructions.
- Medicine prices entered by the Pharmacist.
- Laboratory test prices entered by the Doctor.
- Laboratory reports.
- Patient medical information.

---

### 7. Patient

The Patient has access to their own Patient Portal.

The Patient can:

- View their profile.
- Book their own appointments.
- View their appointment history.
- View upcoming appointments.
- View appointment details.
- View Doctor information.
- View prescriptions.
- View prescribed medicines.
- View medicine dosage instructions.
- View medicine prices after pharmacy processing.
- View laboratory test information.
- View laboratory test prices.
- Open completed laboratory reports.
- View laboratory report remarks.
- Preview laboratory reports.
- Download laboratory reports.
- View bills.
- View medicine charges.
- View laboratory charges.
- View discount information.
- View final bill amount.
- View payment status.
- View payment mode.
- View payment date.
- Submit queries to the Receptionist.
- View replies from the Receptionist.

The Patient can only access their own personal, medical, appointment, laboratory, prescription, and billing information.

---

# 🔄 Complete System Workflow

The overall workflow of the Hospital Management System is:

```text

Patient
↓
Patient Registration
↓
Appointment Booking
↓
Receptionist or Patient Books Appointment
↓
Doctor
↓
Patient Consultation
↓
Diagnosis
↓
Prescription Creation
↓
Medicine Details Added
↓
Doctor Decides Whether Laboratory Test Is Required
↓
If Required → Laboratory Request Created
↓
Laboratory Specialist Performs Test
↓
Laboratory Report Generated
↓
Pharmacist
↓
Receives Prescription
↓
Adds Medicine Prices
↓
Prescription Ready for Billing
↓
Cashier
↓
Receives Billing Information
↓
Calculates Medicine Charges
↓
Calculates Laboratory Charges
↓
Applies Discount
↓
Generates Final Bill
↓
Selects Payment Mode
↓
Cash or Online
↓
Payment Completed
↓
Bill Status = PAID
↓
Patient Views Final Bill
↓
Admin Financial Statistics Updated

```

---

# 🏥 Appointment Workflow

An appointment can be created by either:

1. Receptionist
2. Patient

The appointment contains information such as:

- Patient Name
- Patient ID
- Contact Number
- Address
- Discount/Privilege Category
- Selected Doctor
- Problem/Reason for Visit
- Appointment Date
- Appointment Time
- Appointment Status

The Doctor can view only appointments assigned to that Doctor.

The Patient can view only their own appointments.

---

# 💊 Prescription Workflow

The Doctor creates a central Prescription record associated with:

- Patient
- Doctor
- Appointment

The Doctor enters:

- Medicine Name
- Number of Days
- Number of Times Per Day

The Medicine Price remains blank for the Doctor.

The prescription is then submitted to the Pharmacist.

The Pharmacist enters the medicine price for each prescribed medicine.

The Pharmacist then forwards the processed prescription to the Cashier.

The same central Prescription record is maintained throughout the workflow.

The Prescription is not physically duplicated or deleted when it moves between:

Doctor
→ Pharmacist
→ Cashier
→ Patient

This ensures consistent data management and prevents unnecessary duplication.

---

# 🧪 Laboratory Workflow

If a Doctor decides that a patient requires a laboratory test:

```text

Doctor
↓
Creates Laboratory Request
↓
Selects Laboratory Test Type
↓
Appropriate Laboratory Specialization
↓
Assigns Laboratory Specialist
↓
Doctor Enters Laboratory Test Price
↓
Laboratory Request Saved
↓
Laboratory Specialist Receives Request
↓
Test Performed
↓
Laboratory Report Created
↓
Report Uploaded/Submitted
↓
Patient Can View Report

```

The Laboratory Request and Laboratory Report remain associated with the relevant:

- Patient
- Doctor
- Appointment

The Doctor does not modify the Laboratory Report created by the Laboratory Specialist.

---

# 💰 Billing and Payment Workflow

After the Pharmacist enters all medicine prices, the billing information becomes available to the Cashier.

The Cashier views:

- Medicine charges
- Laboratory charges
- Discount/Privilege Category

The system calculates:

Total Medicine Amount
+
Total Laboratory Test Amount
=
Subtotal

Then:

Subtotal
-
Applicable Discount
=
Final Bill Amount

The Cashier then selects the payment mode:

- Cash
- Online

After the payment is completed, the Cashier marks:

**Payment Status: PAID**

The final bill contains:

- Total Medicine Amount
- Total Laboratory Test Amount
- Subtotal
- Discount Category
- Discount Amount
- Final Bill Amount
- Payment Status
- Payment Mode
- Payment Date

The completed bill is then visible to the corresponding Patient in their Patient Portal.

---

# 👤 Patient Appointment and Medical Records

The Patient Portal provides a centralized view of the patient's own healthcare journey.

For each appointment, the patient can view:

### Appointment Details

- Doctor Name
- Doctor Specialization
- Appointment Date
- Appointment Time
- Problem/Reason for Visit
- Appointment Status

### Prescription

- Medicine Name
- Number of Days
- Times Per Day
- Medicine Price

### Laboratory Test

- Laboratory Test Type
- Laboratory Specialist
- Test Price
- Test Status

### Laboratory Report

If a report is available, the patient can:

- Open Laboratory Report
- View Remarks
- Preview Report
- Download Report

### Billing

- Medicine Charges
- Laboratory Charges
- Subtotal
- Discount
- Final Bill
- Payment Status
- Payment Mode
- Payment Date

---

# 💬 Patient Queries

Patients can communicate with the Receptionist through the Patient Portal.

The workflow is:

```text

Patient
↓
Submit Query to Receptionist
↓
Receptionist Receives Query
↓
Receptionist Reviews Query
↓
Receptionist Sends Reply
↓
Patient Views Reply

```

Patients can access their previous queries and replies through:

**My Queries & Replies**

---

# 🔐 Role-Based Access Control

The system implements role-based access control to protect patient and hospital data.

Each role has access only to the features required for its responsibilities.

### Access Overview

| Role | Main Responsibility |
|------|---------------------|
| Admin | System and staff management, financial statistics |
| Receptionist | Patient registration, appointments, queries |
| Doctor | Consultation, diagnosis, prescriptions, lab requests |
| Laboratory Specialist | Laboratory tests and reports |
| Pharmacist | Medicine pricing and pharmacy processing |
| Cashier | Billing and payment processing |
| Patient | Own appointments, prescriptions, reports, bills, queries |

Sensitive information such as patient passwords is never exposed to Doctors, Pharmacists, Laboratory Specialists, Cashiers, or other Patients.

Patients can only access their own records.

Doctors can only access patients assigned to their appointments.

Laboratory Specialists can only access authorized laboratory requests.

Pharmacists can only access prescriptions submitted for pharmacy processing.

Cashiers can only access billing records forwarded for billing.

---

# 🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Role-Based Access Control
- Encapsulation
- Inheritance
- Abstraction
- Interfaces
- Polymorphism
- Composition
- Association
- Collections
- Exception Handling
- File Handling / Data Persistence
- GUI / Web Technologies (update this section according to your actual implementation)

---

# 🧱 OOP Concepts Used

The project demonstrates major Object-Oriented Programming concepts.

### Encapsulation

Sensitive data is protected inside classes using private fields and controlled access through methods.

### Inheritance

Common properties and behaviors can be shared through parent and child classes.

Example:

```text

User
↓
Staff
↓
Doctor
Pharmacist
Cashier
Receptionist
Laboratory Specialist

```

### Abstraction

The system separates essential functionality from implementation details using abstract classes and interfaces where appropriate.

### Polymorphism

Different user roles can provide role-specific implementations while following common interfaces or parent class structures.

### Composition

Complex objects are constructed using relationships between smaller objects.

Example:

Prescription
→ MedicineItem

### Association

Different hospital entities are linked together.

Example:

Patient
→ Appointment
→ Doctor

Appointment
→ Prescription

Appointment
→ LabRequest

Prescription + LabRequest
→ Bill

---

# 🗂️ Main System Entities

The major entities in the system include:

- User
- Staff
- Admin
- Doctor
- Receptionist
- Laboratory Specialist
- Pharmacist
- Cashier
- Patient
- Appointment
- Prescription
- MedicineItem
- LabRequest
- LabReport
- Bill
- Feedback
- Query

---

# 🔗 Core Data Relationships

The primary system relationships are:

```text

Patient
↓
Appointment
↓
Doctor

Appointment
↓
Prescription
↓
MedicineItem

Appointment
↓
LabRequest
↓
LabReport

Prescription + LabRequest
↓
Bill

Bill
↓
Payment

```

This structure allows the hospital to maintain a complete record of a patient's healthcare and billing workflow.

---

# 📚 Documentation

Detailed project documentation is available in the `docs/` directory.

The documentation covers:

- Complete System Workflow
- Role-Based Access Control
- Doctor Workflow
- Receptionist Workflow
- Laboratory Workflow
- Pharmacist Workflow
- Cashier Workflow
- Patient Workflow
- Java OOP Architecture
- System Data Relationships

---

# 🔒 Data Privacy and Security

The project follows role-based access control principles to restrict access to sensitive information.

Important privacy rules include:

- Patients can access only their own records.
- Doctors can access only patients assigned to their appointments.
- Doctors cannot view patient passwords.
- Pharmacists cannot modify medical prescriptions.
- Laboratory Specialists cannot modify Doctor prescriptions.
- Cashiers cannot modify medical or prescription information.
- Cashiers cannot modify medicine prices entered by Pharmacists.
- Cashiers cannot modify laboratory test prices entered by Doctors.
- Completed financial transactions are retained for record keeping.
- Completed appointments are retained for medical history.

---

# 🎯 Project Objectives

The main objectives of this project are:

- Digitize hospital management operations.
- Provide separate portals for different hospital roles.
- Implement role-based access control.
- Maintain patient data privacy.
- Simplify appointment management.
- Organize doctor-patient workflows.
- Digitize prescription management.
- Manage laboratory requests and reports.
- Streamline pharmacy processing.
- Automate billing calculations.
- Support cash and online payment modes.
- Maintain patient medical and billing history.
- Provide centralized financial statistics for administrators.

---

# 🚀 Future Improvements

Possible future improvements include:

- Real-time online payment gateway integration.
- Email and SMS notifications.
- Appointment reminders.
- Secure password reset functionality.
- Two-factor authentication.
- Database integration with MySQL or PostgreSQL.
- Cloud deployment.
- Advanced hospital analytics.
- Prescription PDF generation.
- Digital invoice generation.
- Doctor availability and scheduling.
- Advanced laboratory report management.
- Secure document storage.
- Audit logs for sensitive operations.

---

# 👨‍💻 Project Purpose

This project was developed as an academic and educational project to demonstrate the practical application of Java and Object-Oriented Programming concepts in a real-world Hospital Management System.

The project focuses on modular design, role-based access control, data privacy, workflow management, and the interaction between different hospital departments.

---

# 🔄 Overall System Workflow

The main hospital workflow is:

```text
Patient
   │
   ├── Books Appointment
   │
   ▼
Receptionist / Patient
   │
   └── Appointment Created
   │
   ▼
Doctor
   │
   ├── Views Assigned Patient
   ├── Diagnoses Patient
   ├── Creates Prescription
   └── Requests Lab Test if Required
   │
   ├───────────────────────┐
   ▼                       ▼
Pharmacist             Laboratory Specialist
   │                       │
   ├── Adds Medicine       ├── Performs Test
   │   Prices              ├── Adds Results
   │                       └── Uploads Report
   ▼
Cashier
   │
   ├── Calculates Charges
   ├── Applies Discount
   ├── Selects Payment Mode
   └── Records Payment
   │
   ├───────────────────────┐
   ▼                       ▼
Patient Portal         Admin Dashboard
   │                       │
   ├── Views Bill          └── Financial Statistics
   ├── Views Payment
   ├── Views Prescription
   └── Views Lab Report

```

---

## ⭐ If you find this project useful

Feel free to explore the project, review the source code, and provide feedback or suggestions for improvement.
