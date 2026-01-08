package views;

import controllers.ReferralController;
import factory.FormPanel;
import utilities.Constants;

public class ReferralView extends BaseView<ReferralController> {
    public ReferralView() {
        super("Referral Form", Constants.REFERRALS);
    }

    @Override
    public void setController(ReferralController controller) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }
}
