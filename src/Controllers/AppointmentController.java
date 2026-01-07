package Controllers;

import Models.Appointment;
import Repository.AppointmentRepository;
import Validation.AppointmentValidator;
import Views.AppointmentView;
import Utilities.Constants;

import java.util.List;

public class AppointmentController {

    private Appointment model;
    private final AppointmentView view;
    private final AppointmentValidator validator;
    private final AppointmentRepository repository;

    public AppointmentController(Appointment model, AppointmentView view, AppointmentValidator validator, AppointmentRepository repository) {
        this.model = model;
        this.view = view;
        this.validator = validator;
        this.repository = repository;
        view.setController(this);
    }

    public void handleSubmit() {
        List<String> data = view.getFormData();

        for (int i = 0; i < data.size(); i++) {
            System.out.println(i + " -> [" + data.get(i) + "]");
        }

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
        view.setVisible(false);
    }
}
