package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;

public class NextButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/app/appComponents/Menu/Buttons/Images/right.png");
    static private String buttonText = "";

    public NextButton() {
        super(buttonText, icon);
    }
}