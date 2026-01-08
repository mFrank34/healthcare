package validation;

import utilities.Constants;
import utilities.Validator;
import java.util.ArrayList;
import java.util.List;

public class AppointmentValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // Generic required-field check
        for (int i = 0; i < data.size(); i++) {
            // Skip special fields (date, time, duration)
            if (i == 4 || i == 5 || i == 6) continue;

            if (isBlank(data, i)) {
                errors.add(Constants.APPOINTMENTS[i] + " is required");
            }
        }

        // appointment_date -> index 4
        if (isBlank(data, 4)) {
            errors.add("Appointment date is required");
        } else if (isValidDate(data.get(4))) {
            errors.add("Appointment date must be in format YYYY-MM-DD");
        }

        // appointment_time -> index 5
        if (isBlank(data, 5)) {
            errors.add("Appointment time is required");
        } else if (!data.get(5).matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            errors.add("Appointment time must be in format HH:MM");
        }

        // duration_minutes -> index 6
        if (isBlank(data, 6)) {
            errors.add("Duration is required");
        } else if (isNumeric(data.get(6))) {
            errors.add("Duration must be a number");
        } else if (Integer.parseInt(data.get(6)) <= 0) {
            errors.add("Duration must be greater than 0 minutes");
        }

        return errors;
    }
}
