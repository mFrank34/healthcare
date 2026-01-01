package Controllers;

import Views.PatientView;
import Models.Patient;
import Validation.PatientValidator;

// java imports
import java.util.List;

public class PatientController extends BaseController<Patient> {
    private final PatientView patientsView;

    public PatientController(PatientView view, Patient model) {
        super(view, model, new PatientValidator());
        this.patientsView = view;

        view.addSubmitListener(e -> {
            List<String> data = view.getData();
            if (data.size() == 14) {
                model.setId(data.get(0));
                model.setFirst(data.get(1));
                model.setLast(data.get(2));
                model.setPhone(data.get(3));
                model.setEmail(data.get(4));
                model.setRawNhsNumber(data.get(5));
                model.setGender(data.get(6).isEmpty() ? '\0' : data.get(6).charAt(0));
                model.setBirth(data.get(7));
                model.setAddress(data.get(8));
                model.setPostCode(data.get(9));
                model.setEmergencyName(data.get(10));
                model.setEmergencyNumber(data.get(11));
                model.setRegistration(data.get(12));
                model.setGpId(data.get(13));
            }
            handleSubmit();
        });
    }

    @Override
    protected void saveModel() {
        System.out.println("Patient saved: " + model.getFirst() + " " + model.getLast());
        patientsView.dispose();
    }
}
