import edu.app.graph.WeightedConnectedGraph;
import edu.app.input.RandomGraphGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomGraphGeneratorTest {
    @RepeatedTest(10)
    @DisplayName("Test generation with one node")
    void testOneNode(){
        WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(1, 0, 0, 1, 1);
        assertEquals(graph.getListSize(), 1);
    }

    @RepeatedTest(20)
    @DisplayName("Test generation with one node")
    void testTenNodes(){
        WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(10, 5, 10, 1, 20);
        assertTrue(graph.isConnected());
        assertEquals(graph.getListSize(), 10);
        int edgeAmount = graph.getEdgeAmount();
        assertTrue((edgeAmount <= 10 && edgeAmount >= 5));

        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                if (i==j) continue;
                if (graph.getNode(i).getNeighbours().contains(graph.getNode(j))){
                    int weight = graph.getNode(i).getEdge(graph.getNode(j)).getWeight();
                    assertTrue((weight>=1 && weight <= 20));
                }
            }
        }
    }
}
