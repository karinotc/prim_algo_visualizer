package edu.app.app.appComponents.Canvas;

import edu.app.graphcomponents.DrawableEdge;
import edu.app.graphcomponents.DrawableNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener {

    private int nodeCurrentId;
    private final ArrayList<DrawableNode> nodes;
    private final ArrayList<DrawableEdge> edges;
    private final ArrayList<DrawableNode> selectedNodes;
    public Canvas() {
        nodes = new ArrayList<DrawableNode>();
        edges = new ArrayList<DrawableEdge>();
        selectedNodes = new ArrayList<DrawableNode>();
        this.addMouseListener(this);
        addNewNode(100, 100);
        addNewNode(230, 45);
        addNewNode(89, 32);
        repaint();
    }


    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        for(DrawableEdge drawableEdge : edges) {
            drawableEdge.drawEdge(g2);
        }

        for(DrawableNode drawableNode : nodes) {
            drawableNode.drawNode(g2);
        }
    }

    private void unselectAllNodes() {
        for(DrawableNode drawableNode : nodes) {
            drawableNode.setSelected(false);
        }
    }

    private void selectNode(int clickX, int clickY) {
        for(DrawableNode drawableNode : nodes) {
            if(Math.pow(clickX - drawableNode.getX(), 2) + Math.pow(clickY - drawableNode.getY(), 2) <= Math.pow(drawableNode.getRadius(), 2)) {
                drawableNode.toggleSelected();
                selectedNodes.add(drawableNode);
                break;
            }
        }
    }

    private boolean isAbleToPutNode(int clickX, int clickY) {

        for(DrawableNode drawableNode : nodes) {
            if(Math.pow(clickX - drawableNode.getX(), 2) + Math.pow(clickY - drawableNode.getY(), 2) <= 16 * Math.pow(drawableNode.getRadius(), 2)) {
                return false;
            }
        }

        return true;
    }
    private void addNewNode(int x, int y) {
        if(isAbleToPutNode(x, y)) {
            nodes.add(new DrawableNode(x, y));
        }

    }
    private void connectTwoNodes(DrawableNode firstNode, DrawableNode secondNode) {
        DrawableEdge newEdge = new DrawableEdge(firstNode, secondNode);
        firstNode.addIncidentalNode(secondNode);
        secondNode.addIncidentalNode(firstNode);
        edges.add(newEdge);
        selectedNodes.clear();
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        int x = e.getX();
        int y = e.getY();

        if(e.getButton() == MouseEvent.BUTTON3) {
            selectNode(x, y);
            if(selectedNodes.size() == 2) {
                connectTwoNodes(selectedNodes.get(0), selectedNodes.get(1));
                unselectAllNodes();
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
}
