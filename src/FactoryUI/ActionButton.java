package FactoryUI;

import javax.swing.*;
import java.awt.*;

/**
 * button template for application
 */
public class ActionButton extends JButton {

    /**
     * Template for buttons
     * @param text button text
     */
    public ActionButton(String text) {
        super(text);

        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 14));

        // IMPORTANT
        setContentAreaFilled(false);
        setOpaque(false);

        setRolloverEnabled(true);
    }

    /**
     * override of one button system in JButton
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        ButtonModel model = getModel();

        if (model.isRollover()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(getBackground().darker());
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();
        }

        super.paintComponent(g);
    }
}
