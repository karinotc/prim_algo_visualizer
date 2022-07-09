package edu.app.graphcomponents;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class DrawableNode extends Node {

    private final int radius = 10;
    private int x;
    private int y;
    private final int prevX;
    private final int prevY;
    private boolean isSelected = false;
    private int number;

//    static int number1 = 1;
    private final ArrayList<String> incidentalNodesId;
    private final ArrayList<DrawableNode> incidentalNodes;


    public DrawableNode(int centerX, int centerY) {
        this.x = centerX;
        this.y = centerY;
        this.prevX = centerX;
        this.prevY = centerY;
        this.incidentalNodesId = new ArrayList<>();
        this.incidentalNodes = new ArrayList<>();
        this.id = this.x + "#" + this.y;
    }


    private void drawSelectedNode(Graphics2D g2) {
        g2.setPaint(new Color(70, 188, 104));
        g2.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    private void drawUnselectedNode(Graphics2D g2) {
        g2.setPaint(new Color(187, 211, 245));
        g2.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    private void drawNodeNumber(Graphics2D g2) {
        g2.setPaint(new Color(0, 0, 0));



        String stringNumber = Integer.toString(number);

        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(stringNumber, g2);
        int offsetX = (2 * radius - (int) r.getWidth()) / 2;
        int offsetY = (2 * radius - (int) r.getHeight()) / 2 + fm.getAscent();
        g2.drawString(stringNumber, x - radius + offsetX, y + 2 * radius - offsetY);
    }

    public void drawNode(Graphics2D g2) {
        if(isSelected) {
            drawSelectedNode(g2);
        } else {
            drawUnselectedNode(g2);
        }
        drawNodeNumber(g2);
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
        incidentalNodes.add(node);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setX(int newX) {
        this.x = newX;
    }
    public void setY(int newY) {
        this.y = newY;
    }

}
