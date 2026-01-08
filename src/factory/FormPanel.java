package factory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormPanel extends JPanel {

    private final List<JTextField> fields = new ArrayList<>();
    private final JButton submitButton = new JButton("Submit");
    private final JButton cancelButton = new JButton("Cancel");

    /**
     * Form Constructor for creating a form prefab to use within application layer
     * @param labels label for the form
     */
    public FormPanel(String[] labels) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel fieldsPanel = new JPanel(new GridLayout(labels.length, 2, 8, 8));

        for (String label : labels) {
            fieldsPanel.add(new JLabel(label + ":"));
            JTextField field = new JTextField(20);
            fields.add(field);
            fieldsPanel.add(field);
        }

        add(fieldsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(cancelButton);
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * get the user inputted data from the fields
     * @return return list of inputted data
     */
    public List<String> getAllData() {
        List<String> data = new ArrayList<>();
        for (JTextField field : fields) {
            data.add(field.getText().trim());
        }
        return data;
    }

    /**
     * set the values for the form, for editing other data set
     * @param index index of the label
     * @param value the editing data that need to changed
     */
    public void setValue(int index, String value) {
        if (index >= 0 && index < fields.size()) {
            fields.get(index).setText(value);
        }
    }

    /**
     * clear out the text field and reset them
     */
    public void clearFields() {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    /**
     * event listener for submit button
     * @param l the action listen that will be listening
     */
    public void addSubmitListener(ActionListener l) {
        submitButton.addActionListener(l);
    }

    /**
     * event listener for submit button
     * @param l the action listen that will be listening
     */
    public void addCancelListener(ActionListener l) {
        cancelButton.addActionListener(l);
    }
}