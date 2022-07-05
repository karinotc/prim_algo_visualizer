package edu.app.graphcomponents;

import java.awt.*;

public class DrawableEdge extends Edge {

    private final int stroke = 3;
    private int startX, startY, endX, endY;


    public DrawableEdge(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public void drawLine(Graphics2D g2) {
        g2.setStroke(new BasicStroke(stroke));
        g2.setPaint(new Color(0, 0, 0));
        g2.drawLine(startX, startY, endX, endY);
    }

}
