package launcher;

import controllers.ApplicationController;
import models.Application;
import views.ApplicationView;

import javax.swing.*;

/**
 * the main application runtime
 */
public class App {
    /**
     * runs the application
     * @param args we don't use this, but useful if you want to run it with parameters
     */
    static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initializeApplication();
            }
        });
    }

    /**
     * code the connects the application controller to the model and view
     */
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
