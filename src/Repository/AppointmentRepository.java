package Repository;

import Models.Appointment;
import Utilities.Constants;

import static java.lang.Integer.parseInt;

/**
 * only going though one of these due to nearly identical to one another part from model layouts
 * repo for appointment data that stores the hashmap of model object and manages them
 */
public class AppointmentRepository extends BaseRepository<Appointment> {

    /**
     * constructor for class to give the file location
     * and load the data into the system
     */
    public AppointmentRepository() {
        super("data/appointments.csv");
        load();
    }

    /**
     * covert string of data to model of appointments
     * @param a the string data from file
     * @return returns new appointment object
     */
    @Override
    protected Appointment parse(String[] a) {
        return new Appointment(
                a[0],
                a[1],
                a[2],
                a[3],
                a[4],
                a[5],
                parseInt(a[6]),
                a[7],
                a[8],
                a[9],
                a[10],
                a[11],
                a[12]
        );
    }

    /**
     * create method to covert objects to string with "," to connect the elements together
     * @param obj selected object to covert
     * @return returns a string of model
     */
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

    /**
     * covers the models to easier to read table format for table fab
     * @param obj selected object that need to be converted
     * @return returns list of data
     */
    @Override
    protected Object[] toTableRow(Appointment obj) {
        return new Object[]{
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
        };
    }

    /**
     * returns a header for cvs files
     * @return string of data
     */
    @Override
    protected String getHeader() {
        return String.join(",", Constants.APPOINTMENTS);
    }

    /**
     * helper function for grabbing id value of class
     * @param obj selected object for id value
     * @return string based of id value
     */
    @Override
    protected String getId(Appointment obj) {
        return obj.getAppointmentId();
    }
}
