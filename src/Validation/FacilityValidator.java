package Validation;

import Utilities.Constants;
import Utilities.Validator;
import java.util.ArrayList;
import java.util.List;

public class FacilityValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // Generic required-field check
        for (int i = 0; i < data.size(); i++) {
            // Skip special fields (postcode, phone, email, capacity)
            if (i == 4 || i == 5 || i == 6 || i == 9) continue;

            if (isBlank(data, i)) {
                errors.add(Constants.FACILITIES[i] + " is required");
            }
        }

        // postcode -> index 4
        if (isBlank(data, 4)) {
            errors.add("Postcode is required");
        } else if (!isValidPostcode(data.get(4))) {
            errors.add("Postcode format is invalid");
        }

        // phone_number -> index 5
        if (isBlank(data, 5)) {
            errors.add("Phone number is required");
        } else if (!isValidPhone(data.get(5))) {
            errors.add("Phone number format is invalid");
        }

        // email -> index 6
        if (isBlank(data, 6)) {
            errors.add("Email is required");
        } else if (!isValidEmail(data.get(6))) {
            errors.add("Email format is invalid");
        }

        // capacity -> index 9
        if (isBlank(data, 9)) {
            errors.add("Capacity is required");
        } else if (!isNumeric(data.get(9))) {
            errors.add("Capacity must be a number");
        } else if (Integer.parseInt(data.get(9)) <= 0) {
            errors.add("Capacity must be greater than 0");
        }

        return errors;
    }
}
