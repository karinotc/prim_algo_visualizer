package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;
import java.awt.*;


public class GenerateButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/app/appComponents/Menu/Buttons/Images/generate.png");
    static private String buttonText = "Generate graph";

    public GenerateButton() {
        super(buttonText, icon);
    }
}
