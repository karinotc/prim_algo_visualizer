package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;
import java.awt.*;


public class Button extends JButton {

    public Button(String buttonText, ImageIcon icon) {

        this.setFocusable(false);
        this.setText(buttonText);
        this.setIcon(icon);

    }

}
