package edu.app.appWindow.appComponents.Menu.Buttons;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.beans.Expression;


public class Button extends JButton {

    public Button(String buttonText, ImageIcon icon, ActionListener click) {

        this.setFocusable(false);
        this.setText(buttonText);
        this.setIcon(icon);
        this.addActionListener(click);

    }

}
