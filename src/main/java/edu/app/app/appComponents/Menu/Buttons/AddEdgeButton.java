package edu.app.app.appComponents.Menu.Buttons;

import javax.swing.*;

public class AddEdgeButton extends Button {
    static private ImageIcon icon = new ImageIcon("src/main/java/edu/app/app/appComponents/Menu/Buttons/Images/edge.png");
    static private String buttonText = "Add Edges";

    public AddEdgeButton() {
        super(buttonText, icon);
    }
}
