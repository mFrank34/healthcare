package FactoryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Form extends JFrame {

    protected Map<String, JTextField> fields = new LinkedHashMap<>();
    protected JButton submitButton = new JButton("Submit");

    protected Form(String title, String[] labels) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(labels.length, 2, 8, 8));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (String label : labels) {
            JLabel jLabel = new JLabel(label);
            JTextField field = new JTextField();

            formPanel.add(jLabel);
            formPanel.add(field);

            fields.put(label, field);
        }

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(420, 300);
        setLocationRelativeTo(null); // center window
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
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

    public void showErrors(java.util.List<String> errors) {
        JOptionPane.showMessageDialog(
                this,
                String.join("\n", errors),
                "Validation Errors",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(
                this,
                message,
                "Info",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
