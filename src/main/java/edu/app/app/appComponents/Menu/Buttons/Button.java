package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;
import java.awt.*;


abstract public class Button extends JButton {

    public Button(String buttonText, ImageIcon icon) {

        this.setFocusable(false);
        this.setText(buttonText);
        this.setIcon(icon);

    }

}
