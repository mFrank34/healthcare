package Controllers;


import Models.Application;
import Views.ApplicationView;

/**
 * Creating main Application for project
 * for managing view and model of Main Application...
 */
public class ApplicationController {
    private Application model;
    private ApplicationView view;

    public ApplicationController(Application model, ApplicationView view) {
        this.model = model;
        this.view = view;


        initializeView();
        setupEventViewers();
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
    private void setupEventViewers()
    {

    }
}


// RefreshTable
//