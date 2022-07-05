package edu.app.graphcomponents;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class AlgoNode extends Node{
    private boolean isVisited = false;

    private final Map<AlgoNode, AlgoEdge> adjacent = new HashMap<>();

    public AlgoNode() {}

    public void addAdjacent(AlgoNode node, AlgoEdge edge) {
        adjacent.put(node, edge);
    }

    public void visit() {
        isVisited = true;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public AlgoEdge getEdge(AlgoNode to) {
        return adjacent.get(to);
    }

    public Map.Entry<AlgoNode, AlgoEdge> getMinEdge() {
        AlgoEdge minEdge = new AlgoEdge(Integer.MAX_VALUE);
        AlgoNode nextNode = this;
        for (Map.Entry<AlgoNode, AlgoEdge> pair : adjacent.entrySet()) {
            if (!pair.getKey().isVisited() && !pair.getValue().isIncluded()){
                if (pair.getValue().getWeight() < minEdge.getWeight()) {
                    minEdge = pair.getValue();
                    nextNode = pair.getKey();
                }
            }
        }
        return new AbstractMap.SimpleEntry<AlgoNode, AlgoEdge>(nextNode, minEdge);
    }
}
