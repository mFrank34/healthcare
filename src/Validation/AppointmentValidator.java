package Validation;

import Models.Appointment;
import Utilities.Validator;

import java.util.List;

public class AppointmentValidator implements Validator<Appointment> {

    @Override
    public List<String> validate(Appointment Model) {
        return List.of();
    }
}
