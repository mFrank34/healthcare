package Controllers;

import Models.Clinician;
import Repository.ClinicianRepository;
import Validation.ClinicianValidator;
import Views.ClinicianView;

public class CliniciansController {
    private Clinician model;
    private final ClinicianView view;
    private final ClinicianValidator validator;
    private final ClinicianRepository repo;

    public CliniciansController(
            Clinician model,
            ClinicianView view,
            ClinicianValidator validator,
            ClinicianRepository repo
    ) {
        this.model = model;
        this.view = view;
        this.validator = validator;
        this.repo = repo;
        view.setController(this);
    }

    public void handleSubmit() {
    }

    public void handleCancel() {
    }
}
