package Validation;

import Utilities.Validator;
import Models.Staff;
import java.util.ArrayList;
import java.util.List;

public class StaffValidator implements Validator<Staff> {
    @Override
    public List<String> validate(Staff staff) {
        List<String> errors = new ArrayList<>();
        // error statements maybe could do with refactoring...
        if (staff.getId() == null || staff.getId().isEmpty()) {
            errors.add("ID: cannot be empty");
        }
        if (staff.getFirst() == null || staff.getFirst().isEmpty()) {
            errors.add("First Name: cannot be empty");
        }
        if (staff.getLast() == null || staff.getLast().isEmpty()) {
            errors.add("Last Name: cannot be empty");
        }
        if (staff.getPhone() == null || !staff.getPhone().matches("\\d+")) {
            errors.add("Phone Number: must be numeric and not empty");
        }
        if (staff.getEmail() == null || !staff.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")) {
            errors.add("Email: must be a valid format");
        }
        if (staff.getStartDate() == null || staff.getStartDate().isEmpty()) {
            errors.add("Start Date: cannot be empty");
        }
        if (staff.getStatus() == null || staff.getStatus().isEmpty()) {
            errors.add("Status: cannot be empty");
        }
        if (staff.getRole() == null || staff.getRole().isEmpty()) {
            errors.add("Role: cannot be empty");
        }
        if (staff.getDepartment() == null || staff.getDepartment().isEmpty()) {
            errors.add("Department: cannot be empty");
        }
        if (staff.getFacility() == null || staff.getFacility().isEmpty()) {
            errors.add("Facility: cannot be empty");
        }
        if (staff.getLineManager() == null || staff.getLineManager().isEmpty()) {
            errors.add("Line Manager: cannot be empty");
        }
        if (staff.getAccess() == null || staff.getAccess().isEmpty()) {
            errors.add("Access: cannot be empty");
        }
        return errors;
    }
}
