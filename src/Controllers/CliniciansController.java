package Controllers;

import Models.Clinician;
import Repository.ClinicianRepository;
import Utilities.Constants;
import Validation.ClinicianValidator;
import Views.ClinicianView;

import java.util.List;

public class CliniciansController {
    private Clinician model;
    private final ClinicianView view;
    private final ClinicianValidator validator;
    private final ClinicianRepository repo;

    public CliniciansController(
            Clinician model,
            ClinicianView view,
            ClinicianValidator validator,
            ClinicianRepository repo
    ) {
        this.model = model;
        this.view = view;
        this.validator = validator;
        this.repo = repo;
        view.setController(this);
    }

    public void handleSubmit() {
        List<String> data = view.getFormData();
        List<String> errors = validator.validate(data);

        if (!errors.isEmpty()) {
            view.showValidationErrors(errors);
            return;
        }

        model = repo.CreateAndAdd(data);
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
            view.setValue(i, filledForm[i]);
        }
    }
}
