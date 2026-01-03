package Views;

import Controllers.ApplicationController;
import FactoryUI.TablePanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApplicationView extends JFrame {
    private ApplicationController controller;
    private Runnable onCloseListener;
    private TablePanel Constants;

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
        Object[][] facilitiesData = controller.getFacilitiesData();
        Object[][] appointmentsData = controller.getAppointmentsData();
        Object[][] prescriptionsData = controller.getPrescriptionsData();
        Object[][] patientsData = controller.getPatientsData();
        Object[][] cliniciansData = controller.getCliniciansData();
        Object[][] staffData = controller.getStaffData();
        Object[][] referralsData = controller.getReferralsData();

        // Create tabs with data
        tabbedPane.addTab("Facility",
                TablePanel.createTablePanel(Utilities.Constants.FACILITIES, facilitiesData));

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


}
