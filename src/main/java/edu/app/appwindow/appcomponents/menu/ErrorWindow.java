package edu.app.appwindow.appcomponents.menu;

import edu.app.appwindow.appcomponents.canvas.Canvas;

import javax.swing.*;
import java.awt.*;

public class ErrorWindow extends JFrame{
    private Canvas appCanvas;
    JLabel wrongInput;
    JLabel message;
    JButton okButton;

    public ErrorWindow(String msg){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocation(new Point(400, 200));

        okButton = new JButton("OK");
        okButton.addActionListener(e -> submitClick());

        wrongInput = new JLabel(" Wrong input! ");

        message = new JLabel(" " + msg + " ");
        this.setLayout(new GridLayout(3, 1));
        this.add(wrongInput);
        this.add(message);
        this.add(okButton);

        this.pack();
        this.setVisible(true);
    }

    public void submitClick() {
        dispose();
    }

    public void setAppCanvas(Canvas appCanvas) {
        this.appCanvas = appCanvas;
    }

}
