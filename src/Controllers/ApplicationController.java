package Controllers;

import Models.*;
import Validation.*;
import Views.*;

/**
 * Creating main Application for project
 * for managing view and model of Main Application...
 */
public class ApplicationController {
    private final Application model;
    private final ApplicationView view;

    public ApplicationController(Application model, ApplicationView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    public Object[][] getCliniciansData() {
        return model.clinicians.toTableData();
    }

    public Object[][] getFacilitiesData() {
        return model.facilities.toTableData();
    }

    public Object[][] getAppointmentsData() {
        return model.appointments.toTableData();
    }

    public Object[][] getPrescriptionsData() {
        return model.prescriptions.toTableData();
    }

    public Object[][] getPatientsData() {
        return model.patients.toTableData();
    }

    public Object[][] getStaffData() {
        return model.staff.toTableData();
    }

    public Object[][] getReferralsData() {
        return model.referrals.toTableData();
    }

    // ==================== Facility Management =======================

    public void addFacilities() {
        Facility facility = new Facility();

        FacilityView facilityView = new FacilityView();
        FacilityValidator validator = new FacilityValidator();

        FacilityController controller = new FacilityController(
                facility, facilityView, validator, model.facilities
        );
        facilityView.setVisible(true);
        view.refresh();
    }

    public void editFacilities() {
        String id = view.getSelectedFacility();
        Facility facility = model.facilities.getById(id);
        String[] filledForm = model.facilities.toList(facility);

        FacilityView facilityView = new FacilityView();
        FacilityValidator validator = new FacilityValidator();

        FacilityController controller = new FacilityController(
                facility, facilityView, validator, model.facilities
        );

        controller.populate(filledForm);
        facilityView.setVisible(true);
        view.refresh();
    }

    public void removeFacilities() {
        String id = view.getSelectedFacility();
        model.facilities.remove(id);
        view.refresh();
    }

    // ==================== Appointment Management ====================

    public void addAppointment() {
        Appointment appointments = new Appointment();

        AppointmentView appointmentView = new AppointmentView();
        AppointmentValidator appointmentValidator = new AppointmentValidator();

        AppointmentController controller = new AppointmentController(
                appointments, appointmentView, appointmentValidator, model.appointments
        );

        appointmentView.setVisible(true);
        view.refresh();
    }

    public void editAppointment() {
        String id = view.getSelectedAppointment();

        Appointment appointment = model.appointments.getById(id);
        String[] filledForm = model.appointments.toList(appointment);
        model.appointments.remove(id);

        AppointmentView appointmentView = new AppointmentView();
        AppointmentValidator appointmentValidator = new AppointmentValidator();

        AppointmentController controller = new AppointmentController(
                appointment, appointmentView, appointmentValidator, model.appointments
        );

        controller.populate(filledForm);
        appointmentView.setVisible(true);

        view.refresh();
    }

    public void removeAppointment() {
         String id = view.getSelectedAppointment();
         model.appointments.remove(id);
         view.refresh();
    }

    // ==================== Prescription Management ===================

    public void addPrescription() {
        Prescription prescription = new Prescription();

        PrescriptionView prescriptionView = new PrescriptionView();
        PrescriptionValidator prescriptionValidator = new PrescriptionValidator();

        PrescriptionController Controller = new PrescriptionController(
                prescription, prescriptionView, prescriptionValidator, model.prescriptions
        );

        prescriptionView.setVisible(true);
        view.refresh();
    }

    public void editPrescription() {
        String id = view.getSelectedPrescription();
        Prescription prescription = model.prescriptions.getById(id);
        String[] filledForm = model.prescriptions.toList(prescription);

        PrescriptionView prescriptionView = new PrescriptionView();
        PrescriptionValidator prescriptionValidator = new PrescriptionValidator();

        PrescriptionController Controller = new PrescriptionController(
                prescription, prescriptionView, prescriptionValidator, model.prescriptions
        );

        Controller.populate(filledForm);
        prescriptionView.setVisible(true);
        view.refresh();
    }

    public void removePrescription() {
        String id = view.getSelectedPrescription();
        model.prescriptions.remove(id);
        view.refresh();
    }

    // ==================== Patient Management ========================

    public void addPatient() {
        Patient patient = new Patient();

        PatientView patientView = new PatientView();
        PatientValidator patientValidator = new PatientValidator();

        PatientController Controller = new PatientController(
                patient, patientView, patientValidator, model.patients
        );

        patientView.setVisible(true);
        view.refresh();
    }

    public void editPatient() {
        String id = view.getSelectedPatient();
        Patient patient = model.patients.getById(id);
        String[] filledForm = model.patients.toList(patient);

        PatientView patientView = new PatientView();
        PatientValidator patientValidator = new PatientValidator();

        PatientController controller = new PatientController(
                patient, patientView, patientValidator, model.patients
        );

        controller.populate(filledForm);
        patientView.setVisible(true);
        view.refresh();
    }

    public void removePatient() {
        String id = view.getSelectedPatient();
        model.patients.remove(id);
        view.refresh();
    }

    // ==================== Clinician Management =======================

    public void addClinician() {
        Clinician clinician = new Clinician();

        ClinicianView clinicianView = new ClinicianView();
        ClinicianValidator clinicianValidator = new ClinicianValidator();

        CliniciansController Controller = new CliniciansController(
                clinician, clinicianView, clinicianValidator, model.clinicians
        );
        clinicianView.setVisible(true);
        view.refresh();
    }

    public void editClinician() {
        String id = view.getSelectedClinician();
        Clinician clinician = model.clinicians.getById(id);
        String[] filledForm = model.clinicians.toList(clinician);

        ClinicianView clinicianView = new ClinicianView();
        ClinicianValidator clinicianValidator = new ClinicianValidator();

        CliniciansController controller = new CliniciansController(
                clinician, clinicianView, clinicianValidator, model.clinicians
        );

        controller.populate(filledForm);
        clinicianView.setVisible(true);
        view.refresh();
    }

    public void removeClinician() {
        String id = view.getSelectedClinician();
        model.clinicians.remove(id);
        view.refresh();
    }

    // ==================== Staff Management ===========================

    public void addStaff() {
        Staff staff = new Staff();

        StaffView staffView = new StaffView();
        StaffValidator staffValidator = new StaffValidator();

        StaffController Controller = new StaffController(
                staff, staffView, staffValidator, model.staff
        );

        staffView.setVisible(true);
        view.refresh();
    }

    public void editStaff() {
        String id = view.getSelectedStaff();
        Staff staff = model.staff.getById(id);
        String[] filledForm = model.staff.toList(staff);

        StaffView staffView = new StaffView();
        StaffValidator staffValidator = new StaffValidator();

        StaffController controller = new StaffController(
                staff, staffView, staffValidator, model.staff
        );

        controller.populate(filledForm);
        staffView.setVisible(true);
        view.refresh();
    }

    public void removeStaff() {
        String id = view.getSelectedStaff();
        model.staff.remove(id);
        view.refresh();
    }

    // ==================== Referral Management ========================

    public void addReferral() {
        Referral referral = new Referral();

        ReferralView referralView = new ReferralView();
        ReferralValidator referralValidator = new ReferralValidator();

        ReferralController Controller = new ReferralController(
                referral, referralView, referralValidator, model.referrals
        );

        referralView.setVisible(true);
        view.refresh();
    }

    public void editReferral() {
        String id = view.getSelectedReferral();
        Referral referral = model.referrals.getById(id);
        String[] filledForm = model.referrals.toList(referral);

        ReferralView referralView = new ReferralView();
        ReferralValidator referralValidator = new ReferralValidator();

        ReferralController controller = new ReferralController(
                referral, referralView, referralValidator, model.referrals
        );

        controller.populate(filledForm);
        referralView.setVisible(true);
        view.refresh();
    }

    public void removeReferral() {
        String id = view.getSelectedReferral();
        model.referrals.remove(id);
        view.refresh();
    }
}