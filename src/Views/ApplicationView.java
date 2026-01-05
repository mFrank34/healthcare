package Views;

import Controllers.ApplicationController;
import FactoryUI.ActionButton;
import FactoryUI.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApplicationView extends JFrame {
    private ApplicationController controller;
    private Runnable onCloseListener;

    // Listener
    private Runnable refreshListener;
    private Runnable addPatientListener;
    private Runnable removePatientListener;
    private Runnable editPatientListener;

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

        // Get all data from controller first

        Object[][] appointmentsData = controller.getAppointmentsData();
        Object[][] prescriptionsData = controller.getPrescriptionsData();
        Object[][] patientsData = controller.getPatientsData();
        Object[][] cliniciansData = controller.getCliniciansData();
        Object[][] staffData = controller.getStaffData();
        Object[][] referralsData = controller.getReferralsData();

        // Create tabs with data
        tabbedPane.addTab("Facility", createFacilityPanel());

        tabbedPane.addTab("Appointment",
                TablePanel.createTablePanel(Utilities.Constants.APPOINTMENTS, appointmentsData));

        tabbedPane.addTab("Prescriptions",
                TablePanel.createTablePanel(Utilities.Constants.PRESCRIPTIONS, prescriptionsData));

        tabbedPane.addTab("Patients",
                TablePanel.createTablePanel(Utilities.Constants.PATIENTS, patientsData));

        tabbedPane.addTab("Clinicians",
                TablePanel.createTablePanel(Utilities.Constants.CLINICIANS, cliniciansData));

        tabbedPane.addTab("Staff",
                TablePanel.createTablePanel(Utilities.Constants.STAFF, staffData));

        tabbedPane.addTab("Referrals",
                TablePanel.createTablePanel(Utilities.Constants.REFERRALS, referralsData));

        add(tabbedPane);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (onCloseListener != null) {
                    onCloseListener.run();
                }
            }
        });

    }

    private JPanel createFacilityPanel() {
        // Boarder
        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10,10,10));

        // Title
        JLabel titleLabel = new JLabel("Facility Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Table
        Object[][] facilitiesData = controller.getFacilitiesData();
        panel.add(TablePanel.createTablePanel(Utilities.Constants.FACILITIES, facilitiesData));

        // Button interactions
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        ActionButton addPatientButton = new ActionButton("Add Patient");
        addPatientButton.addActionListener(e -> {
            if (addPatientListener != null) {
                addPatientListener.run();
            }
        });

        ActionButton editPatientButton = new ActionButton("Edit Patient");
        editPatientButton.addActionListener(e -> {
            if (editPatientListener != null) {
                editPatientListener.run();
            }
        });

        ActionButton removePatientButton = new ActionButton("Remove Patient");
        removePatientButton.addActionListener(e -> {
            if (removePatientListener != null) {
                removePatientListener.run();
            }
        });

        ActionButton refreshButton = new ActionButton("Refresh");
        refreshButton.addActionListener(e -> {
            if (refreshListener != null) {
                refreshListener.run();
            }
        });

        // adding buttons to panel
        buttonsPanel.add(addPatientButton);
        buttonsPanel.add(editPatientButton);
        buttonsPanel.add(removePatientButton);
        buttonsPanel.add(refreshButton);

        panel.add(buttonsPanel, BorderLayout.SOUTH);
        return panel;
    };

}
