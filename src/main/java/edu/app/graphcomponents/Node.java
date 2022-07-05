package edu.app.graphcomponents;

import java.util.HashMap;
import java.util.Map;

abstract public class Node {
    String id;
    private final Map<Node, Edge> adjacent = new HashMap<>();

    String getId() {
        return id;
    }

    public void addAdjacent(Node node, Edge edge) {
        adjacent.put(node, edge);
    }
}
