package Views;

import Controllers.ReferralController;
import FactoryUI.FormPanel;
import Utilities.Constants;

public class ReferralView extends BaseView<ReferralController> {
    public ReferralView() {
        super("Referral Form", Constants.REFERRALS);
    }

    @Override
    protected void setController(ReferralController controller) {
        form = new FormPanel(labels);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }
}
