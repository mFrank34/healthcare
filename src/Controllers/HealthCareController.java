package Controllers;

import Model.HealthCare;
import Views.HealthCareGUI;


/**
 * Creating main Application for project
 * for managing view and model of Main Application...
 */
public class HealthCareController {
    private HealthCare model;
    private HealthCareGUI view;

    public HealthCareController(HealthCare model, HealthCareGUI view) {
        this.model = model;
        this.view = view;
        initializeView();
        settingEventViewers();
    }

    /**
     * this Initial the view for person to see...
     * looking at the different in application tables...
     */
    private void initializeView()
    {

    }

    /**
     * Looking into the event views
     * controlling them for later use case...
     */
    private void settingEventViewers()
    {

    }
}
