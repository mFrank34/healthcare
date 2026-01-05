package Models;

public class Employee extends Person {
    protected String staffId;
    protected String employmentStatus;
    protected String startDate;

    public Employee() {
    }

    public Employee(String staffId, String firstName, String lastName, String phoneNumber, String email,
                    String employmentStatus, String startDate) {
        super(firstName, lastName, phoneNumber, email);
        this.staffId = staffId;
        this.employmentStatus = employmentStatus;
        this.startDate = startDate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

}
