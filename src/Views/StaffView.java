package Views;

import FactoryUI.Form;
import Models.Staff;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StaffView extends Form {
    private static final String[] labels = {
            "ID:", "First Name:", "Last Name:", "Phone Number:",
            "Email:", "Start Date:", "Status:", "Role:",
            "Department:", "Facility:", "Line Manager:", "Access:"
    };

    StaffView() {
      super("Staff Form", labels);
    };

}