package Views;

import Controllers.ApplicationController;
import FactoryUI.ManagementPanel;
import Utilities.Constants;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * application view system with ui elements
 */
public class ApplicationView extends JFrame {
    private ApplicationController controller;
    private Runnable onCloseListener;

    /**
     * constructor for application view
     */
    public ApplicationView() {
        setTitle("Health Care Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * sets the controller for the model
     *
     * @param controller current controller for the view
     */
    public void setController(ApplicationController controller) {
        this.controller = controller;
        // add loader
        initComponents();
    }

    /**
     * initializes the tab components
     */
    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();
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
                        () -> controller.refreshAll()
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
                        () -> controller.refreshAll()
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
                        () -> controller.refreshAll()
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
                        () -> controller.refreshAll()
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
                        () -> controller.refreshAll()
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
                        () -> controller.refreshAll()
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
                        () -> controller.refreshAll()
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

    /**
     * refresh the init components section for full refresh
     */
    public void refreshAll() {
        initComponents();
    }
}