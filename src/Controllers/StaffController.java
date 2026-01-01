package Controllers;

import Views.StaffForm;
import Models.Staff;
import Validation.StaffValidator;

// java imports
import java.util.List;

public class StaffController extends BaseController<Staff> {
    private final StaffForm staffView;

    public StaffController(StaffForm view, Staff model) {
        super(view, model, new StaffValidator());
        this.staffView = view;

        view.addSubmitListener(e -> {
            List<String> data = view.getData();
            if (data.size() == 12) {
                model.setId(data.get(0));
                model.setFirst(data.get(1));
                model.setLast(data.get(2));
                model.setPhone(data.get(3));
                model.setEmail(data.get(4));
                model.setStartDate(data.get(5));
                model.setStatus(data.get(6));
                model.setRole(data.get(7));
                model.setDepartment(data.get(8));
                model.setFacility(data.get(9));
                model.setLineManager(data.get(10));
                model.setAccess(data.get(11));
            }
            handleSubmit();
        });
    }

    @Override
    protected void saveModel() {
        System.out.println("Staff saved: " + model.getFirst() + " " + model.getLast());
        staffView.dispose();
    }
}
