package Repositories;

import Models.Facility;

public class FacilityRepository extends BaseRepository<Facility> {

    public FacilityRepository() {
        super("data/facilities.csv");
        load();
    }

    @Override
    protected Facility parse(String[] f) {
        return new Facility(
                f[0], // facilityId
                f[1], // facilityName
                f[2], // facilityType
                f[3], // address
                f[4], // postcode
                f[5], // phoneNumber
                f[6], // email
                f[7], // openingHours
                f[8], // managerName
                Integer.parseInt(f[9]), // capacity
                f[10] // specialitiesOffered
        );
    }

    @Override
    protected String toCSV(Facility obj) {
        return String.join(",",
                obj.getFacilityId(),
                obj.getFacilityName(),
                obj.getFacilityType(),
                obj.getAddress(),
                obj.getPostcode(),
                obj.getPhoneNumber(),
                obj.getEmail(),
                obj.getOpeningHours(),
                obj.getManagerName(),
                String.valueOf(obj.getCapacity()),
                obj.getSpecialitiesOffered()
        );
    }

    @Override
    protected String getHeader() {
        return "facility_id,facility_name,facility_type,address,postcode,phone_number,email,opening_hours,manager_name,capacity,specialities_offered";
    }

    @Override
    protected boolean matchesId(Facility obj, String id) {
        return obj.getFacilityId().equals(id);
    }
}
