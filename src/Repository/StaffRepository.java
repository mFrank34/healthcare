package Repository;

import Models.Staff;

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
        return String.join(",",
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
    protected String getHeader() {
        return "staff_id,first_name,last_name,phone_number,email,employment_status,start_date,role,department,facility_id,access_level,line_manager";
    }

    @Override
    protected String getId(Staff obj) {
        return obj.getStaffId();
    }

}
