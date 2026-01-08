package views;

import factory.FormPanel;
import utilities.Constants;
import javax.swing.*;
import java.util.List;

/**
 * Base system for creating a view that would include a form piece
 * @param <T> dynamically changing the controller types
 */
public abstract class BaseView<T> extends JFrame{
    protected FormPanel form;
    protected final String[] labels;

    /**
     * base constructor for Form
     * @param title title of the form
     * @param labels labels that are used
     */
    public BaseView(String title, String[] labels) {
        setTitle(title);
        this.labels = labels;
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * abstract class for setting up the controller
     * @param controller the dynamic controller I was talking about^^
     */
    protected abstract void setController(T controller);

    /**
     * return the form data from the form that being used
     * @return list of strings
     */
    public List<String> getFormData() {
        return form.getAllData();
    }

    /**
     * error pop up handler
     * @param errors list of error the user made
     */
    public void showValidationErrors(List<String> errors) {
        JOptionPane.showMessageDialog(this,
                String.join("\n", errors),
                Constants.TITLE_VALIDATION_ERRORS,
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * message saying that they successfully create new model
     * @param msg message that is to be shown to user
     */
    public void showSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg,
                Constants.TITLE_SUCCESS,
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * reset the form fields
     */
    public void clearForm() {
        form.clearFields();
    }

    /**
     * set the value of text field
     * @param index index of the field
     * @param string content that within that field
     */
    public void setValue(int index, String string) {
        form.setValue(index, string);
    }
}
