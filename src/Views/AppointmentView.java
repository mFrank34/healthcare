package Views;

import Controllers.AppointmentController;
import FactoryUI.FormPanel;
import Utilities.Constants;

import javax.swing.*;

public class AppointmentView extends JFrame {
    private AppointmentController controller;
    private FormPanel formPanel;

    public AppointmentView() {
        setTitle("Appointment Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setController(AppointmentController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        formPanel = new FormPanel(Constants.APPOINTMENTS);
        formPanel.addSubmitListener(e -> controller.handleSubmit());
        formPanel.addCancelListener(e -> controller.handleCancel());

        add(formPanel);
    }

    public FormPanel getFormPanel() {
        return formPanel;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void showValidationErrors(java.util.List<String> errors) {
        JOptionPane.showMessageDialog(
                this,
                String.join("\n", errors),
                "Validation Errors",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void showSuccess(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void clearForm() {
        formPanel.clearFields();
    }
}