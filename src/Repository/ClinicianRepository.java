package Repository;

import Models.Clinician;

public class ClinicianRepository extends BaseRepository<Clinician> {

    public ClinicianRepository() {
        super("data/clinicians.csv");
        load();
    }

    @Override
    protected Clinician parse(String[] c) {
        return new Clinician(
                c[0], // staffId
                c[1], // firstName
                c[2], // lastName
                c[3], // phoneNumber
                c[4], // email
                c[5], // employmentStatus
                c[6], // startDate
                c[7], // title
                c[8], // speciality
                c[9], // gmcNumber
                c[10], // workplaceId
                c[11]  // workplaceType
        );
    }

    @Override
    protected String toCSV(Clinician obj) {
        return String.join(",",
                obj.getStaffId(),
                obj.getFirstName(),
                obj.getLastName(),
                obj.getPhoneNumber(),
                obj.getEmail(),
                obj.getEmploymentStatus(),
                obj.getStartDate(),
                obj.getTitle(),
                obj.getSpeciality(),
                obj.getGmcNumber(),
                obj.getWorkplaceId(),
                obj.getWorkplaceType()
        );
    }

    @Override
    protected String getHeader() {
        return "clinician_id,first_name,last_name,title,speciality,gmc_number,phone_number,email,workplace_id,workplace_type,employment_status,start_date";
    }

    @Override
    protected String getId(Clinician obj) {
        return obj.getStaffId();
    }
}