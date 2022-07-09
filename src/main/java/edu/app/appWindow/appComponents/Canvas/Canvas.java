package edu.app.appWindow.appComponents.Canvas;

import edu.app.appWindow.appComponents.Canvas.CanvasComponents.CanvasForm;
import edu.app.graph.DrawableGraph;
import edu.app.graphcomponents.DrawableEdge;
import edu.app.graphcomponents.DrawableNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.Expression;
import java.io.File;
import java.util.ArrayList;

public class Canvas extends JPanel {

    private DrawableGraph graph;
    private ArrayList<Integer> selectedNodes;

    private DrawableNode draggableNode;


    CanvasForm form;

    public Canvas() {

        int width = this.getWidth();
        graph = new DrawableGraph();
        draggableNode = null;

        selectedNodes = new ArrayList<>();

        ClickListener clickListener = new ClickListener();
        DragListener dragListener = new DragListener();
        ActionListener actionListener = e -> submitEdgeWeight();


        this.addMouseListener(clickListener);
        this.addMouseMotionListener(dragListener);

        form = new CanvasForm();
        form.submitButton.addActionListener(actionListener);

        this.setLayout(new BorderLayout());
        this.add(form, BorderLayout.LINE_END);
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


    private DrawableNode getNodeByClickCoords(int clickX, int clickY) {
        for (int i = 0; i < graph.getNodeAmount(); i++){
            DrawableNode currentNode = graph.getNode(i);
            if(Math.pow(clickX - currentNode.getX(), 2) + Math.pow(clickY - currentNode.getY(), 2) <= Math.pow(graph.getNode(i).getRadius(), 2)) {
                return currentNode;
            }
        }

        return null;
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

    private class ClickListener extends MouseAdapter {

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

            try {
                int clickX = e.getX();
                int clickY = e.getY();

                draggableNode = getNodeByClickCoords(clickX, clickY);

            } catch (NullPointerException err) {
                int a = 0;
            }
        }
    }

    private class DragListener extends MouseMotionAdapter {

        @Override
        public void mouseDragged(MouseEvent e) {

            int draggedX = e.getX();
            int draggedY = e.getY();

            if(draggableNode != null) {
                draggableNode.setX(draggedX);
                draggableNode.setY(draggedY);
                repaint();
            }

        }
    }

    public void submitEdgeWeight() {
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

    public DrawableGraph getGraph() {
        return graph;
    }
}
