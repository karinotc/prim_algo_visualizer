package edu.app.input;

import edu.app.exceptions.GenerationException;
import edu.app.graph.WeightedConnectedGraph;

import javax.swing.plaf.InsetsUIResource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomGraphGenerator {
    public RandomGraphGenerator() {}
    public static WeightedConnectedGraph createRandomGraph(int nodeAmount, int minEdgeAmount, int maxEdgeAmount, int minWeight, int maxWeight){
        if (nodeAmount <= 0){
            throw new GenerationException("Amount of nodes must be more than 0");
        }
        if (minEdgeAmount < nodeAmount-1){
            throw new GenerationException("Minimal edge amount can't be less than (node amount - 1)");
        }
        if (maxEdgeAmount < minEdgeAmount){
            throw new GenerationException("Maximum edge amount can't be less than minimum");
        }
        if (maxEdgeAmount>nodeAmount*(nodeAmount-1)/2){
            throw new GenerationException("Maximum edge amount can't be more than ((node amount)(node amount - 1)/2)");
        }
        if (minWeight < 0){
            throw new GenerationException("Weight must be a positive number");
        }
        if (maxWeight < minWeight){
            throw new GenerationException("Maximum weight can't be less than minimum");
        }


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
