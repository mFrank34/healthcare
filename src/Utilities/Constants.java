package Utilities;

/**
 * Constance that used within the program that don't change at all like table headers or cvs headers
 * makes it easier to manage if something need to made change like tables load in wrong order, somewhat
 * repaired here
 */
public class Constants {

    // Staff columns
    public static final String[] STAFF = {
            "Staff ID",
            "First Name",
            "Last Name",
            "Role",
            "Department",
            "Facility ID",
            "Phone Number",
            "Email",
            "Employment Status",
            "Start Date",
            "Line Manager",
            "Access Level"
    };

    // Referral columns
    public static final String[] REFERRALS = {
            "referral_id",
            "patient_id",
            "referring_clinician_id",
            "referred_to_clinician_id",
            "referring_facility_id",
            "referred_to_facility_id",
            "referral_date",
            "urgency_level",
            "referral_reason",
            "clinical_summary",
            "requested_investigations",
            "status",
            "appointment_id",
            "notes",
            "created_date",
            "last_updated"
    };

    // Prescription columns
    public static final String[] PRESCRIPTIONS = {
            "Prescription ID",
            "Patient ID",
            "Clinician ID",
            "Appointment ID",
            "Prescription Date",
            "Medication Name",
            "Dosage",
            "Frequency",
            "Duration (Days)",
            "Quantity",
            "Instructions",
            "Pharmacy Name",
            "Status",
            "Issue Date",
            "Collection Date"
    };

    // Patient columns
    public static final String[] PATIENTS = {
            "Patient ID",
            "First Name",
            "Last Name",
            "Date of Birth",
            "NHS Number",
            "Gender",
            "Phone Number",
            "Email",
            "Address",
            "Postcode",
            "Emergency Contact Name",
            "Emergency Contact Phone",
            "Registration Date",
            "GP Surgery ID"
    };

    // Facility columns
    public static final String[] FACILITIES = {
            "Facility ID",
            "Facility Name",
            "Facility Type",
            "Address",
            "Postcode",
            "Phone Number",
            "Email",
            "Opening Hours",
            "Manager Name",
            "Capacity",
            "Specialities Offered"
    };

    // Clinician columns
    public static final String[] CLINICIANS = {
            "Clinician ID",
            "First Name",
            "Last Name",
            "Title",
            "Speciality",
            "GMC Number",
            "Phone Number",
            "Email",
            "Workplace ID",
            "Workplace Type",
            "Employment Status",
            "Start Date"
    };

    // Appointment columns
    public static final String[] APPOINTMENTS = {
            "Appointment ID",
            "Patient ID",
            "Clinician ID",
            "Facility ID",
            "Appointment Date",
            "Appointment Time",
            "Duration (Minutes)",
            "Appointment Type",
            "Status",
            "Reason for Visit",
            "Notes",
            "Created Date",
            "Last Modified"
    };

    public static final String TITLE_SUCCESS = "Success";
    public static final String TITLE_VALIDATION_ERRORS = "Validation Errors";
    public static final String TITLE_SUCCESSFULLY = "Saved successfully!";

    /**
     * private constructor to prevent initialization as nothing should create this class
     */
    private Constants() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}
