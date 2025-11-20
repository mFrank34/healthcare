package Views;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PatientsGUI extends JFrame {
    // data collection
    private List<JTextField> data = new ArrayList<>();
    private final String[] elements = {
            "ID:",
            "First Name:",
            "Last Name:",
            "Phone Number:",
            "Email:",
            "NHS Number:",
            "Gender:",
            "Birth Date:",
            "Address:",
            "PostCode:",
            "Emergency Name:",
            "Emergency Number:",
            "Registration",
            "gpId"
    };

    public PatientsGUI()
    {
        super("Patients Form");
        setLayout(new BorderLayout());

        add(BorderLayout.NORTH, createSetPatientsPanel());

        setSize(400, 300);
        setVisible(true);
    }

    public JPanel createSetPatientsPanel()
    {
        // setting up titles
        JPanel SetPatientPanels = new JPanel(new BorderLayout());
        JPanel panel = new JPanel(new GridLayout(elements.length, 1));

        for (String index : elements)
        {
            panel.add(new JLabel(index));
            JTextField newTextBox = new JTextField();
            panel.add(newTextBox);
            data.add(newTextBox);
        }
        return panel;
    }

    public String getDate()
    {
        List<String> allData = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            String currentField = data.get(i).getText();
            String currentElement = elements[i];

            allData.add(currentField);
            allData.add(currentElement);
        }

        return allData.toString();
    }
}
