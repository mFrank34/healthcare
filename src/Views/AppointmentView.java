package Views;

import Controllers.AppointmentController;
import FactoryUI.Form;
import javax.swing.*;

public class AppointmentView extends JFrame {
    private AppointmentController controller;
    private Form appointmentForm;


    public AppointmentView() {
        setTitle("Appointment Form");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setController(AppointmentController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        appointmentForm =
    }
}
