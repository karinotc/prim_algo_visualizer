package edu.app.appWindow.appComponents.Canvas;

import edu.app.appWindow.appComponents.Canvas.CanvasComponents.CanvasForm;
import edu.app.graph.DrawableGraph;
import edu.app.graphcomponents.DrawableEdge;
import edu.app.graphcomponents.DrawableNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener, ActionListener {

    //private int nodeCurrentNumber;
    private DrawableGraph graph;
    private ArrayList<Integer> selectedNodes;
    //private final ArrayList<DrawableNode> selectedNodes; //может int?

    CanvasForm form;

    public Canvas() {
        //nodeCurrentNumber = 1;

        graph = new DrawableGraph();

        selectedNodes = new ArrayList<Integer>();
        //selectedNodes = new ArrayList<DrawableNode>();
        this.addMouseListener(this);

        form = new CanvasForm();
        form.submitButton.addActionListener(this);;


        this.setLayout(new BorderLayout());
        this.add(form, BorderLayout.LINE_END);

        //addNewNode(100, 100);
        //addNewNode(230, 45);
        //addNewNode(89, 32);
    }


    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i<graph.getEdgeAmount(); i++){
            graph.getEdge(i).drawEdge(g2);
        }

        for (int i = 0; i<graph.getNodeAmount(); i++){
            graph.getNode(i).drawNode(g2);
        }
    }

    private void unselectAllNodes() {
        for (int i = 0; i<graph.getNodeAmount(); i++){
            graph.getNode(i).setSelected(false);
        }

        selectedNodes.clear();
    }

    private void selectNode(int clickX, int clickY) {
        for (int i = 0; i<graph.getNodeAmount(); i++){
            if(Math.pow(clickX - graph.getNode(i).getX(), 2) + Math.pow(clickY - graph.getNode(i).getY(), 2) <= Math.pow(graph.getNode(i).getRadius(), 2)) {
                graph.getNode(i).toggleSelected();
                selectedNodes.add(i);
                //selectedNodes.add(graph.getNode(i));
                break;
            }
        }
    }

    private boolean isAbleToPutNode(int clickX, int clickY) {
        for (int i = 0; i<graph.getNodeAmount(); i++){
            if(Math.pow(clickX - graph.getNode(i).getX(), 2) + Math.pow(clickY - graph.getNode(i).getY(), 2) <= 16 * Math.pow(graph.getNode(i).getRadius(), 2)) {
                return false;
            }
        }
        return true;
    }
    private void addNewNode(int x, int y) {
        if(isAbleToPutNode(x, y)) {
            graph.addDrawableNode(x, y);
        }
    }

    private void addEdgeBetweenSelectedNodes(int weight) {
        graph.addDrawableEdge(selectedNodes.get(0), selectedNodes.get(1), weight);
    }

    /*private void createWeighedEdgeBetweenTwoNodes(int firstNodeIdx, int secondNodeIdx, int weight) {
        graph.addDrawableEdge(firstNodeIdx, secondNodeIdx, weight);
        graph.getNode(firstNodeIdx).addIncidentalNode(graph.getNode(secondNodeIdx));
        graph.getNode(secondNodeIdx).addIncidentalNode(graph.getNode(firstNodeIdx));
    }*/

    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        if(e.getButton() == MouseEvent.BUTTON3) {
            selectNode(x, y);
            if(selectedNodes.size() == 2) {
                form.enableForm();
            }
        } else if(e.getButton() == MouseEvent.BUTTON1) {
            addNewNode(x, y);
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int weight = form.getData();
            addEdgeBetweenSelectedNodes(weight);

        } catch (NumberFormatException exception) {
            System.out.println("Wrong input format");
        }

        unselectAllNodes();
        form.disableForm();
        repaint();

    }
}
