package edu.app.input;

import edu.app.graph.WeightedConnectedGraph;

import javax.swing.plaf.InsetsUIResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGraphGenerator {
    public RandomGraphGenerator() {}
    public static WeightedConnectedGraph createRandomGraph(int nodeAmount, int minEdgeAmount, int maxEdgeAmount, int minWeight, int maxWeight){
        ArrayList<Integer> nodeList = new ArrayList<Integer>(nodeAmount);
        for (int i = 0; i<nodeAmount; i++){
            nodeList.add(i);
        }
        Collections.shuffle(nodeList);
        WeightedConnectedGraph graph = new WeightedConnectedGraph();
        for (int i = 0; i<nodeAmount; i++){
            graph.addNode();
        }
        for (int i = 0; i<nodeAmount-1; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(minWeight, maxWeight + 1);
            graph.addWeightedEdge(nodeList.get(i)+1, nodeList.get(i+1)+1, randomNum);
        }

        int neededEdgeAmount = ThreadLocalRandom.current().nextInt(minEdgeAmount, maxEdgeAmount + 1);
        int currentEdgeAmount = nodeAmount - 1;

        while(currentEdgeAmount < neededEdgeAmount) {
            enough:
            for (int i = 1; i <= nodeAmount; i++) {
                for (int j = 1; j <= nodeAmount; j++) {
                    if (currentEdgeAmount >= neededEdgeAmount) break enough;
                    if (i == j || graph.getNode(i - 1).getNeighbours().contains(graph.getNode(j - 1)) || Math.random() > 0.25) continue;
                    int randomNum = ThreadLocalRandom.current().nextInt(minWeight, maxWeight + 1);
                    graph.addWeightedEdge(i, j, randomNum);
                    currentEdgeAmount++;
                }
            }
        }
        return graph;
    }
}
