package views;

import controllers.PatientController;
import factory.FormPanel;
import utilities.Constants;

public class PatientView extends BaseView<PatientController> {
    public PatientView() {
        super("Patients Form", Constants.PATIENTS);
    }

    @Override
    public void setController(PatientController controller ) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }
}