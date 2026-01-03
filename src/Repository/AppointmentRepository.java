package Repository;

import Models.Appointment;
import Utilities.Constants;

import static java.lang.Integer.parseInt;

public class AppointmentRepository  extends BaseRepository<Appointment> {

    public AppointmentRepository() {
        super("data/appointments.csv");
        load();
    }

    @Override
    protected Appointment parse(String[] a) {
        return new Appointment(
                a[0], a[1], a[2], a[3],
                a[4], a[5], parseInt(a[6]),
                a[7], a[8], a[9], a[10],
                a[11], a[12]
        );
    }

    @Override
    protected String toCSV(Appointment obj) {
        return String.join(",",
                obj.getAppointmentId(),
                obj.getPatientId(),
                obj.getClinicianId(),
                obj.getFacilityId(),
                obj.getAppointmentDate(),
                obj.getAppointmentTime(),
                String.valueOf(obj.getDurationMinutes()),
                obj.getAppointmentType(),
                obj.getStatus(),
                obj.getReasonForVisit(),
                obj.getNotes(),
                obj.getCreatedDate(),
                obj.getUpdatedDate()
        );
    }

    @Override
    protected String getHeader() {
        return String.join(",", Constants.APPOINTMENTS);
    }

    @Override
    protected String getId(Appointment obj) {
        return obj.getAppointmentId();
    }
}
