package FactoryUI;

import javax.swing.*;
import java.awt.*;

public class ActionButton extends JButton {
    public ActionButton(String text) {
        super(text);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));
        setPreferredSize(new Dimension(56, 56));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(new Color(33, 150, 243)); // Material Blue
        g2.fillOval(0, 0, getWidth(), getHeight());

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        int r = getWidth() / 2;
        return Math.pow(x - r, 2) + Math.pow(y - r, 2) <= r * r;
    }
}


