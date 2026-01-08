package validation;

import utilities.Constants;
import utilities.Validator;
import java.util.ArrayList;
import java.util.List;

public class ReferralValidator implements Validator {

    @Override
    public List<String> validate(List<String> data) {
        List<String> errors = new ArrayList<>();

        // Generic required-field check
        for (int i = 0; i < data.size(); i++) {
            // Skip special fields (referral_date, priority, status)
            if (i == 3 || i == 6 || i == 7) continue;

            if (isBlank(data, i)) {
                errors.add(Constants.REFERRALS[i] + " is required");
            }
        }

        // referral_date -> index 3
        if (isBlank(data, 3)) {
            errors.add("Referral date is required");
        } else if (isValidDate(data.get(3))) {
            errors.add("Referral date must be in format YYYY-MM-DD");
        }

        // priority -> index 6
        if (isBlank(data, 6)) {
            errors.add("Priority is required");
        } else {
            String p = data.get(6).trim().toLowerCase();
            if (!p.equals("low") && !p.equals("medium") && !p.equals("high") && !p.equals("urgent")) {
                errors.add("Priority must be Low, Medium, High, or Urgent");
            }
        }

        // status -> index 7
        if (isBlank(data, 7)) {
            errors.add("Status is required");
        } else {
            String s = data.get(7).trim().toLowerCase();
            if (!s.equals("pending") && !s.equals("accepted") && !s.equals("rejected") && !s.equals("completed")) {
                errors.add("Status must be Pending, Accepted, Rejected, or Completed");
            }
        }

        return errors;
    }
}
