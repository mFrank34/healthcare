package Launcher;

import javax.swing.*;

import Controllers.ApplicationController;
import Models.Application;
import Views.ApplicationView;

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
        Application model = new Application();
        System.out.println("Generated HealthCare model...");

        // generate view
        ApplicationView view = new ApplicationView();
        System.out.println("Generated HealthCare View...");

        // Create Constructor for project
        ApplicationController controller = new ApplicationController(model, view);
        System.out.println("Created HealthCare Controller...");

        // Set controller into view
        view.setVisible(true);
        System.out.println("application Running...");
    }
}
