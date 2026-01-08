package validation;

import utilities.Constants;
import utilities.Validator;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // Generic required-field check
        for (int i = 0; i < data.size(); i++) {
            // Skip special fields (date fields + numeric fields)
            if (i == 4 || i == 8 || i == 13 || i == 14) continue;

            if (isBlank(data, i)) {
                errors.add(Constants.PRESCRIPTIONS[i] + " is required");
            }
        }

        // prescription_date -> index 4
        if (isBlank(data, 4)) {
            errors.add("Prescription date is required");
        } else if (isValidDate(data.get(4))) {
            errors.add("Prescription date must be in format YYYY-MM-DD");
        }

        // duration_days -> index 8
        if (isBlank(data, 8)) {
            errors.add("Duration days is required");
        } else if (isNumeric(data.get(8))) {
            errors.add("Duration days must be a number");
        } else if (Integer.parseInt(data.get(8)) <= 0) {
            errors.add("Duration days must be greater than 0");
        }

        // issue_date -> index 13 (optional but must be valid if present)
        if (!isBlank(data, 13)) {
            if (isValidDate(data.get(13))) {
                errors.add("Issue date must be in format YYYY-MM-DD");
            }
        }

        // collection_date -> index 14 (optional but must be valid if present)
        if (!isBlank(data, 14)) {
            if (isValidDate(data.get(14))) {
                errors.add("Collection date must be in format YYYY-MM-DD");
            }
        }

        return errors;
    }
}
