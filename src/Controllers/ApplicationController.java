package Controllers;


import Models.Application;
import Views.ApplicationView;

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

        initializeView();
        setupEventViewers();
    }

    /**
     * this Initial the view for person to see...
     * looking at the different in application tables...
     */
    private void initializeView() {
    }

    /**
     * Looking into the event views
     * controlling them for later use case...
     */
    private void setupEventViewers() {

    }

    // data handlers
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

    public void addFacilities() {
    }

    public void editFacilities() {
    }

    public void removeFacilities() {
    }

    public void refreshFacilities() {
    }

    public void addAppointment() {
    }

    public void editAppointment() {
    }

    public void removeAppointment() {
    }

    public void refreshAppointments() {
    }

    public void addPrescription() {
    }

    public void editPrescription() {
    }

    public void removePrescription() {
    }

    public void refreshPrescriptions() {
    }

    public void addPatient() {
    }

    public void editPatient() {
    }

    public void removePatient() {
    }

    public void refreshPatients() {
    }

    public void addClinician() {
    }

    public void editClinician() {
    }

    public void removeClinician() {
    }

    public void refreshClinicians() {
    }

    public void addStaff() {
    }

    public void editStaff() {
    }

    public void removeStaff() {
    }

    public void refreshStaff() {
    }

    public void addReferral() {
    }

    public void editReferral() {
    }

    public void removeReferral() {
    }

    public void refreshReferrals() {
    }
}