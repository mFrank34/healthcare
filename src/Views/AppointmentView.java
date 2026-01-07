package Views;

import FactoryUI.FormPanel;
import Utilities.Constants;

import javax.swing.*;
import java.util.List;

public class AppointmentView extends JFrame {

    private FormPanel form;

    public AppointmentView() {
        setTitle("Appointment");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setController(Controllers.AppointmentController controller) {
        form = new FormPanel(Constants.APPOINTMENTS);
        form.addSubmitListener(e -> controller.handleSubmit());
        form.addCancelListener(e -> controller.handleCancel());
        add(form);
    }

    public List<String> getFormData() {
        return form.getAllData();
    }

    public void showValidationErrors(List<String> errors) {
        JOptionPane.showMessageDialog(this,
                String.join("\n", errors),
                Constants.TITLE_VALIDATION_ERRORS,
                JOptionPane.ERROR_MESSAGE);
    }

    public void showSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg,
                Constants.TITLE_SUCCESS,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void clearForm() {
        form.clearFields();
    }
}
