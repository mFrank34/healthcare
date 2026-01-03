package Models;

import Repository.*;

/**
 * Main system for the Health Care System
 * renamed to Application to find easier in file structor
 * all things are public due to creating own Repository Structor
 * for handling cvs files in own bubble, to help with read ability...
 */
public class Application {
    public AppointmentRepository appointments = new AppointmentRepository();
    public FacilityRepository facilities = new FacilityRepository();
    public PrescriptionRepository prescriptions = new PrescriptionRepository();
    public ReferralRepository referrals = new ReferralRepository();
    public StaffRepository staff = new StaffRepository();
    public PatientRepository patients = new PatientRepository();
    public ClinicianRepository clinicians = new ClinicianRepository();

    public Application() {

    }
}