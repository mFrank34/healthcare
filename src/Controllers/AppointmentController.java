package Controllers;

import Models.Appointment;
import Validation.AppointmentValidator;
import Views.AppointmentView;

public class AppointmentController {
    private final Appointment model;
    private final AppointmentView view;
    private final AppointmentValidator validator;

    public AppointmentController(Appointment model, AppointmentView view, AppointmentValidator validator) {
        this.model = model;
        this.view = view;
        this.validator = validator;
    }


}
