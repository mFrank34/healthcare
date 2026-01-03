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
                r[2],  // clinicianId
                r[3],  // referralDate
                r[4],  // referralType
                r[5],  // referralReason
                r[6],  // urgencyLevel
                r[7],  // referredToService
                r[8],  // referralStatus
                r[9],  // appointmentDate
                r[10]  // outcomeNotes
        );
    }

    @Override
    protected String toCSV(Referral obj) {
        return String.join(",",
                obj.getReferralId(),
                obj.getPatientId(),
                obj.getClinicianId(),
                obj.getReferralDate(),
                obj.getReferralType(),
                obj.getReferralReason(),
                obj.getUrgencyLevel(),
                obj.getReferredToService(),
                obj.getReferralStatus(),
                obj.getAppointmentDate(),
                obj.getOutcomeNotes()
        );
    }

    @Override
    protected Object[] toTableRow(Referral obj) {
        return new Object[]{
                obj.getReferralId(),
                obj.getPatientId(),
                obj.getClinicianId(),
                obj.getReferralDate(),
                obj.getReferralType(),
                obj.getReferralReason(),
                obj.getUrgencyLevel(),
                obj.getReferredToService(),
                obj.getReferralStatus(),
                obj.getAppointmentDate(),
                obj.getOutcomeNotes()
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
