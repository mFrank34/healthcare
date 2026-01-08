package views;

import controllers.FacilityController;
import factory.FormPanel;
import utilities.Constants;

public class FacilityView extends BaseView<FacilityController> {
    public FacilityView() {
        super("Facility Form", Constants.FACILITIES);
    }

    @Override
    public void setController(FacilityController controller) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }

}

