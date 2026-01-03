package Launcher;

import Controllers.ApplicationController;
import Models.Application;
import Views.ApplicationView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeApplication();
            }
        });
    }

    private static void initializeApplication() {
        System.out.println("Application system Starting...");

        // generate model
        Application model = new Application();
        System.out.println("Generated Application Model...");

        // generate view
        ApplicationView view = new ApplicationView();
        System.out.println("Generated Application View...");

        // Create Constructor for project
        ApplicationController controller = new ApplicationController(model, view);
        System.out.println("Created Application Controller...");

        // Set controller into view
        view.setVisible(true);
        System.out.println("Application Running...");
    }
}
