package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;

public class ToEndButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/app/appComponents/Menu/Buttons/Images/toEnd.png");
    static private String buttonText = "";
    public ToEndButton() {
        super(buttonText, icon);
    }
}
