package views;

import controllers.AppointmentController;
import factory.FormPanel;
import utilities.Constants;

public class AppointmentView extends BaseView<AppointmentController> {
    public AppointmentView() {
        super("Appointment From", Constants.APPOINTMENTS);
    }

    @Override
    public void setController(AppointmentController controller) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }
}

