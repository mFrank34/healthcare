package validation;

import utilities.Validator;
import models.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientValidator implements Validator<Patient> {

    @Override
    public List<String> validate(Patient patient) {
        List<String> errors = new ArrayList<>();
        // error statements maybe could do with refactoring...
        if (patient.getId() == null || patient.getId().isEmpty()) {
            errors.add("ID: cannot be empty");
        }
        if (patient.getFirst() == null || patient.getFirst().isEmpty()) {
            errors.add("First Name: cannot be empty");
        }
        if (patient.getLast() == null || patient.getLast().isEmpty()) {
            errors.add("Last Name: cannot be empty");
        }
        if (patient.getPhone() == null || !patient.getPhone().matches("\\d+")) {
            errors.add("Phone Number: must be numeric and not empty");
        }
        if (patient.getEmail() == null || !patient.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            errors.add("Email: must be a valid format (example@domain.com)");
        }
        try {
            int nhs = Integer.parseInt(patient.getRawNhsNumber());
            if (nhs <= 0) {
                errors.add("NHS Number: must be positive");
            }
        } catch (NumberFormatException ex) {
            errors.add("NHS Number: must be numeric");
        }
        if (patient.getGender() != 'M' && patient.getGender() != 'F') {
            errors.add("Gender: must be M or F");
        }
        if (patient.getBirth() == null || patient.getBirth().isEmpty()) {
            errors.add("Birth Date: must be provided in valid format (YYYY-MM-DD)");
        }
        if (patient.getAddress() == null || patient.getAddress().isEmpty()) {
            errors.add("Address: cannot be empty");
        }
        if (patient.getPostCode() == null || patient.getPostCode().isEmpty()) {
            errors.add("PostCode: cannot be empty");
        }
        if (patient.getEmergencyName() == null || patient.getEmergencyName().isEmpty()) {
            errors.add("Emergency Name: cannot be empty");
        }
        if (patient.getEmergencyNumber() == null || !patient.getEmergencyNumber().matches("\\d+")) {
            errors.add("Emergency Number: must be numeric and not empty");
        }
        if (patient.getRegistration() == null || patient.getRegistration().isEmpty()) {
            errors.add("Registration: cannot be empty");
        }
        if (patient.getGpId() == null || patient.getGpId().isEmpty()) {
            errors.add("GP - ID: cannot be empty");
        }
        return errors;
    }
}