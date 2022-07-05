package edu.app.graphcomponents;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawableNode extends Node {

    private final int radius = 10;
    private final int x;
    private final int y;
    private boolean isSelected = false;
    private final ArrayList<String> incidentalNodesId;


    public DrawableNode(int centerX, int centerY) {
        this.x = centerX;
        this.y = centerY;
        this.incidentalNodesId = new ArrayList<String>();
        this.id = Integer.toString(this.x) + "#" + Integer.toString(this.y);
    }


    public void drawSelectedNode(Graphics2D g2) {
        g2.setPaint(new Color(70, 188, 104));
        g2.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public void drawUnselectedNode(Graphics2D g2) {
        g2.setPaint(new Color(187, 211, 245));
        g2.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public void drawNode(Graphics2D g2) {
        if(isSelected) {
            drawSelectedNode(g2);
        } else {
            drawUnselectedNode(g2);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void toggleSelected() {
        isSelected = !isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void addIncidentalNode(DrawableNode node) {
        incidentalNodesId.add(node.getId());
    }
}
