package Models;

import FileHandlers.Handler;
import java.util.ArrayList;
import java.util.HashMap;

public class Application {

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
    private HashMap<String, Appointment> appointments;
    private HashMap<String, Clinician> clinicians;
    private HashMap<String, Facility> facilities;
    private HashMap<String, Patient> patients;
    private HashMap<String, Prescription> prescriptions;
    private HashMap<String, Referral> referrals;
    private HashMap<String, Staff> staff;

    /**
     * Creates new Model with the current needed tables...
     */
    public Application() {
        appointments = new HashMap<String, Appointment>() ;
        clinicians = new HashMap<String, Clinician>();
        facilities = new HashMap<String, Facility>();
        patients = new HashMap<String, Patient>();
        prescriptions = new HashMap<String, Prescription>();
        referrals = new HashMap<String, Referral>();
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
     * Todo: complete appointment model
     */
    private void loadAppointments() {
        ArrayList<String> lines = Handler.readLines(LOCATION + APPOINTMENTS);
        for (String line : lines) {
            Appointment appointment = Appointment.fromCSV(line);
            appointments.put("empty sting", appointment);
        }
    }

    private void saveAppointments() {
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>(appointments.values());
        for (Appointment Entry : appointmentList) {
            lines.add(appointmentList.get(Entry).toCVS());
        }


    }


}
