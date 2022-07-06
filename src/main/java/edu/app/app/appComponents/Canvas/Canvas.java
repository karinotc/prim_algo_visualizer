package edu.app.app.appComponents.Canvas;

import edu.app.app.appComponents.Canvas.CanvasComponents.CanvasForm;
import edu.app.app.appComponents.Canvas.CanvasComponents.WeightInputWindow;
import edu.app.graphcomponents.DrawableEdge;
import edu.app.graphcomponents.DrawableNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener, ActionListener {

    private int nodeCurrentId;
    private final ArrayList<DrawableNode> nodes;
    private final ArrayList<DrawableEdge> edges;
    private final ArrayList<DrawableNode> selectedNodes;

    CanvasForm form;
    JButton submitButton;
    JTextField textField;
    public Canvas() {
        nodes = new ArrayList<DrawableNode>();
        edges = new ArrayList<DrawableEdge>();
        selectedNodes = new ArrayList<DrawableNode>();
        this.addMouseListener(this);

        form = new CanvasForm();
        form.submitButton.addActionListener(this);;


        this.setLayout(new BorderLayout());
        this.add(form, BorderLayout.LINE_END);

        addNewNode(100, 100);
        addNewNode(230, 45);
        addNewNode(89, 32);
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

        selectedNodes.clear();
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


    private void createWeighedEdgeBetweenTwoNodes(DrawableNode firstNode, DrawableNode secondNode, int weight) {

        DrawableEdge newEdge = new DrawableEdge(firstNode, secondNode, weight);
        firstNode.addIncidentalNode(secondNode);
        secondNode.addIncidentalNode(firstNode);
        edges.add(newEdge);
    }

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
            createWeighedEdgeBetweenTwoNodes(selectedNodes.get(0), selectedNodes.get(1), weight);

        } catch (NumberFormatException exception) {
            System.out.println("Wrong input format");
        }

        unselectAllNodes();
        form.disableForm();
        repaint();

    }
}
