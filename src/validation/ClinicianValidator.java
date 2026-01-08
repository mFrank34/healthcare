package validation;

import utilities.Constants;
import utilities.Validator;
import java.util.ArrayList;
import java.util.List;

public class ClinicianValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // Generic required-field check
        for (int i = 0; i < data.size(); i++) {
            // Skip special fields (GMC number, phone, email, start_date)
            if (i == 5 || i == 6 || i == 7 || i == 11) continue;

            if (isBlank(data, i)) {
                errors.add(Constants.CLINICIANS[i] + " is required");
            }
        }

        // gmc_number -> index 5 (must be numeric)
        if (isBlank(data, 5)) {
            errors.add("GMC Number is required");
        } else if (isNumeric(data.get(5))) {
            errors.add("GMC Number must be numeric");
        }

        // phone_number -> index 6
        if (isBlank(data, 6)) {
            errors.add("Phone number is required");
        } else if (isValidPhone(data.get(6))) {
            errors.add("Phone number format is invalid");
        }

        // email -> index 7
        if (isBlank(data, 7)) {
            errors.add("Email is required");
        } else if (isValidEmail(data.get(7))) {
            errors.add("Email format is invalid");
        }

        // start_date (yyyy-mm-dd) -> index 11
        if (isBlank(data, 11)) {
            errors.add("Start date is required");
        } else if (isValidDate(data.get(11))) {
            errors.add("Start date must be in format YYYY-MM-DD");
        }

        return errors;
    }
}
