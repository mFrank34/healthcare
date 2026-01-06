package FactoryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class FormPanel extends JPanel {
    protected Map<String, JTextField> fields = new LinkedHashMap<>();
    protected JButton submitButton = new JButton("Submit");
    protected JButton cancelButton = new JButton("Cancel");

    public FormPanel(String[] labels) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Form fields panel
        JPanel fieldsPanel = new JPanel(new GridLayout(labels.length, 2, 8, 8));

        for (String label : labels) {
            JLabel jLabel = new JLabel(label + ":");
            JTextField field = new JTextField(20);

            fieldsPanel.add(jLabel);
            fieldsPanel.add(field);

            fields.put(label, field);
        }

        add(fieldsPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(cancelButton);
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addCancelListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    public String getValue(String label) {
        JTextField field = fields.get(label);
        return field != null ? field.getText().trim() : null;
    }

    public Map<String, String> getAllData() {
        Map<String, String> data = new LinkedHashMap<>();
        for (var entry : fields.entrySet()) {
            data.put(entry.getKey(), entry.getValue().getText().trim());
        }
        return data;
    }

    public void setValue(String label, String value) {
        JTextField field = fields.get(label);
        if (field != null) {
            field.setText(value);
        }
    }

    public void clearFields() {
        for (JTextField field : fields.values()) {
            field.setText("");
        }
    }

    public void setFieldEnabled(String label, boolean enabled) {
        JTextField field = fields.get(label);
        if (field != null) {
            field.setEnabled(enabled);
        }
    }
}