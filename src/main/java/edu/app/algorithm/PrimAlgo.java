package edu.app.algorithm;

import edu.app.exceptions.PrimException;
import edu.app.graph.WeightedConnectedGraph;
import edu.app.graphcomponents.*;

import java.util.Map;

public class PrimAlgo {

    public PrimAlgo() {}

    public static void runAlgorithm(WeightedConnectedGraph graph, int startNode) {
        if (graph.getListSize() == 0)
            throw new PrimException("Graph can't be empty");
        if (!graph.isConnected())
            throw new PrimException("Graph must be connected");

        if (graph.getListSize() > 0) {
            graph.getNode(startNode - 1).visit();
        }

        while (!graph.allNodesChecked()) {
            AlgoEdge nextMinEdge = new AlgoEdge(Integer.MAX_VALUE);
            AlgoNode nextAlgoNode = graph.getNode(startNode - 1);
            for (int i = 0; i < graph.getListSize(); i++) {
                AlgoNode node = graph.getNode(i);
                if (node.isVisited()) {
                    Map.Entry<AlgoNode, AlgoEdge> candidate = node.getMinEdge();
                    if (candidate.getValue().getWeight()<0)
                        throw new PrimException("Weight must be a positive number");
                    if (candidate.getValue().getWeight() < nextMinEdge.getWeight()) {
                        nextMinEdge = candidate.getValue();
                        nextAlgoNode = candidate.getKey();
                    }
                }
            }
            nextMinEdge.include();
            nextAlgoNode.visit();
        }
    }
}