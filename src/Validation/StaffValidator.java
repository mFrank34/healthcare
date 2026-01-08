package Validation;

import Utilities.Constants;
import Utilities.Validator;
import java.util.ArrayList;
import java.util.List;

public class StaffValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // Generic required-field check
        for (int i = 0; i < data.size(); i++) {
            // Skip special fields (phone, email, start_date)
            if (i == 4 || i == 5 || i == 6) continue;

            if (isBlank(data, i)) {
                errors.add(Constants.STAFF[i] + " is required");
            }
        }

        // phone_number -> index 4
        if (isBlank(data, 4)) {
            errors.add("Phone number is required");
        } else if (!isValidPhone(data.get(4))) {
            errors.add("Phone number format is invalid");
        }

        // email -> index 5
        if (isBlank(data, 5)) {
            errors.add("Email is required");
        } else if (!isValidEmail(data.get(5))) {
            errors.add("Email format is invalid");
        }

        // start_date -> index 6
        if (isBlank(data, 6)) {
            errors.add("Start date is required");
        } else if (!isValidDate(data.get(6))) {
            errors.add("Start date must be in format YYYY-MM-DD");
        }

        return errors;
    }
}
