package FactoryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * button template for application
 */
public class ActionButton extends JButton {

    private boolean hover = false;

    /**
     * creates a button
     *
     * @param text text that needed within the button
     */
    public ActionButton(String text) {
        super(text);

        setFocusPainted(false);

        // Let the Look & Feel handle borders, background, shape
        setContentAreaFilled(true);
        setOpaque(true);

        setFont(new Font("Arial", Font.BOLD, 14));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    /**
     * changes the hover effect of button
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        if (hover) {
            // Use theme background but slightly darker
            Color base = getBackground();
            Color hoverColor = base.darker();
            g.setColor(hoverColor);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }
}
