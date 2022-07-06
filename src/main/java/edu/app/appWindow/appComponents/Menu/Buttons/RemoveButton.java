package edu.app.appWindow.appComponents.Menu.Buttons;

import javax.swing.*;

public class RemoveButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/appWindow/appComponents/Menu/Buttons/Images/remove.png");
    static private String buttonText = "Remove mode";

    public RemoveButton() {
        super(buttonText, icon);
    }

}
