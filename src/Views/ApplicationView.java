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
    private JTabbedPane tabbedPane;

    // panel system
    private ManagementPanel facilityPanel;
    private ManagementPanel appointmentPanel;
    private ManagementPanel prescriptionPanel;
    private ManagementPanel patientPanel;
    private ManagementPanel clinicianPanel;
    private ManagementPanel staffPanel;
    private ManagementPanel referralPanel;

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
        tabbedPane = new JTabbedPane();

        facilityPanel = new ManagementPanel(
                "Facility Management",
                Constants.FACILITIES,
                controller.getFacilitiesData(),
                controller::addFacilities,
                controller::editFacilities,
                controller::removeFacilities,
                () -> facilityPanel.refresh(controller.getFacilitiesData())
        );
        tabbedPane.addTab("Facility", facilityPanel);

        appointmentPanel = new ManagementPanel(
                "Appointment Management",
                Constants.APPOINTMENTS,
                controller.getAppointmentsData(),
                controller::addAppointment,
                controller::editAppointment,
                controller::removeAppointment,
                () -> appointmentPanel.refresh(controller.getAppointmentsData())
        );
        tabbedPane.addTab("Appointments", appointmentPanel);

        prescriptionPanel = new ManagementPanel(
                "Prescription Management",
                Constants.PRESCRIPTIONS,
                controller.getPrescriptionsData(),
                controller::addPrescription,
                controller::editPrescription,
                controller::removePrescription,
                () -> prescriptionPanel.refresh(controller.getPrescriptionsData())
        );
        tabbedPane.addTab("Prescriptions", prescriptionPanel);

        patientPanel = new ManagementPanel(
                "Patient Management",
                Constants.PATIENTS,
                controller.getPatientsData(),
                controller::addPatient,
                controller::editPatient,
                controller::removePatient,
                () -> patientPanel.refresh(controller.getPatientsData())
        );
        tabbedPane.addTab("Patients", patientPanel);

        clinicianPanel = new ManagementPanel(
                "Clinician Management",
                Constants.CLINICIANS,
                controller.getCliniciansData(),
                controller::addClinician,
                controller::editClinician,
                controller::removeClinician,
                () -> clinicianPanel.refresh(controller.getCliniciansData())
        );
        tabbedPane.addTab("Clinicians", clinicianPanel);

        staffPanel = new ManagementPanel(
                "Staff Management",
                Constants.STAFF,
                controller.getStaffData(),
                controller::addStaff,
                controller::editStaff,
                controller::removeStaff,
                () -> staffPanel.refresh(controller.getStaffData())
        );
        tabbedPane.addTab("Staff", staffPanel);

        referralPanel = new ManagementPanel(
                "Referral Management",
                Constants.REFERRALS,
                controller.getReferralsData(),
                controller::addReferral,
                controller::editReferral,
                controller::removeReferral,
                () -> referralPanel.refresh(controller.getReferralsData())
        );
        tabbedPane.addTab("Referrals", referralPanel);

        add(tabbedPane);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (onCloseListener != null) {
                    onCloseListener.run();
                }
            }
        });
    }
}