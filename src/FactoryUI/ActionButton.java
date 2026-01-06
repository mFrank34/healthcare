package FactoryUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActionButton extends JButton {

    private boolean hover = false;

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
