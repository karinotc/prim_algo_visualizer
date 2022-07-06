package edu.app.appWindow.appComponents.Menu.Buttons;

import javax.swing.*;


abstract public class Button extends JButton {

    public Button(String buttonText, ImageIcon icon) {

        this.setFocusable(false);
        this.setText(buttonText);
        this.setIcon(icon);

    }

}
