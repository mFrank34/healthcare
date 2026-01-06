package FactoryUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Management Panel for CRUD-style tables
 */
public class ManagementPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    /**
     * Create new management panel based of following params
     *
     * @param title         title of the tab
     * @param columns       labels for the table
     * @param tableData     the data for the table
     * @param addAction     button for interactions
     * @param editAction    button for interactions
     * @param removeAction  button for interactions
     * @param refreshAction button for interactions
     */
    public ManagementPanel(
            String title,
            String[] columns,
            Object[][] tableData,
            Runnable addAction,
            Runnable editAction,
            Runnable removeAction,
            Runnable refreshAction
    ) {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Table
        tableModel = new DefaultTableModel(tableData, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // IMPORTANT
            }
        };

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(24);

        add(new JScrollPane(table), BorderLayout.CENTER);


        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        addButton("Add", addAction, buttonsPanel);
        addButton("Edit", () -> {
            if (table.getSelectedRow() >= 0) {
                editAction.run();
            } else {
                showSelectWarning();
            }
        }, buttonsPanel);

        addButton("Remove", () -> {
            if (table.getSelectedRow() >= 0) {
                removeAction.run();
            } else {
                showSelectWarning();
            }
        }, buttonsPanel);

        addButton("Refresh", refreshAction, buttonsPanel);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    /**
     * Refresh table data WITHOUT rebuilding UI
     */
    public void refresh(Object[][] newData) {
        tableModel.setRowCount(0);
        for (Object[] row : newData) {
            tableModel.addRow(row);
        }
    }

    /**
     * Get selected row index
     */
    public int getSelectedRow() {
        return table.getSelectedRow();
    }

    private void addButton(String text, Runnable action, JPanel panel) {
        ActionButton button = new ActionButton(text);
        button.addActionListener(e -> {
            if (action != null) action.run();
        });
        panel.add(button);
    }

    private void showSelectWarning() {
        JOptionPane.showMessageDialog(
                this,
                "Please select a row first.",
                "No Selection",
                JOptionPane.WARNING_MESSAGE
        );
    }
}