package Models;

public class Patient extends Person {
    private String patientId;
    private String dateOfBirth;
    private String nhsNumber;
    private String gender;
    private String address;
    private String postcode;
    private String EmergencyContactName;
    private String EmergencyContactPhone;
    private String RegistrationDate;
    private String GpSurgeryId;

    public Patient() {
    }

    public Patient(String patientId, String firstName, String lastName, String phoneNumber, String email,
                   String dateOfBirth, String nhsNumber, String gender, String address, String postcode, String EmergencyContactName,
                   String EmergencyContactPhone, String RegistrationDate, String GpSurgeryId) {
        super(firstName, lastName, phoneNumber, email);
        this.patientId = patientId;
        this.dateOfBirth = dateOfBirth;
        this.nhsNumber = nhsNumber;
        this.gender = gender;
        this.address = address;
        this.postcode = postcode;
        this.EmergencyContactName = EmergencyContactName;
        this.EmergencyContactPhone = EmergencyContactPhone;
        this.RegistrationDate = RegistrationDate;
        this.GpSurgeryId = GpSurgeryId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmergencyContactName() {
        return EmergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        EmergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhone() {
        return EmergencyContactPhone;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        EmergencyContactPhone = emergencyContactPhone;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getGpSurgeryId() {
        return GpSurgeryId;
    }

    public void setGpSurgeryId(String gpSurgeryId) {
        GpSurgeryId = gpSurgeryId;
    }
}