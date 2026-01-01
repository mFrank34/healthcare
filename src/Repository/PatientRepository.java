package Repository;

import Models.Patient;

public class PatientRepository extends BaseRepository<Patient> {

    public PatientRepository() {
        super("data/patients.csv");
        load();
    }

    @Override
    protected Patient parse(String[] p) {
        return new Patient(
                p[0], p[1], p[2], p[3], p[4],
                p[5], p[6], p[7], p[8], p[9],
                p[10], p[11], p[12], p[13]
        );
    }

    @Override
    protected String toCSV(Patient p) {
        return String.join(",",
                p.getPatientId(),
                p.getFirstName(),
                p.getLastName(),
                p.getDateOfBirth(),
                p.getNhsNumber(),
                p.getGender(),
                p.getPhoneNumber(),
                p.getEmail(),
                p.getAddress(),
                p.getPostcode(),
                p.getEmergencyContactName(),
                p.getEmergencyContactPhone(),
                p.getRegistrationDate(),
                p.getGpSurgeryId()
        );
    }

    @Override
    protected String getHeader() {
        return "patient_id,first_name,last_name,date_of_birth,nhs_number,gender,phone_number,email,address,postcode,emergency_contact_name,emergency_contact_phone,registration_date,gp_surgery_id";
    }

    @Override
    protected String getId(Patient obj) {
        return obj.getPatientId();
    }

}