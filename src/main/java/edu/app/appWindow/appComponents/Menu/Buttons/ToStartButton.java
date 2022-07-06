package edu.app.appWindow.appComponents.Menu.Buttons;

import javax.swing.*;

public class ToStartButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/appWindow/appComponents/Menu/Buttons/Images/toStart.png");
    static private String buttonText = "";
    public ToStartButton() {
        super(buttonText, icon);
    }
}
