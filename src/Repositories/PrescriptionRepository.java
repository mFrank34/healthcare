package Repositories;

import Models.Prescription;

public class PrescriptionRepository extends BaseRepository<Prescription> {

    public PrescriptionRepository() {
        super("data/prescriptions.csv");
        load();
    }

    @Override
    protected Prescription parse(String[] p) {
        return new Prescription(
                p[0], // prescriptionId
                p[1], // patientId
                p[2], // clinicianId
                p[3], // appointmentId
                p[4], // prescriptionDate
                p[5], // medicationName
                p[6], // dosage
                p[7], // frequency
                Integer.parseInt(p[8]), // durationDays
                p[9], // quantity
                p[10], // instructions
                p[11], // pharmacyName
                p[12]  // status
        );
    }

    @Override
    protected String toCSV(Prescription obj) {
        return String.join(",",
                obj.getPrescriptionId(),
                obj.getPatientId(),
                obj.getClinicianId(),
                obj.getAppointmentId(),
                obj.getPrescriptionDate(),
                obj.getMedicationName(),
                obj.getDosage(),
                obj.getFrequency(),
                String.valueOf(obj.getDurationDays()),
                obj.getQuantity(),
                obj.getInstructions(),
                obj.getPharmacyName(),
                obj.getStatus()
        );
    }

    @Override
    protected String getHeader() {
        return "prescription_id,patient_id,clinician_id,appointment_id,prescription_date,medication_name,dosage,frequency,duration_days,quantity,instructions,pharmacy_name,status";
    }

    @Override
    protected boolean matchesId(Prescription obj, String id) {
        return obj.getPrescriptionId().equals(id);
    }
}
