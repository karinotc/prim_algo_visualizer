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
    }



    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (DrawableNode drawableNode : nodes) {
            drawableNode.drawNode(g2);
        }
    }

    public void selectNode(int clickX, int clickY) {
        for(DrawableNode drawableNode : nodes) {
            if(Math.pow(clickX - drawableNode.getX(), 2) + Math.pow(clickY - drawableNode.getY(), 2) <= Math.pow(drawableNode.getRadius(), 2)) {
                drawableNode.toggleSelected();
                break;
            }
        }
    }
    public void addNewNode(int x, int y) {

        nodes.add(new DrawableNode(x, y));


    }
    @Override
    public void mouseClicked(MouseEvent e) {
        boolean selectedMode = true;
        int x = e.getX();
        int y = e.getY();

        if(selectedMode) {
            selectNode(x, y);
            repaint();
        } else {
            addNewNode(x, y);
            repaint();
        }


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
