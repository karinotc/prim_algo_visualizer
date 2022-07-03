package edu.app.algorithm;

import edu.app.graphcomponents.*;

import java.util.ArrayList;
import java.util.Map;

public class PrimAlgo {
    private final ArrayList<Node> graph;

    public PrimAlgo() {
        this.graph = new ArrayList<>();
    }

    public void addNode() {
        graph.add(new Node(graph.size() + 1));
    }

    public void addEdge(int firstNode, int secondNode, Integer weight) {
        graph.get(firstNode - 1).addAdjacent(graph.get(secondNode - 1), new Edge(weight));
        graph.get(secondNode - 1).addAdjacent(graph.get(firstNode - 1), new Edge(weight));
    }

    private boolean isDisconnected() {
        for (Node node : graph) {
            if (!node.isVisited())
                return true;
        }
        return false;
    }

    public void runAlgorithm(int startNode) {
        if (graph.size() > 0) {
            graph.get(startNode - 1).setStatus(Status.VISITED);
        }

        while (isDisconnected()) {
            Edge nextMinEdge = new Edge(Integer.MAX_VALUE);
            Node nextNode = graph.get(startNode - 1);
            for (Node node : graph) {
                if (node.isVisited()) {
                    Map.Entry<Node, Edge> candidate = node.getMinEdge();
                    if (candidate.getValue().getWeight() < nextMinEdge.getWeight()) {
                        nextMinEdge = candidate.getValue();
                        nextNode = candidate.getKey();
                    }
                }
            }
            nextMinEdge.setStatus(Status.BELONGS_TO_MST);
            nextNode.setStatus(Status.VISITED);
        }
    }

    public String minimumSpanningTree() {
        StringBuilder mst = new StringBuilder();
        for (Node node : graph) {
            if (node.isVisited()) {
                Map<Node, Edge> adjacent = node.getAdjacent();
                for (Map.Entry<Node, Edge> pair : (Iterable<Map.Entry<Node, Edge>>) adjacent.entrySet()) {
                    if (pair.getValue().getStatus() == Status.BELONGS_TO_MST) {
                        if (!pair.getValue().isPrinted()) {
                            mst.append(graph.indexOf(node) + 1).append(" ");
                            mst.append(graph.indexOf(pair.getKey()) + 1).append(" ");
                            mst.append(pair.getValue().getWeight()).append("\n");
                            pair.getValue().setPrinted(true);
                        }
                    }
                }
            }
        }
        return mst.toString();
    }
}