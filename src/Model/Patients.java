package Model;

public class Patients extends Person {
    private int nhsNumber;
    private String RawNhsNumber;
    private char gender;
    private String birth;
    private String address;
    private String postCode;
    private String emergencyNumber;
    private String emergencyName;
    private String registration;
    private String gpId;

    public Patients() {}

    public Patients(String id, String first, String last, String phone, String email,
                    int nhsNumber, char gender, String birth, String address, String postCode,
                    String emergencyName, String emergencyNumber, String registration, String gpId) {
        super(id, first, last, phone, email);
        this.nhsNumber = nhsNumber;
        this.gender = gender;
        this.birth = birth;
        this.address = address;
        this.postCode = postCode;
        this.emergencyName = emergencyName;
        this.emergencyNumber = emergencyNumber;
        this.registration = registration;
        this.gpId = gpId;
    }

    // Getters and setters
    public int getNhsNumber() { return nhsNumber; }
    public void setNhsNumber(int nhsNumber) { this.nhsNumber = nhsNumber; }

    public char getGender() { return gender; }
    public void setGender(char gender) { this.gender = gender; }

    public String getBirth() { return birth; }
    public void setBirth(String birth) { this.birth = birth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPostCode() { return postCode; }
    public void setPostCode(String postCode) { this.postCode = postCode; }

    public String getEmergencyName() { return emergencyName; }
    public void setEmergencyName(String emergencyName) { this.emergencyName = emergencyName; }

    public String getEmergencyNumber() { return emergencyNumber; }
    public void setEmergencyNumber(String emergencyNumber) { this.emergencyNumber = emergencyNumber; }

    public String getRegistration() { return registration; }
    public void setRegistration(String registration) { this.registration = registration; }

    public String getGpId() { return gpId; }
    public void setGpId(String gpId) { this.gpId = gpId; }

    public String getRawNhsNumber() {
        return RawNhsNumber;
    }

    public void setRawNhsNumber(String rawNhsNumber) {
        RawNhsNumber = rawNhsNumber;
    }
}
