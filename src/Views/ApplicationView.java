package Views;

import Controllers.ApplicationController;
import FactoryUI.TablePanel;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApplicationView extends JFrame {
    private ApplicationController controller;
    private TablePanel table;

    ApplicationView() {
        setTitle("Bookshop Management System - MVC Architecture");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Facility Menu", table.createTablePanel(labels, ));
        tabbedPane.addTab("Appointment Menu", createOrdersPanel());
        tabbedPane.addTab("Prescriptions Menu", createSuppliersPanel());
        tabbedPane.addTab("Patients Menu", createSupplierOrdersPanel());
        tabbedPane.addTab("Clinicians Menu", createBooksPanel());
        tabbedPane.addTab("Staff Menu", createAuthorsPanel());
        tabbedPane.addTab("Referrals Menu", createAuthorsPanel());

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
