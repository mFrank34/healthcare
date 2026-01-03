package Models;

public class Staff extends Employee {
    private String role;
    private String department;
    private String facilityId;
    private String accessLevel;
    private String lineManager;   // Only for staff

    public Staff() {
    }

    public Staff(String staffId, String firstName, String lastName, String phoneNumber, String email,
                 String employmentStatus, String startDate, String role, String department,
                 String facilityId, String accessLevel, String lineManager) {
        super(staffId, firstName, lastName, phoneNumber, email, employmentStatus, startDate);
        this.role = role;
        this.department = department;
        this.facilityId = facilityId;
        this.accessLevel = accessLevel;
        this.lineManager = lineManager;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getLineManager() {
        return lineManager;
    }

    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }
}