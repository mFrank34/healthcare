package models;

public class Clinician extends Employee {
    private String title;
    private String speciality;
    private String gmcNumber;
    private String workplaceId;
    private String workplaceType;

    public Clinician() {
    }

    public Clinician(String staffId, String firstName, String lastName, String phoneNumber, String email,
                     String employmentStatus, String startDate, String title, String speciality,
                     String gmcNumber, String workplaceId, String workplaceType) {

        super(staffId, firstName, lastName, phoneNumber, email, employmentStatus, startDate);
        this.title = title;
        this.speciality = speciality;
        this.gmcNumber = gmcNumber;
        this.workplaceId = workplaceId;
        this.workplaceType = workplaceType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGmcNumber() {
        return gmcNumber;
    }

    public void setGmcNumber(String gmcNumber) {
        this.gmcNumber = gmcNumber;
    }

    public String getWorkplaceId() {
        return workplaceId;
    }

    public void setWorkplaceId(String workplaceId) {
        this.workplaceId = workplaceId;
    }

    public String getWorkplaceType() {
        return workplaceType;
    }

    public void setWorkplaceType(String workplaceType) {
        this.workplaceType = workplaceType;
    }
}