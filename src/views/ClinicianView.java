package views;

import controllers.CliniciansController;
import factory.FormPanel;
import utilities.Constants;

public class ClinicianView extends BaseView<CliniciansController> {
    public ClinicianView() {
        super("Clinician Form", Constants.CLINICIANS);
    }

    @Override
    public void setController(CliniciansController controller) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }
}

