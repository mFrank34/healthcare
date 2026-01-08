package Repository;

import FileHandlers.Handler;
import Models.Prescription;
import Utilities.Constants;

public class PrescriptionRepository extends BaseRepository<Prescription> {

    public PrescriptionRepository() {
        super("data/prescriptions.csv");
        load();
    }

    @Override
    protected Prescription parse(String[] p) {
        return new Prescription(
                p[0],  // prescriptionId
                p[1],  // patientId
                p[2],  // clinicianId
                p[3],  // appointmentId
                p[4],  // prescriptionDate
                p[5],  // medicationName
                p[6],  // dosage
                p[7],  // frequency
                Integer.parseInt(p[8]), // durationDays
                p[9],  // quantity
                p[10], // instructions
                p[11], // pharmacyName
                p[12], // status
                p[13], // issueDate
                p[14]  // collectionDate
        );
    }

    @Override
    protected String toCSV(Prescription obj) {
        return Handler.toCSVLine(
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
                obj.getStatus(),
                obj.getIssueDate(),
                obj.getCollectionDate()
        );
    }

    @Override
    protected Object[] toTableRow(Prescription obj) {
        return new Object[]{
                obj.getPrescriptionId(),
                obj.getPatientId(),
                obj.getClinicianId(),
                obj.getAppointmentId(),
                obj.getPrescriptionDate(),
                obj.getMedicationName(),
                obj.getDosage(),
                obj.getFrequency(),
                obj.getDurationDays(),
                obj.getQuantity(),
                obj.getInstructions(),
                obj.getPharmacyName(),
                obj.getStatus(),
                obj.getIssueDate(),
                obj.getCollectionDate()
        };
    }

    @Override
    protected String getHeader() {
        return String.join(",", Constants.PRESCRIPTIONS);
    }

    @Override
    protected String getId(Prescription obj) {
        return obj.getPrescriptionId();
    }

}