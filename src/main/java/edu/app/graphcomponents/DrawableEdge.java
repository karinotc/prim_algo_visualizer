package edu.app.graphcomponents;

import java.awt.*;

public class DrawableEdge extends Edge {

    //private final Color basicEdgeColor = new Color(0, 0, 0);
    private final Color weightTextColor = new Color(101, 254, 154);
    private final Color weightTextBackgroundColor = new Color(162, 36, 184);
    private int r, g, b = 0;

    private final int stroke = 3;
    private int startX, startY, endX, endY, weight;

    private DrawableNode firstNode, secondNode;


    public DrawableEdge(DrawableNode firstNode, DrawableNode secondNode, int weight) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.startX = firstNode.getX();
        this.startY = firstNode.getY();
        this.endX = secondNode.getX();
        this.endY = secondNode.getY();
        this.weight = weight;
    }

    public void drawWeight(Graphics2D g2) {

        int weightTextBlockWidth = 20;
        int weightTextBlockHeight = 10;

        int offsetX = weightTextBlockWidth / 2;
        int offsetY = weightTextBlockHeight / 2;

        int edgeMiddleX = (startX + endX) / 2;
        int edgeMiddleY = (startY + endY) / 2;

        g2.setStroke(new BasicStroke(1));
        g2.setPaint(weightTextColor);
        g2.fillRect(edgeMiddleX - offsetX, edgeMiddleY - offsetY, weightTextBlockWidth, weightTextBlockHeight);
        g2.setPaint(weightTextBackgroundColor);
        g2.drawString(Integer.toString(weight), edgeMiddleX - offsetX, edgeMiddleY + offsetY);
    }

    public void recolorIncludedEdge(){
        r = 0;
        g = 0;
        b = 255;
    }

    public void drawEdge(Graphics2D g2) {

        startX = firstNode.getX();
        startY = firstNode.getY();
        endX = secondNode.getX();
        endY = secondNode.getY();

        g2.setStroke(new BasicStroke(stroke));
        g2.setPaint(new Color(r, g, b));
        g2.drawLine(startX, startY, endX, endY);
        drawWeight(g2);
    }

    public int getStartX(){ return startX; }
    public int getStartY(){ return startY; }
    public int getEndX(){ return endX; }
    public int getEndY(){ return endY; }

}
