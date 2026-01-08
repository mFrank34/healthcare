package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseForm extends JFrame {
    protected List<JTextField> fields = new ArrayList<>();
    protected JButton button = new JButton("Submit");

    BaseForm(String title, String[] labels) {
        this.setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(labels.length, 2));
        for (String label : labels) {
            panel.add(new JLabel(label));
            JTextField field = new JTextField();
            panel.add(field);
            fields.add(field);
        }
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setVisible(true);
    }

    public void showErrors(List<String> errors) {
        JOptionPane.showMessageDialog(this,
                String.join("\n", errors),
                "Validation Errors",
                JOptionPane.ERROR_MESSAGE);
    }

    public List<String> getData() {
        List<String> data = new ArrayList<>();
        for (JTextField field : fields) {
            data.add(field.getText());
        }
        return data;
    }

    public void addSubmitListener(ActionListener listener) {
        button.addActionListener(listener);
    }
}
