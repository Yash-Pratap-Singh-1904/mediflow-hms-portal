# Pharmacist Workflow

## Overview

The Pharmacist processes prescriptions submitted by Doctors.

The Pharmacist is responsible for entering medicine prices and forwarding the processed pharmacy information to the Cashier.

The Pharmacist does not modify medical instructions created by the Doctor.

---

# 1. Pharmacist Login

The Pharmacist logs into the Pharmacist Portal.

The Pharmacist sees prescriptions that are available for pharmacy processing.

---

# 2. Pending Prescription List

The Pharmacist can view:

- Patient Name
- Patient Age
- Patient Contact Number
- Problem / Reason for Visit
- Discount / Privilege Category
- Prescription Status

The Pharmacist opens a prescription to process it.

---

# 3. Prescription Details

The Pharmacist can view the Doctor's prescription.

Each medicine contains:

- Medicine Name
- Number of Days
- Times Per Day
- Medicine Price

The first three fields come from the Doctor.

The Medicine Price is entered by the Pharmacist.

---

# 4. Medicine Pricing

The Pharmacist enters the price of every prescribed medicine.

Example:

| Medicine | Days | Times Per Day | Price |
|---|---:|---:|---:|
| Medicine A | 5 | 2 | $10 |
| Medicine B | 7 | 3 | $15 |

The system validates that every required medicine has a valid price.

The Pharmacist cannot submit incomplete pricing.

---

# 5. Laboratory Test

If the Doctor requested a laboratory test, the Pharmacist can view the associated laboratory information.

The Pharmacist does not modify the laboratory test price.

The laboratory price remains the price entered by the Doctor.

---

# 6. Central Prescription

The Pharmacist updates the existing central Prescription record.

The Pharmacist does not create a new Prescription.

The Prescription remains linked to:

- Patient
- Doctor
- Appointment

---

# 7. Send to Cashier

After entering all medicine prices, the Pharmacist submits the processed prescription.

The system:

1. Validates medicine prices.
2. Saves the updated medicine prices.
3. Updates the Prescription status.
4. Makes billing information available to the Cashier.

---

# 8. Restrictions

The Pharmacist cannot:

- Change medicine names.
- Change medicine duration.
- Change medicine frequency.
- Change Doctor's medical instructions.
- Change laboratory test prices.
- Modify laboratory reports.
- Process final payment.
- Access unrelated prescriptions.

---

# Complete Workflow

```text

Doctor
↓
Creates Prescription
↓
Prescription Status = SENT_TO_PHARMACY
↓
Pharmacist Receives Prescription
↓
Views Medicine Instructions
↓
Enters Medicine Prices
↓
Validates Prices
↓
Prescription Status = PHARMACY_PROCESSED
↓
Billing Information Available
↓
Cashier Processes Bill

```
