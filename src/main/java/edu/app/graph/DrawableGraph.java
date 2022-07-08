package edu.app.graph;

import edu.app.algorithm.PrimAlgo;
import edu.app.graphcomponents.AlgoEdge;
import edu.app.graphcomponents.AlgoNode;
import edu.app.graphcomponents.DrawableEdge;
import edu.app.graphcomponents.DrawableNode;
import edu.app.input.GraphReader;
import edu.app.input.RandomGraphGenerator;

import java.util.ArrayList;

public class DrawableGraph {
    private WeightedConnectedGraph graph;
    private ArrayList<DrawableNode> nodeList;
    private ArrayList<DrawableEdge> edgeList;

    public DrawableGraph() {
        graph = new WeightedConnectedGraph();
        nodeList = new ArrayList<>();
        edgeList = new ArrayList<>();
    }

    public void addDrawableNode(int centerX, int centerY) {
        graph.addNode();
        DrawableNode node = new DrawableNode(centerX, centerY);
        node.setNumber(nodeList.size()+1);
        nodeList.add(node);
    }

    public void addDrawableEdge(int from, int to, int weight) {
        graph.addWeightedEdge(from+1, to+1, weight);
        edgeList.add(new DrawableEdge(nodeList.get(from), nodeList.get(to), weight));
        nodeList.get(from).addIncidentalNode(nodeList.get(to));
        nodeList.get(to).addIncidentalNode(nodeList.get(from));
    }

    public void runPrim(int start){
        if (!graph.isConnected()){
            return;
        }
        PrimAlgo.runAlgorithm(graph, start);
        for (int i = 0; i<graph.getListSize(); i++){
            for (int j = 0; j<graph.getListSize(); j++){
                if (i >= j) continue;
                if (graph.getNode(i).getNeighbours().contains(graph.getNode(j)) && (graph.getNode(i).getEdge(graph.getNode(j)).isIncluded() || graph.getNode(j).getEdge(graph.getNode(i)).isIncluded())){
                    for (int k = 0; k < edgeList.size(); k++){
                        if ((nodeList.get(i).getX() == edgeList.get(k).getStartX() && nodeList.get(i).getY() == edgeList.get(k).getStartY() &&
                                nodeList.get(j).getX() == edgeList.get(k).getEndX() && nodeList.get(j).getY() == edgeList.get(k).getEndY()) ||
                                (nodeList.get(j).getX() == edgeList.get(k).getStartX() && nodeList.get(j).getY() == edgeList.get(k).getStartY() &&
                                        nodeList.get(i).getX() == edgeList.get(k).getEndX() && nodeList.get(i).getY() == edgeList.get(k).getEndY())){
                            edgeList.get(k).recolorIncludedEdge();
                        }
                    }
                }
            }
        }
    }

    public void randomizeGraph(int centerX, int centerY, int nodeAmount, int minEdgeAmount, int maxEdgeAmount, int minWeight, int maxWeight){
        clear();
        graph = RandomGraphGenerator.createRandomGraph(nodeAmount, minEdgeAmount, maxEdgeAmount, minWeight, maxWeight);
        createDrawableGraph(centerX, centerY, nodeAmount);
    }

    public void readGraphFromFile(int centerX, int centerY) {
        clear();
        graph = GraphReader.readFromJSON();
        createDrawableGraph(centerX, centerY, graph.getListSize());
    }

    void createDrawableGraph(int centerX, int centerY, int nodeAmount) {
        double increment = 360/nodeAmount;
        for (int i = 0; i<nodeAmount; i++) {
            int x = (int)(centerX + 150*Math.cos(Math.toRadians(increment*i)));
            int y = (int)(centerY + 150*Math.sin(Math.toRadians(increment*i)));
            DrawableNode node = new DrawableNode(x, y);
            node.setNumber(nodeList.size()+1);
            nodeList.add(node);
        }

        for (int i = 0; i<graph.getListSize(); i++){
            for (int j = 0; j<graph.getListSize(); j++){
                if (i==j) continue;
                if (i<j && graph.getNode(i).getNeighbours().contains(graph.getNode(j))){
                    edgeList.add(new DrawableEdge(nodeList.get(i), nodeList.get(j), graph.getNode(i).getEdge(graph.getNode(j)).getWeight()));
                    nodeList.get(i).addIncidentalNode(nodeList.get(j));
                    nodeList.get(j).addIncidentalNode(nodeList.get(i));
                }
            }
        }
    }

    public void clear() {
        graph.clear();
        nodeList.clear();
        edgeList.clear();
    }

    public DrawableNode getNode(int index){
        return nodeList.get(index);
    }

    public DrawableEdge getEdge(int index){
        return edgeList.get(index);
    }

    public int getNodeAmount(){
        return nodeList.size();
    }

    public int getEdgeAmount(){
        return edgeList.size();
    }

}
