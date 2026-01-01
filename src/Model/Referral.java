package Model;

public class Referral {
    private String referralId;
    private String patientId;
    private String clinicianId;
    private String referralDate;
    private String referralType;
    private String referralReason;
    private String urgencyLevel;
    private String referredToService;
    private String referralStatus;
    private String appointmentDate;
    private String outcomeNotes;

    public Referral() {}

    public Referral(String referralId, String patientId, String clinicianId, String referralDate, String referralType,
                    String referralReason, String urgencyLevel, String referredToService, String referralStatus,
                    String appointmentDate, String outcomeNotes) {
        this.referralId = referralId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.referralDate = referralDate;
        this.referralType = referralType;
        this.referralReason = referralReason;
        this.urgencyLevel = urgencyLevel;
        this.referredToService = referredToService;
        this.referralStatus = referralStatus;
        this.appointmentDate = appointmentDate;
        this.outcomeNotes = outcomeNotes;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getClinicianId() {
        return clinicianId;
    }

    public void setClinicianId(String clinicianId) {
        this.clinicianId = clinicianId;
    }

    public String getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(String referralDate) {
        this.referralDate = referralDate;
    }

    public String getReferralType() {
        return referralType;
    }

    public void setReferralType(String referralType) {
        this.referralType = referralType;
    }

    public String getReferralReason() {
        return referralReason;
    }

    public void setReferralReason(String referralReason) {
        this.referralReason = referralReason;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getReferredToService() {
        return referredToService;
    }

    public void setReferredToService(String referredToService) {
        this.referredToService = referredToService;
    }

    public String getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(String referralStatus) {
        this.referralStatus = referralStatus;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getOutcomeNotes() {
        return outcomeNotes;
    }

    public void setOutcomeNotes(String outcomeNotes) {
        this.outcomeNotes = outcomeNotes;
    }
}
