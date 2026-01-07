package Views;

import Controllers.PrescriptionController;
import FactoryUI.FormPanel;
import Utilities.Constants;

public class PrescriptionView extends BaseView<PrescriptionController> {
    public PrescriptionView() {
        super("Prescriptions Form", Constants.PRESCRIPTIONS);
    }

    @Override
    public void setController(PrescriptionController controller) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }

}

