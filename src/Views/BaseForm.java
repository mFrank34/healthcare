package Views;

import javax.swing.*;
import java.util.List;

public abstract class BaseForm extends JFrame {





    public void showErrors(List<String> errors) {
        JOptionPane.showMessageDialog(this,
                String.join("\n", errors),
                "Validation Errors",
                JOptionPane.ERROR_MESSAGE);

    }
}
