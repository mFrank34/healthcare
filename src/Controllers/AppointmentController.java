package Controllers;

import Models.Appointment;
import Validation.AppointmentValidator;
import Views.AppointmentView;

import java.util.List;
import java.util.Map;

public class AppointmentController {
    private final Appointment model;
    private final AppointmentView view;
    private final AppointmentValidator validator;

    public AppointmentController(Appointment model, AppointmentView view, AppointmentValidator validator) {
        this.model = model;
        this.view = view;
        this.validator = validator;
    }

    public void handleSubmit() {
        // Get data from view
        Map<String, String> formData = view.getFormPanel().getAllData();

        // Validate data
        List<String> errors = validator.validate(formData);

        if (!errors.isEmpty()) {
            view.showValidationErrors(errors);
            return;
        }

        // Update model
        try {
            model.setPatientName(formData.get("Patient Name"));
            model.setDoctorName(formData.get("Doctor Name"));
            model.setDate(formData.get("Date"));
            model.setTime(formData.get("Time"));
            model.setReason(formData.get("Reason"));

            // Save to database or perform business logic
            saveAppointment();

            view.showSuccess("Appointment saved successfully!");
            view.clearForm();
        } catch (Exception e) {
            view.showError("Error saving appointment: " + e.getMessage());
        }
    }

    public void handleCancel() {
        view.clearForm();
    }

    public void loadAppointment(int appointmentId) {
        // Load from database and populate view
        // This is just an example
        view.getFormPanel().setValue("Patient Name", model.getPatientName());
        view.getFormPanel().setValue("Doctor Name", model.getDoctorName());
        view.getFormPanel().setValue("Date", model.getDate());
        view.getFormPanel().setValue("Time", model.getTime());
        view.getFormPanel().setValue("Reason", model.getReason());
    }

    private void saveAppointment() {
        // Database save logic here
        System.out.println("Saving appointment: " + model);
    }
}