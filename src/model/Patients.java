package model;

public class Patients extends Person {
    private int nhs_number;
    private char gender;
    private String birth;
    private String address;
    private String postCode;
    private String emergencyNumber;
    private String emergencyName;
    private String registration;
    private String gpId;

    public Patients() {
    }

    public Patients(String id, String first, String last, String phone, String email, int nhs_number, char gender,
            String birth, String address, String postCode, String emergencyNumber, String registration, String gpId,
            String emergencyName) {
        super(id, first, last, phone, email);
        this.nhs_number = nhs_number;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.postCode = postCode;
        this.emergencyNumber = emergencyNumber;
        this.emergencyName = emergencyName;
        this.registration = registration;
        this.gpId = gpId;
    }

    public int getNhs_number() {
        return nhs_number;
    }

    public void setNhs_number(int nhs_number) {
        this.nhs_number = nhs_number;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getGpId() {
        return gpId;
    }

    public void setGpId(String gpId) {
        this.gpId = gpId;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

}
