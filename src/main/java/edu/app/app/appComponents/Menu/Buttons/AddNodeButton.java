package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;

public class AddNodeButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/app/appComponents/Menu/Buttons/Images/node.png");
    static private String buttonText = "Add a node";
    public AddNodeButton() {
        super(buttonText, icon);
    }
}