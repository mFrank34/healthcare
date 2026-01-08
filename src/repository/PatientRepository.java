package repository;

import handlers.Handler;
import models.Patient;
import utilities.Constants;

public class PatientRepository extends BaseRepository<Patient> {

    public PatientRepository() {
        super("data/patients.csv");
        load();
    }

    @Override
    protected Patient parse(String[] p) {
        return new Patient(
                p[0],
                p[1],
                p[2],
                p[3],
                p[4],
                p[5],
                p[6],
                p[7],
                p[8],
                p[9],
                p[10],
                p[11],
                p[12],
                p[13]
        );
    }

    @Override
    protected String toCSV(Patient obj) {
        return Handler.toCSVLine(
                obj.getPatientId(),
                obj.getFirstName(),
                obj.getLastName(),
                obj.getDateOfBirth(),
                obj.getNhsNumber(),
                obj.getGender(),
                obj.getPhoneNumber(),
                obj.getEmail(),
                obj.getAddress(),
                obj.getPostcode(),
                obj.getEmergencyContactName(),
                obj.getEmergencyContactPhone(),
                obj.getRegistrationDate(),
                obj.getGpSurgeryId()
        );
    }

    @Override
    protected Object[] toTableRow(Patient obj) {
        return new Object[]{
                obj.getPatientId(),
                obj.getFirstName(),
                obj.getLastName(),
                obj.getDateOfBirth(),
                obj.getNhsNumber(),
                obj.getGender(),
                obj.getPhoneNumber(),
                obj.getEmail(),
                obj.getAddress(),
                obj.getPostcode(),
                obj.getEmergencyContactName(),
                obj.getEmergencyContactPhone(),
                obj.getRegistrationDate(),
                obj.getGpSurgeryId()
        };
    }

    @Override
    protected String getHeader() {
        return String.join(",", Constants.PATIENTS);
    }

    @Override
    protected String getId(Patient obj) {
        return obj.getPatientId();
    }

}