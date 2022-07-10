package edu.app.graph;

import edu.app.exceptions.WCGraphException;
import edu.app.graphcomponents.AlgoEdge;
import edu.app.graphcomponents.AlgoNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class WeightedConnectedGraph implements Graph, Weighted, Connected {
    ArrayList<AlgoNode> adjacencyList;

    public WeightedConnectedGraph () {
        adjacencyList = new ArrayList<>();
    }

    @Override
    public void addNode() {
        adjacencyList.add(new AlgoNode(Integer.toString(adjacencyList.size() + 1)));
    }

    @Override
    public void addEdge(int from, int to) {
        if (from == to)
            throw new WCGraphException("Edge can't connect same nodes");
        adjacencyList.get(from - 1).addAdjacent(adjacencyList.get(to - 1), new AlgoEdge());
        adjacencyList.get(to - 1).addAdjacent(adjacencyList.get(from - 1), new AlgoEdge());
    }
    public void addWeightedEdge(int from, int to, int weight) {
        if (from == to)
            throw new WCGraphException("Edge can't connect same nodes");
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

    private void dfs(int source, ArrayList<AlgoNode> adjacencyList, boolean[] visited) {
        visited[source] = true;

        for (int i = 0; i < adjacencyList.size(); i++) {
            Set<AlgoNode> neighbours = adjacencyList.get(source).getNeighbours();
            Iterator<AlgoNode> it = neighbours.iterator();

            for (AlgoNode node : neighbours) {
                int nodeIndex = adjacencyList.indexOf(node);
                if (!visited[nodeIndex])
                    dfs(nodeIndex, adjacencyList, visited);
            }
        }
    }

    @Override
    public boolean isConnected() {
        if (adjacencyList.size() == 0)
            return false;
        boolean[] visited = new boolean[adjacencyList.size()];
        ArrayList<AlgoNode> copy = new ArrayList<>(adjacencyList);
        dfs(0, copy, visited);

        boolean connected = true;
        for (boolean i : visited) {
            if (!i) {
                connected = false;
                break;
            }
        }

        return connected;
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

    public int getEdgeAmount(){
        int edgeAmount = 0;
        for (AlgoNode node : adjacencyList){
            edgeAmount += node.getNeighbours().size();
        }
        edgeAmount /= 2;
        return edgeAmount;
    }
}
