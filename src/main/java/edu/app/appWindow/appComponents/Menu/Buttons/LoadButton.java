package edu.app.appWindow.appComponents.Menu.Buttons;

import javax.swing.*;

public class LoadButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/appWindow/appComponents/Menu/Buttons/Images/load.png");
    static private String buttonText = "Load from file";

    public LoadButton() {
        super(buttonText, icon);
    }
}
