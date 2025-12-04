package Model;

import FileHandler.CSVHandler;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthCare {

    /**
     * File Locations for application...
     */
    private final String LOCATION = "Files/";
    // models sections
    private final String APPOINTMENTS = "appointment.csv";
    private final String CLINICIANS = "clinicians.csv";
    private final String FACILITIES = "facilities.csv";
    private final String PATIENTS = "patients.csv";
    private final String PRESCRIPTIONS = "prescriptions.csv";
    private final String REFERRALS = "referrals.csv";
    private final String STAFF = "staff.csv";

    /**
     * storing data in memory for use within application
     * TODO - Complete Referrals...
     */
    private HashMap<String, Appointments> appointments;
    private HashMap<String, Clinicians> clinicians;
    private HashMap<String, Facilities> facilities;
    private HashMap<String, Patients> patients;
    private HashMap<String, Prescription> prescriptions;
    private HashMap<String, Referrals> referrals;
    private HashMap<String, Staff> staff;

    /**
     * Creates new Model with the current needed tables...
     */
    public HealthCare() {
        appointments = new HashMap<String, Appointments>() ;
        clinicians = new HashMap<String, Clinicians>();
        facilities = new HashMap<String, Facilities>();
        patients = new HashMap<String, Patients>();
        prescriptions = new HashMap<String, Prescription>();
        referrals = new HashMap<String, Referrals>();
        staff = new HashMap<String, Staff>();
        loadAllData();
    }

    /**
     * Loads data from file to memory...
     */
    public void loadAllData() {

    }

    /**
     * saving data to the file that record data instance...
     */
    public void saveAllData() {

    }

    /**
     * appointment System for collecting data around appointments
     */
    private void loadAppointments() {
        ArrayList<String> lines = CSVHandler.readLines(LOCATION + APPOINTMENTS);
        for (int index = 0; index < lines.size(); index++) {
            Appointments appointment = Appointments.fromCSV(lines.get(index));
            appointments.put();
    }

}
