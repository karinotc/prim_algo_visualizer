package edu.app.graph;

import edu.app.graphcomponents.AlgoEdge;
import edu.app.graphcomponents.AlgoNode;
import edu.app.graphcomponents.DrawableEdge;
import edu.app.graphcomponents.DrawableNode;

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
