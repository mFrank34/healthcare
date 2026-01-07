package Controllers;

import Models.Referral;
import Repository.ReferralRepository;
import Utilities.Constants;
import Validation.ReferralValidator;
import Views.ReferralView;

import java.util.List;

public class ReferralController {
    private Referral model;
    private final ReferralView view;
    private final ReferralValidator validator;
    private final ReferralRepository repository;

    public ReferralController(
            Referral model,
            ReferralView view,
            ReferralValidator validator,
            ReferralRepository repository) {
        this.model = model;
        this.view = view;
        this.validator = validator;
        this.repository = repository;
        view.setController(this);
    }

    public void handleSubmit() {
        List<String> data = view.getFormData();
        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            view.showValidationErrors(errors);
            return;
        }

        model = repository.CreateAndAdd(data);
        System.out.println("Saving: " + model);

        view.showSuccess(Constants.MSG_APPOINTMENT_SAVED);
        view.clearForm();
    }

    public void handleCancel() {
        view.clearForm();
        view.dispose();
    }

    public void populate(String[] filledForm) {
        for (int i = 0; i < filledForm.length; i++) {
            view.setValue(i , filledForm[i]);
        }
    }
}
