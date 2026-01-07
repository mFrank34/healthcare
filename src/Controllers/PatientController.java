package Controllers;

import Models.Patient;
import Repository.PatientRepository;
import Utilities.Constants;
import Validation.PatientValidator;
import Views.PatientView;

import java.util.List;

public class PatientController {
    private Patient model;
    private final PatientView view;
    private final PatientValidator validator;
    private final PatientRepository repository;

    public PatientController(
            Patient model,
            PatientView view,
            PatientValidator validator,
            PatientRepository repository
    ) {
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
            view.setValue(i, filledForm[i]);
        }
    }
}
