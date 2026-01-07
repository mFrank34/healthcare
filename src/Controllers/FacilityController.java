package Controllers;

import Models.Facility;
import Repository.FacilityRepository;
import Utilities.Constants;
import Validation.FacilityValidator;
import Views.FacilityView;

import java.util.List;

public class FacilityController {
    private Facility model;
    private final FacilityView view;
    private final FacilityValidator validator;
    private final FacilityRepository repository;

    public FacilityController(
            Facility facility,
            FacilityView view,
            FacilityValidator validator,
            FacilityRepository repository
    ) {
        this.model = facility;
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

        view.showSuccess(Constants.TITLE_SUCCESSFULLY);
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
