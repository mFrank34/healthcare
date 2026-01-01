package Controllers;

import Validation.CliniciansValidator;
import Views.StaffForm;
import Models.Clinician;

// java imports
import java.util.List;

public class CliniciansController extends BaseController<Clinician> {
    private final StaffForm staffView;

    public CliniciansController(StaffForm view, Clinician model) {
        super(view, model, new CliniciansValidator());
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
                model.setTitle(data.get(7));
                model.setSpeciality(data.get(8));
                model.setGmc(data.get(9));
                model.setWorkplaceId(data.get(10));
                model.setType(data.get(11));
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
