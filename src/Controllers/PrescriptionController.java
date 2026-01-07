package Controllers;

import Models.Prescription;
import Repository.PrescriptionRepository;
import Utilities.Constants;
import Validation.PrescriptionValidator;
import Views.PrescriptionView;

import java.util.List;

public class PrescriptionController {
    private Prescription model;
    private final PrescriptionView view;
    private final PrescriptionValidator validator;
    private final PrescriptionRepository repository;

    public PrescriptionController(
            Prescription model,
            PrescriptionView view,
            PrescriptionValidator validator,
            PrescriptionRepository repository) {
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
