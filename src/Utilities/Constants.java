package Utilities;

public class Constants {

    // Staff columns
    public static final String[] STAFF = {
            "staff_id",
            "first_name",
            "last_name",
            "phone_number",
            "email",
            "employment_status",
            "start_date",
            "role",
            "department",
            "facility_id",
            "access_level",
            "line_manager"
    };

    // Referral columns
    public static final String[] REFERRALS = {
            "referral_id",
            "patient_id",
            "clinician_id",
            "referral_date",
            "referral_type",
            "referral_reason",
            "urgency_level",
            "referred_to_service",
            "referral_status",
            "appointment_date",
            "outcome_notes"
    };

    // Prescription columns
    public static final String[] PRESCRIPTIONS = {
            "prescription_id",
            "patient_id",
            "clinician_id",
            "appointment_id",
            "prescription_date",
            "medication_name",
            "dosage",
            "frequency",
            "duration_days",
            "quantity",
            "instructions",
            "pharmacy_name",
            "status"
    };

    // Patient columns
    public static final String[] PATIENTS = {
            "patient_id",
            "first_name",
            "last_name",
            "date_of_birth",
            "nhs_number",
            "gender",
            "phone_number",
            "email",
            "address",
            "postcode",
            "emergency_contact_name",
            "emergency_contact_phone",
            "registration_date",
            "gp_surgery_id"
    };

    // Facility columns
    public static final String[] FACILITIES = {
            "facility_id",
            "facility_name",
            "facility_type",
            "address",
            "postcode",
            "phone_number",
            "email",
            "opening_hours",
            "manager_name",
            "capacity",
            "specialities_offered"
    };

    // Clinician columns
    public static final String[] CLINICIANS = {
            "clinician_id",
            "first_name",
            "last_name",
            "title",
            "speciality",
            "gmc_number",
            "phone_number",
            "email",
            "workplace_id",
            "workplace_type",
            "employment_status",
            "start_date"
    };

    // Appointment columns
    public static final String[] APPOINTMENTS = {
            "appointment_id",
            "patient_id",
            "clinician_id",
            "facility_id",
            "appointment_date",
            "appointment_time",
            "duration_minutes",
            "appointment_type",
            "status",
            "reason_for_visit",
            "notes",
            "created_date",
            "last_modified"
    };

    // Private constructor to prevent instantiation
    private Constants() {
        throw new AssertionError("Cannot instantiate constants class");
    }
}
