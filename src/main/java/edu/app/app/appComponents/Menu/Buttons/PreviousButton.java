package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;

public class PreviousButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/app/appComponents/Menu/Buttons/Images/left.png");
    static private String buttonText = "";
    public PreviousButton() {
        super(buttonText, icon);
    }
}