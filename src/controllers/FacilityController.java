package controllers;

import models.Facility;
import repository.FacilityRepository;
import utilities.Constants;
import validation.FacilityValidator;
import views.FacilityView;

import java.util.List;

public class FacilityController {
    private Facility model;
    private final FacilityView view;
    private final FacilityValidator validator;
    private final FacilityRepository repository;

    /**
     * Public constructor for form menu
     * @param facility model of the appointment
     * @param view view of the appointment
     * @param validator validator for validating inputs
     * @param repository model store space in main application zone
     */
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

    /**
     * handling the submit button for the form window
     * and creating and adding the model to store
     */
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

    /**
     * handling the exit button on the form
     */
    public void handleCancel() {
        view.clearForm();
        view.dispose();
    }

    /**
     * populate form with a model
     * @param filledForm list of model data
     */
    public void populate(String[] filledForm) {
        for (int i = 0; i < filledForm.length; i++) {
            view.setValue(i, filledForm[i]);
        }
    }
}
