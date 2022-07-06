package edu.app.appWindow;

import edu.app.appWindow.appComponents.Canvas.Canvas;
import edu.app.appWindow.appComponents.Menu.Menu;

import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame {

    Menu menuPanel;
    Canvas canvasPanel;



    public AppWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setTitle("Prim");

        menuPanel = new Menu();
        canvasPanel = new Canvas();

        menuPanel.setBackground(new Color(201, 197, 197));

        menuPanel.setPreferredSize(new Dimension(100, 70));

        this.setLayout(new BorderLayout());
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(canvasPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

}
