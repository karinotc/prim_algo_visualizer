package edu.app.appWindow.appComponents.Menu;

import edu.app.appWindow.appComponents.Canvas.Canvas;
import edu.app.appWindow.appComponents.Menu.Buttons.Button;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class generateWindow extends JFrame {

    private Canvas appCanvas;
    JTextField countNodesInput;
    JTextField minEdgeCountInput;
    JTextField maxEdgeCountInput;
    JTextField minEdgeWeightInput;
    JTextField maxEdgeWeightInput;
    JButton submitButton;

    JLabel countNodesTitle;
    JLabel minEdgeCountTitle;
    JLabel maxEdgeCountTitle;
    JLabel minEdgeWeightTitle;
    JLabel maxEdgeWeightTitle;

    public generateWindow() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 300);
        this.setTitle("Generate Graph data");
        this.setLocation(new Point(400, 200));

        submitButton = new JButton("Create a random graph");
        submitButton.addActionListener(e -> submitClick());

        countNodesInput = new JTextField();
        minEdgeCountInput = new JTextField();
        maxEdgeCountInput = new JTextField();
        minEdgeWeightInput = new JTextField();
        maxEdgeWeightInput = new JTextField();

        countNodesTitle = new JLabel("Count nodes");
        minEdgeCountTitle = new JLabel("Min count of edges");
        maxEdgeCountTitle = new JLabel("Max count of edges");
        minEdgeWeightTitle = new JLabel("Min edge weight");
        maxEdgeWeightTitle = new JLabel("Max edge weight");

        countNodesInput.setPreferredSize(new Dimension(100, 20));
        minEdgeCountInput.setPreferredSize(new Dimension(100, 20));
        maxEdgeCountInput.setPreferredSize(new Dimension(100, 20));
        minEdgeWeightInput.setPreferredSize(new Dimension(100, 20));
        maxEdgeWeightInput.setPreferredSize(new Dimension(100, 20));

        this.setLayout(new GridLayout(11, 1));

        List.of(countNodesTitle, countNodesInput,
                minEdgeCountTitle, minEdgeCountInput,
                maxEdgeCountTitle, maxEdgeCountInput,
                minEdgeWeightTitle, minEdgeWeightInput,
                maxEdgeWeightTitle, maxEdgeWeightInput,
                submitButton
        ).forEach(this::add);

        this.pack();
        this.setVisible(true);


    }

    public void submitClick() {
        int countNodes = Integer.parseInt(countNodesInput.getText());
        int minEdgeCount = Integer.parseInt(minEdgeCountInput.getText());
        int maxEdgeCount = Integer.parseInt(maxEdgeCountInput.getText());
        int minEdgeWeight = Integer.parseInt(minEdgeWeightInput.getText());
        int maxEdgeWeight = Integer.parseInt(maxEdgeWeightInput.getText());

        appCanvas.getGraph().randomizeGraph(appCanvas.getWidth()/2, appCanvas.getHeight()/2, countNodes, minEdgeCount, maxEdgeCount, minEdgeWeight, maxEdgeWeight);
        appCanvas.repaint();
        dispose();
    }

    public void setAppCanvas(Canvas appCanvas) {
        this.appCanvas = appCanvas;
    }



}
