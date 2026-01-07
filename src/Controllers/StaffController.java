package Controllers;

import Models.Staff;
import Repository.StaffRepository;
import Utilities.Constants;
import Validation.StaffValidator;
import Views.StaffView;

import java.util.List;

public class StaffController {

    private Staff model;
    private final StaffView view;
    private final StaffValidator validator;
    private final StaffRepository repository;

    public StaffController(
            Staff model,
            StaffView view,
            StaffValidator validator,
            StaffRepository repository) {
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
