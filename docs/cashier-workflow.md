# Cashier Workflow

## Overview

The Cashier processes final billing after the Pharmacist has completed pharmacy processing.

The Cashier uses finalized medicine charges and laboratory test charges to generate the patient's final bill.

The Cashier cannot modify medical or pricing information created by other roles.

---

# 1. Pending Billing List

The Cashier sees billing records that are ready for billing.

The list may contain:

- Patient Name
- Patient Age
- Contact Number
- Discount / Privilege Category
- Billing Status
- Action

Only authorized billing records are displayed.

---

# 2. View Billing Details

The Cashier can view:

- Patient Name
- Patient Age
- Contact Number
- Problem / Reason for Visit
- Discount Category
- Medicine Charges
- Laboratory Charges

---

# 3. Medicine Charges

Medicine prices are retrieved from the Pharmacist-processed Prescription.

The Cashier cannot modify medicine prices.

---

# 4. Laboratory Charges

Laboratory test prices are retrieved from the Doctor-created LabRequest.

The Cashier cannot modify laboratory test prices.

---

# 5. Billing Calculation

The system calculates:

Total Medicine Amount
+
Total Laboratory Test Amount
=
Subtotal

Then:

Final Bill
=
Subtotal - Discount

The discount is determined using the patient's Discount / Privilege Category and hospital rules.

---

# 6. Payment Mode

Before completing payment, the Cashier selects the payment mode.

Available options:

- Cash
- Online

The selected payment mode is stored in the Bill/Payment record.

---

# 7. Payment Completion

The Cashier confirms that payment has been completed.

The system records:

- Payment Status
- Payment Mode
- Payment Date
- Final Bill Amount

The Payment Status becomes:

PAID

---

# 8. Patient Portal

After payment is completed, the Patient can view:

- Medicine Charges
- Laboratory Charges
- Subtotal
- Discount
- Final Bill
- Payment Status
- Payment Mode
- Payment Date

The Patient cannot modify the billing information.

---

# 9. Payment History

Paid bills are removed from the pending payment list.

They are moved to Payment History.

The transaction is not deleted.

The completed Bill remains stored for future reference.

---

# 10. Admin Financial Statistics

After successful payment, the transaction contributes to the Admin's financial statistics.

The Admin may view:

- Completed Transactions
- Medicine Sales
- Laboratory Charges
- Discounts
- Total Amount Collected
- Revenue Statistics

---

# Restrictions

The Cashier cannot:

- Modify prescriptions.
- Add medicines.
- Remove medicines.
- Change dosage instructions.
- Modify medicine prices.
- Modify laboratory prices.
- Modify laboratory reports.
- Modify medical diagnosis.
- Access patient passwords.
- Permanently delete completed transactions.

---

# Complete Workflow

```text

Pharmacist
↓
Processes Prescription
↓
Adds Medicine Prices
↓
Prescription Ready for Billing
↓
Cashier Receives Billing Record
↓
Reviews Charges
↓
Calculates Medicine Total
↓
Calculates Laboratory Total
↓
Calculates Subtotal
↓
Applies Discount
↓
Calculates Final Bill
↓
Selects Payment Mode
↓
Cash or Online
↓
Payment Done
↓
Payment Status = PAID
↓
Final Bill Stored
↓
Patient Views Bill
↓
Admin Financial Statistics Updated

```
