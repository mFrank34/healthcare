package FactoryUI;

import javax.swing.*;
import java.awt.*;

public class ManagementPanel {

    public JPanel createManagementPanel(
            String title,
            String[] columns,
            Object[][] tableData,
            Runnable addAction,
            Runnable editAction,
            Runnable removeAction,
            Runnable refreshAction
    ) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        // Table (integrated)
        JPanel tablePanel = TablePanel.createTablePanel(columns, tableData);
        panel.add(tablePanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        ActionButton addButton = new ActionButton("Add");
        addButton.addActionListener(e -> {
            if (addAction != null) addAction.run();
        });

        ActionButton editButton = new ActionButton("Edit");
        editButton.addActionListener(e -> {
            if (editAction != null) editAction.run();
        });

        ActionButton removeButton = new ActionButton("Remove");
        removeButton.addActionListener(e -> {
            if (removeAction != null) removeAction.run();
        });

        ActionButton refreshButton = new ActionButton("Refresh");
        refreshButton.addActionListener(e -> {
            if (refreshAction != null) refreshAction.run();
        });

        buttonsPanel.add(addButton);
        buttonsPanel.add(editButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(refreshButton);

        panel.add(buttonsPanel, BorderLayout.SOUTH);

        return panel;
    }
}


