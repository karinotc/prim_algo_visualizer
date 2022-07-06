package edu.app.appWindow.appComponents.Menu.Buttons;

import javax.swing.*;



public class CleanButton extends Button {

    static private ImageIcon trashcanIcon = new ImageIcon("src/main/java/edu/app/appWindow/appComponents/Menu/Buttons/Images/delete.png");
    static private String cleanButtonText = "Clean canvas";
    public CleanButton() {
        super(cleanButtonText, trashcanIcon);
    }

}
