package FactoryUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class CenteredTab  extends BasicTabbedPaneUI {

    private final Color selectedColor = new Color(235, 235, 235);   // light gray
    private final Color unselectedColor = new Color(250, 250, 250); // very light gray
    private final Color borderColor = new Color(200, 200, 200);     // subtle border
    private final Color textColor = new Color(30, 30, 30);          // dark text

    @Override
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {
        int tabCount = tabPane.getTabCount();
        if (tabCount == 0) return;

        int totalWidth = 0;
        for (int i = 0; i < tabCount; i++) {
            totalWidth += rects[i].width;
        }

        int offsetX = (tabPane.getWidth() - totalWidth) / 2;

        for (int i = 0; i < tabCount; i++) {
            rects[i].x = offsetX;
            offsetX += rects[i].width;
        }

        super.paintTabArea(g, tabPlacement, selectedIndex);
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex,
                                      int x, int y, int w, int h, boolean isSelected) {
        g.setColor(isSelected ? selectedColor : unselectedColor);
        g.fillRect(x, y, w, h);
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement,
                                       Rectangle[] rects, int tabIndex,
                                       Rectangle iconRect, Rectangle textRect,
                                       boolean isSelected) {
        // Disable blue focus ring
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font,
                             FontMetrics metrics, int tabIndex,
                             String title, Rectangle textRect,
                             boolean isSelected) {
        g.setFont(font);
        g.setColor(textColor);
        g.drawString(title, textRect.x, textRect.y + metrics.getAscent());
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        g.setColor(borderColor);
        super.paintContentBorder(g, tabPlacement, selectedIndex);
    }
}
