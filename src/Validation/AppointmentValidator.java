package Validation;

import Utilities.Validator;

import java.util.ArrayList;
import java.util.List;

public class AppointmentValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // patient_id
        if (isBlank(data, 1)) {
            errors.add("Patient ID is required");
        }

        // clinician_id
        if (isBlank(data, 2)) {
            errors.add("Clinician ID is required");
        }

        // facility_id
        if (isBlank(data, 3)) {
            errors.add("Facility ID is required");
        }

        // appointment_date (yyyy-mm-dd) -> index 4
        if (isBlank(data, 4)) {
            errors.add("Appointment date is required");
        } else if (!data.get(4).matches(
                "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])"
        )) {
            errors.add("Appointment date must be in format YYYY-MM-DD");
        }

        // appointment_time (HH:mm) -> index 5
        if (isBlank(data, 5)) {
            errors.add("Appointment time is required");
        } else if (!data.get(5).matches(
                "([01]\\d|2[0-3]):[0-5]\\d"
        )) {
            errors.add("Appointment time must be in format HH:MM");
        }

        // duration_minutes -> index 6
        if (isBlank(data, 6)) {
            errors.add("Duration is required");
        } else {
            try {
                int duration = Integer.parseInt(data.get(6));
                if (duration <= 0) {
                    errors.add("Duration must be greater than 0 minutes");
                }
            } catch (NumberFormatException e) {
                errors.add("Duration must be a number");
            }
        }

        // appointment_type -> index 7
        if (isBlank(data, 7)) {
            errors.add("Appointment type is required");
        }

        // status -> index 8
        if (isBlank(data, 8)) {
            errors.add("Status is required");
        }

        // reason_for_visit -> index 9
        if (isBlank(data, 9)) {
            errors.add("Reason for visit is required");
        }

        return errors;
    }

}
