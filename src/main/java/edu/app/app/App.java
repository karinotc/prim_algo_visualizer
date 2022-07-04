package edu.app.app;

import edu.app.app.appComponents.Menu.Menu;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    public App() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setTitle("Prim");
        this.setLayout(new BorderLayout());

        JPanel canvasPanel = new JPanel();
        JPanel menuPanel = new Menu();

        menuPanel.setBackground(new Color(201, 197, 197));
        canvasPanel.setBackground(new Color(247, 196, 173));

        menuPanel.setPreferredSize(new Dimension(100, 70));

        this.add(menuPanel, BorderLayout.NORTH);
        this.add(canvasPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

}
