package edu.app.graphcomponents;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    private int number;
    private Status status = Status.NOT_VISITED;
    private final Map<Node, Edge> adjacent = new HashMap<>();

    public Node(int number) {
        this.number = number;
    }

    public void addAdjacent(Node node, Edge edge) {
        adjacent.put(node, edge);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public Map<Node, Edge> getAdjacent() {
        return this.adjacent;
    }

    public boolean isVisited() {
        return this.status == Status.VISITED;
    }

    public int getNumber() {
        return this.number;
    }

    public Map.Entry<Node, Edge> getMinEdge() {
        Edge minEdge = new Edge(Integer.MAX_VALUE);
        Node nextNode = this;
        for (Map.Entry<Node, Edge> pair : adjacent.entrySet()) {
            if (!pair.getKey().isVisited() && pair.getValue().getStatus() != Status.VISITED && pair.getValue().getStatus() != Status.BELONGS_TO_MST) {
                if (pair.getValue().getWeight() < minEdge.getWeight()) {
                    minEdge = pair.getValue();
                    nextNode = pair.getKey();
                }
            }
        }
        return new AbstractMap.SimpleEntry<Node, Edge>(nextNode, minEdge);
    }
}
