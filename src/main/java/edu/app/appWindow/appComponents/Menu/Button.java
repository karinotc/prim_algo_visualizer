package edu.app.appWindow.appComponents.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.Expression;


public class Button extends JButton {

    public Button(String buttonText, ActionListener click) {

        this.setFocusable(false);
        this.setText(buttonText);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.addActionListener(click);

    }

}
