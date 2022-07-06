package edu.app.app.appComponents.Canvas.CanvasComponents;

import javax.swing.*;
import java.awt.*;

public class CanvasForm extends JPanel {
    public JButton submitButton;
    public JTextField textField;

    public CanvasForm() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 50));
        submitButton = new JButton("Enter data");
        this.add(textField);
        this.add(submitButton);
        submitButton.setEnabled(false);
        textField.setEnabled(false);
    }

    public void disableForm() {
        textField.setText("");
        textField.setEnabled(false);
        submitButton.setEnabled(false);
    }

    public void enableForm() {
        submitButton.setEnabled(true);
        textField.setEnabled(true);
        textField.requestFocus();
    }
    public int getData() {
        return Integer.parseInt(textField.getText());
    }
}
