package Controllers;


import Models.Application;
import Models.Appointment;
import Validation.AppointmentValidator;
import Views.ApplicationView;
import Views.AppointmentView;

import javax.security.auth.login.AccountNotFoundException;
import java.awt.*;

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
    }

    public void editFacilities() {
    }

    public void removeFacilities() {
    }

    // ==================== Appointment Management ====================

    public void addAppointment() {
        Appointment appointment = new Appointment();
        AppointmentView appointmentView = new AppointmentView();
        AppointmentValidator appointmentValidator = new AppointmentValidator();

        AppointmentController appointmentController = new AppointmentController(
                appointment, appointmentView, appointmentValidator, model.appointments);
    }

    public void editAppointment() {
    }

    public void removeAppointment() {
    }

    // ==================== Prescription Management ===================

    public void addPrescription() {
    }

    public void editPrescription() {
    }

    public void removePrescription() {
    }

    // ==================== Patient Management ========================

    public void addPatient() {
    }

    public void editPatient() {
    }

    public void removePatient() {
    }

    // ==================== Clinician Management =======================

    public void addClinician() {
    }

    public void editClinician() {
    }

    public void removeClinician() {
    }

    // ==================== Staff Management ===========================

    public void addStaff() {
    }

    public void editStaff() {
    }

    public void removeStaff() {
    }

    // ==================== Referral Management ========================

    public void addReferral() {
    }

    public void editReferral() {
    }

    public void removeReferral() {
    }
}