package Launcher;

import javax.swing.*;

import Controllers.HealthCareController;
import Model.HealthCare;
import Views.HealthCareGUI;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeApplication();
            }
        });
    }

    private static void initializeApplication() {
        System.out.println("Health Care system Starting...");

        // generate model
        HealthCare model = new HealthCare();
        System.out.println("Generated HealthCare model...");

        // generate view
        HealthCareGUI view = new HealthCareGUI();
        System.out.println("Generated HealthCare View...");

        // Create Constructor for project
        HealthCareController controller = new HealthCareController(model, view);
        System.out.println("Created HealthCare Controller...");

        // Set controller into view
        view.setVisible(true);
        System.out.println("application Running...");
    }
}
