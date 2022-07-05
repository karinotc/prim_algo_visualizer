package edu.app.graph;

import edu.app.graphcomponents.AlgoEdge;
import edu.app.graphcomponents.AlgoNode;

import java.util.ArrayList;

public class WeightedConnectedGraph implements Graph, Weighted, Connected {
    ArrayList<AlgoNode> adjacencyList;

    public WeightedConnectedGraph () {
        adjacencyList = new ArrayList<>();
    }

    @Override
    public void addNode() {
        adjacencyList.add(new AlgoNode());
    }

    @Override
    public void addEdge(int from, int to) {
        adjacencyList.get(from - 1).addAdjacent(adjacencyList.get(to - 1), new AlgoEdge());
        adjacencyList.get(to - 1).addAdjacent(adjacencyList.get(from - 1), new AlgoEdge());
    }
    public void addWeightedEdge(int from, int to, int weight) {
        adjacencyList.get(from - 1).addAdjacent(adjacencyList.get(to - 1), new AlgoEdge(weight));
        adjacencyList.get(to - 1).addAdjacent(adjacencyList.get(from - 1), new AlgoEdge(weight));
    }

    @Override
    public void clear() {
        adjacencyList.clear();
    }

    @Override
    public void setWeight(int from, int to, int weight) {
        adjacencyList.get(from - 1).getEdge(adjacencyList.get(to - 1)).setWeight(weight);
        adjacencyList.get(to - 1).getEdge(adjacencyList.get(from - 1)).setWeight(weight);
    }

    @Override
    public int getWeight(int from, int to) {
        return adjacencyList.get(from - 1).getEdge(adjacencyList.get(to - 1)).getWeight();
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    public boolean allNodesChecked() {
        for (AlgoNode node : adjacencyList) {
            if (!node.isVisited())
                return false;
        }
        return true;
    }

    public int getListSize() {
        return adjacencyList.size();
    }

    public AlgoNode getNode(int index) {
        return adjacencyList.get(index);
    }

    public int getNodeIndex(AlgoNode node) {
        return adjacencyList.indexOf(node);
    }
}
