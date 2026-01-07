package Views;

import Controllers.AppointmentController;
import Controllers.StaffController;
import FactoryUI.FormPanel;
import Utilities.Constants;

public class StaffView extends BaseView<StaffController> {
    public StaffView() {
        super("Staff Form", Constants.STAFF);
    }

    public void setController(StaffController controller) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }
}