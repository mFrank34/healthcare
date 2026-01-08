package controllers;

import models.Clinician;
import repository.ClinicianRepository;
import utilities.Constants;
import validation.ClinicianValidator;
import views.ClinicianView;

import java.util.List;

public class CliniciansController {
    private Clinician model;
    private final ClinicianView view;
    private final ClinicianValidator validator;
    private final ClinicianRepository repo;

    /**
     * Public constructor for form menu
     * @param model model of the appointment
     * @param view view of the appointment
     * @param validator validator for validating inputs
     * @param repo model store space in main application zone
     */
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

        model = repo.CreateAndAdd(data);
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
