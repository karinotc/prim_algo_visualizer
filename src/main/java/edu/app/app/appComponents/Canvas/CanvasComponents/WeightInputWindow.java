package edu.app.app.appComponents.Canvas.CanvasComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightInputWindow extends JDialog implements ActionListener {

    public int edgeWeight;
    JButton submitButton;
    JTextField textField;

    public WeightInputWindow() {

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(100, 50));
        submitButton = new JButton("Enter data");
        submitButton.addActionListener(this);
        this.setLayout(new FlowLayout());

        this.add(submitButton);
        this.add(textField);
        this.pack();
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.edgeWeight = Integer.parseInt(textField.getText());
        dispose();

    }
}
