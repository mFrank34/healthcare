package FactoryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormPanel extends JPanel {

    private final List<JTextField> fields = new ArrayList<>();
    private final JButton submitButton = new JButton("Submit");
    private final JButton cancelButton = new JButton("Cancel");

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

    public List<String> getAllData() {
        List<String> data = new ArrayList<>();
        for (JTextField field : fields) {
            data.add(field.getText().trim());
        }
        return data;
    }

    public void setValue(int index, String value) {
        if (index >= 0 && index < fields.size()) {
            fields.get(index).setText(value);
        }
    }

    public void clearFields() {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public void addSubmitListener(ActionListener l) {
        submitButton.addActionListener(l);
    }

    public void addCancelListener(ActionListener l) {
        cancelButton.addActionListener(l);
    }
}