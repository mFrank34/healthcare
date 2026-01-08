package FactoryUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * table reset of all data and create a table
 */
public class TablePanel {

    /**
     * empty constructor
     */
    public TablePanel() {
    }

    /**
     * creates a table based of the contents
     *
     * @param columns the columns of the table
     * @param data the data within the table
     * @return return panel with the data in it
     */
    public static JPanel createTablePanel(
            String[] columns,
            Object[][] data
    ) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Table
        DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }
}

