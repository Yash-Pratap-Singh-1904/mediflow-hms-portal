# Laboratory Workflow

## Overview

The Laboratory Specialist processes laboratory requests created by Doctors.

Laboratory requests are handled independently from the medical appointment after the Doctor submits the request.

---

# 1. Doctor Creates LabRequest

The Doctor determines that a laboratory test is required.

The Doctor selects:

- Test Type
- Laboratory Specialization
- Laboratory Specialist
- Test Price

The LabRequest is linked to:

- Patient
- Doctor
- Appointment

---

# 2. Laboratory Specialization

The system routes laboratory requests based on specialization.

Examples:

| Test | Specialization |
|---|---|
| Blood and Tissue Tests | Pathology |
| X-ray | Radiology |
| MRI | Neuroradiology |
| CT Scan | Interventional Radiology |
| Ultrasound | Interventional Radiology |

Only compatible Laboratory Specialists should be available for assignment.

---

# 3. Laboratory Specialist Portal

The Laboratory Specialist sees assigned laboratory requests.

The Specialist can view the information required to perform the test.

Unrelated Laboratory Specialists cannot access the request.

---

# 4. Perform Laboratory Test

The Laboratory Specialist performs the requested test.

The Specialist records:

- Test Result
- Remarks
- Laboratory Findings
- Report File, where applicable

---

# 5. Laboratory Report

After completing the test, the Laboratory Specialist submits the Laboratory Report.

The report is linked to the original LabRequest.

The report remains stored in the system.

---

# 6. Patient Access

After the report is completed, the corresponding Patient can access the report through the Patient Portal.

The Patient can:

- View report remarks.
- Preview the uploaded report.
- Download the report where supported.

The Patient cannot modify the report.

---

# 7. Doctor Access

The relevant Doctor may view laboratory information according to the system's access rules.

The Doctor cannot modify the Laboratory Report.

---

# 8. Independent Workflow

Closing the medical appointment does not delete the LabRequest.

Example:

```text

Appointment
↓
Doctor Consultation
↓
LabRequest Created
↓
Appointment = COMPLETED
↓
LabRequest = PENDING
↓
Laboratory Specialist Performs Test
↓
LabReport Created
↓
LabReport = COMPLETED

```

---

# Restrictions

The Laboratory Specialist cannot:

- Modify Doctor prescriptions.
- Modify medicine prices.
- Modify Cashier bills.
- Access unrelated laboratory requests.
- Access patient passwords.

---

# Complete Workflow

```text

Doctor
↓
Creates LabRequest
↓
Selects Test Type
↓
Selects Appropriate Specialization
↓
Assigns Laboratory Specialist
↓
Enters Test Price
↓
Submits LabRequest
↓
Laboratory Specialist Receives Request
↓
Performs Test
↓
Adds Result and Remarks
↓
Uploads Laboratory Report
↓
Report Completed
↓
Patient Can View Report

```
