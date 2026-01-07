package Repository;

import Models.Referral;
import Utilities.Constants;

public class ReferralRepository extends BaseRepository<Referral> {

    public ReferralRepository() {
        super("data/referrals.csv");
        load();
    }

    @Override
    protected Referral parse(String[] r) {
        return new Referral(
                r[0],  // referralId
                r[1],  // patientId
                r[2],  // referringClinicianId
                r[3],  // referredToClinicianId
                r[4],  // referringFacilityId
                r[5],  // referredToFacilityId
                r[6],  // referralDate
                r[7],  // urgencyLevel
                r[8],  // referralReason
                r[9],  // clinicalSummary
                r[10], // requestedInvestigations
                r[11], // status
                r[12], // appointmentId
                r[13], // notes
                r[14], // createdDate
                r[15]  // lastUpdated
        );
    }

    @Override
    protected String toCSV(Referral obj) {
        return String.join(",",
                obj.getReferralId(),
                obj.getPatientId(),
                obj.getReferringClinicianId(),
                obj.getReferredToClinicianId(),
                obj.getReferringFacilityId(),
                obj.getReferredToFacilityId(),
                obj.getReferralDate(),
                obj.getUrgencyLevel(),
                obj.getReferralReason(),
                obj.getClinicalSummary(),
                obj.getRequestedInvestigations(),
                obj.getStatus(),
                obj.getAppointmentId(),
                obj.getNotes(),
                obj.getCreatedDate(),
                obj.getLastUpdated()
        );
    }


    @Override
    protected Object[] toTableRow(Referral obj) {
        return new Object[]{
                obj.getReferralId(),
                obj.getPatientId(),
                obj.getReferringClinicianId(),
                obj.getReferredToClinicianId(),
                obj.getReferringFacilityId(),
                obj.getReferredToFacilityId(),
                obj.getReferralDate(),
                obj.getUrgencyLevel(),
                obj.getReferralReason(),
                obj.getClinicalSummary(),
                obj.getRequestedInvestigations(),
                obj.getStatus(),
                obj.getAppointmentId(),
                obj.getNotes(),
                obj.getCreatedDate(),
                obj.getLastUpdated()
        };
    }

    @Override
    protected String getHeader() {
        return String.join(",", Constants.REFERRALS);
    }

    @Override
    protected String getId(Referral obj) {
        return obj.getReferralId();
    }

}
