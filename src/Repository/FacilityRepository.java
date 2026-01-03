package Repository;

import Models.Facility;
import Utilities.Constants;

import java.util.concurrent.CompletionService;

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
        return String.join(",", Constants.FACILITIES);
    }

    @Override
    protected String getId(Facility obj) {
        return obj.getFacilityId();
    }
}
