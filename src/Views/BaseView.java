package Views;

import FactoryUI.FormPanel;
import Utilities.Constants;

import javax.swing.*;
import java.util.List;

public class BaseView extends JFrame{
    private FormPanel form;
    private final String[] labels;

    public BaseView(String title, String[] labels) {
        setTitle(title);
        this.labels = labels;
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void setController(Controllers.AppointmentController controller) {
        form = new FormPanel(labels);
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

    public void setValue(int index, String string) {
        form.setValue(index, string);
    }
}
