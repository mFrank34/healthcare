package Validation;

import Utilities.Validator;
import Models.Clinician;

import java.util.ArrayList;
import java.util.List;

public class CliniciansValidator implements Validator<Clinician> {
    @Override
    public List<String> validate(Clinician model) {
        List<String> errors = new ArrayList<>();
        // error statements maybe could do with refactoring...
        if (model.getId() == null || model.getId().isEmpty()) {
            errors.add("ID: cannot be empty");
        }
        if (model.getFirst() == null || model.getFirst().isEmpty()) {
            errors.add("First Name: cannot be empty");
        }
        if (model.getLast() == null || model.getLast().isEmpty()) {
            errors.add("Last Name: cannot be empty");
        }
        if (model.getPhone() == null || !model.getPhone().matches("\\d+")) {
            errors.add("Phone Number: must be numeric and not empty");
        }
        if (model.getEmail() == null || !model.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            errors.add("Email: must be a valid format");
        }
        if (model.getStartDate() == null || model.getStartDate().isEmpty()) {
            errors.add("Start Date: cannot be empty");
        }
        if (model.getStatus() == null || model.getStatus().isEmpty()) {
            errors.add("Status: cannot be empty");
        }
        if (model.getTitle() == null || model.getTitle().isEmpty()) {
            errors.add("Title: cannot be empty");
        }
        if (model.getSpeciality() == null || model.getSpeciality().isEmpty()) {
            errors.add("Speciality: cannot be empty");
        }
        if (model.getGmc() == null || model.getGmc().isEmpty()) {
            errors.add("GMC Number: cannot be empty");
        }
        if (model.getWorkplaceId() == null || model.getWorkplaceId().isEmpty()) {
            errors.add("Workplace: cannot be empty");
        }
        if (model.getType() == null || model.getType().isEmpty()) {
            errors.add("Type: cannot be empty");
        }
        return errors;
    }
}
