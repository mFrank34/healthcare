package repository;

import handlers.Handler;
import models.Staff;
import utilities.Constants;

public class StaffRepository extends BaseRepository<Staff> {

    public StaffRepository() {
        super("data/staff.csv");
        load();
    }

    @Override
    protected Staff parse(String[] s) {
        return new Staff(
                s[0], // staffId
                s[1], // firstName
                s[2], // lastName
                s[3], // phoneNumber
                s[4], // email
                s[5], // employmentStatus
                s[6], // startDate
                s[7], // role
                s[8], // department
                s[9], // facilityId
                s[10], // accessLevel
                s[11]  // lineManager
        );
    }

    @Override
    protected String toCSV(Staff obj) {
        return Handler.toCSVLine(
                obj.getStaffId(),
                obj.getFirstName(),
                obj.getLastName(),
                obj.getPhoneNumber(),
                obj.getEmail(),
                obj.getEmploymentStatus(),
                obj.getStartDate(),
                obj.getRole(),
                obj.getDepartment(),
                obj.getFacilityId(),
                obj.getAccessLevel(),
                obj.getLineManager()
        );
    }

    @Override
    protected Object[] toTableRow(Staff obj) {
        return new Object[]{
                obj.getStaffId(),
                obj.getFirstName(),
                obj.getLastName(),
                obj.getPhoneNumber(),
                obj.getEmail(),
                obj.getEmploymentStatus(),
                obj.getStartDate(),
                obj.getRole(),
                obj.getDepartment(),
                obj.getFacilityId(),
                obj.getAccessLevel(),
                obj.getLineManager()
        };
    }

    @Override
    protected String getHeader() {
        return String.join(",", Constants.STAFF);
    }

    @Override
    protected String getId(Staff obj) {
        return obj.getStaffId();
    }
}
