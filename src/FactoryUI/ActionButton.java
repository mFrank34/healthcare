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
        setFont(new Font("Arial", Font.BOLD, 14));
        setFocusPainted(false);
    }

}
