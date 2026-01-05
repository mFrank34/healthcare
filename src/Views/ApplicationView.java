package Views;

import Controllers.ApplicationController;
import FactoryUI.CenteredTab;
import FactoryUI.ManagementPanel;
import Utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApplicationView extends JFrame {
    private ApplicationController controller;
    private Runnable onCloseListener;

    public ApplicationView() {
        setTitle("Health Care Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setController(ApplicationController controller) {
        this.controller = controller;
        // add loader
        initComponents();
    }

    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setUI(new CenteredTab());
        ManagementPanel fab = new ManagementPanel();

        // Facility Management
        tabbedPane.addTab("Facility",
                fab.createManagementPanel(
                        "Facility Management",
                        Constants.FACILITIES,
                        controller.getFacilitiesData(),
                        () -> controller.addFacilities(),
                        () -> controller.editFacilities(),
                        () -> controller.removeFacilities(),
                        () -> controller.refreshFacilities()
                )
        );

        // Appointment Management
        tabbedPane.addTab("Appointments",
                fab.createManagementPanel(
                        "Appointment Management",
                        Constants.APPOINTMENTS,
                        controller.getAppointmentsData(),
                        () -> controller.addAppointment(),
                        () -> controller.editAppointment(),
                        () -> controller.removeAppointment(),
                        () -> controller.refreshAppointments()
                )
        );

        // Prescriptions
        tabbedPane.addTab("Prescriptions",
                fab.createManagementPanel(
                        "Prescription Management",
                        Constants.PRESCRIPTIONS,
                        controller.getPrescriptionsData(),
                        () -> controller.addPrescription(),
                        () -> controller.editPrescription(),
                        () -> controller.removePrescription(),
                        () -> controller.refreshPrescriptions()
                )
        );

        // Patients
        tabbedPane.addTab("Patients",
                fab.createManagementPanel(
                        "Patient Management",
                        Constants.PATIENTS,
                        controller.getPatientsData(),
                        () -> controller.addPatient(),
                        () -> controller.editPatient(),
                        () -> controller.removePatient(),
                        () -> controller.refreshPatients()
                )
        );

        // Clinicians
        tabbedPane.addTab("Clinicians",
                fab.createManagementPanel(
                        "Clinician Management",
                        Constants.CLINICIANS,
                        controller.getCliniciansData(),
                        () -> controller.addClinician(),
                        () -> controller.editClinician(),
                        () -> controller.removeClinician(),
                        () -> controller.refreshClinicians()
                )
        );

        // Staff
        tabbedPane.addTab("Staff",
                fab.createManagementPanel(
                        "Staff Management",
                        Constants.STAFF,
                        controller.getStaffData(),
                        () -> controller.addStaff(),
                        () -> controller.editStaff(),
                        () -> controller.removeStaff(),
                        () -> controller.refreshStaff()
                )
        );

        // Referrals
        tabbedPane.addTab("Referrals",
                fab.createManagementPanel(
                        "Referral Management",
                        Constants.REFERRALS,
                        controller.getReferralsData(),
                        () -> controller.addReferral(),
                        () -> controller.editReferral(),
                        () -> controller.removeReferral(),
                        () -> controller.refreshReferrals()
                )
        );

        add(tabbedPane);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (onCloseListener != null) {
                    onCloseListener.run();
                }
            }
        });
    }
}
