package validation;

import utilities.Constants;
import utilities.Validator;
import java.util.ArrayList;
import java.util.List;

public class PatientValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // Generic required-field check
        for (int i = 0; i < data.size(); i++) {
            // Skip special fields (date_of_birth, phone, email, zip code, registration_date)
            if (i == 3 || i == 6 || i == 7 || i == 9 || i == 12) continue;

            if (isBlank(data, i)) {
                errors.add(Constants.PATIENTS[i] + " is required");
            }
        }

        // date_of_birth -> index 3
        if (isBlank(data, 3)) {
            errors.add("Date of birth is required");
        } else if (isValidDate(data.get(3))) {
            errors.add("Date of birth must be in format YYYY-MM-DD");
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

        // postcode -> index 9
        if (isBlank(data, 9)) {
            errors.add("Postcode is required");
        } else if (isValidPostcode(data.get(9))) {
            errors.add("Postcode format is invalid");
        }

        // registration_date -> index 12
        if (isBlank(data, 12)) {
            errors.add("Registration date is required");
        } else if (isValidDate(data.get(12))) {
            errors.add("Registration date must be in format YYYY-MM-DD");
        }

        return errors;
    }
}
