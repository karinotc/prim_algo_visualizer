package edu.app.graphcomponents;

import java.awt.*;

public class DrawableEdge extends Edge {

    private final int stroke = 3;
    private int startX, startY, endX, endY;


    public DrawableEdge(DrawableNode firstNode, DrawableNode secondNode) {
        this.startX = firstNode.getX();
        this.startY = firstNode.getY();
        this.endX = secondNode.getX();
        this.endY = secondNode.getY();
    }

    public void drawEdge(Graphics2D g2) {
        g2.setStroke(new BasicStroke(stroke));
        g2.setPaint(new Color(0, 0, 0));
        g2.drawLine(startX, startY, endX, endY);
    }

}
