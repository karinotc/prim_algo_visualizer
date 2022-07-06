package edu.app.appWindow.appComponents.Menu.Buttons;

import javax.swing.*;


public class GenerateButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/appWindow/appComponents/Menu/Buttons/Images/generate.png");
    static private String buttonText = "Generate graph";

    public GenerateButton() {
        super(buttonText, icon);
    }
}
