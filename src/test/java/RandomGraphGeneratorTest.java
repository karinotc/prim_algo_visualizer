import edu.app.exceptions.GenerationException;
import edu.app.exceptions.PrimException;
import edu.app.graph.WeightedConnectedGraph;
import edu.app.input.RandomGraphGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomGraphGeneratorTest {
    @RepeatedTest(10)
    @DisplayName("Test generation with one node")
    void testOneNode(){
        WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(1, 0, 0, 1, 1);
        assertEquals(graph.getListSize(), 1);
    }

    @RepeatedTest(20)
    @DisplayName("Test generation with ten nodes")
    void testTenNodes(){
        WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(10, 9, 15, 1, 20);
        assertTrue(graph.isConnected());
        assertEquals(graph.getListSize(), 10);
        int edgeAmount = graph.getEdgeAmount();
        assertTrue((edgeAmount <= 15 && edgeAmount >= 9));

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

    @Test
    @DisplayName("Test generation with zero nodes")
    void testZeroNodes(){
        Exception exception = assertThrows(GenerationException.class, () -> {
            WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(0, 0, 0, 1, 1);
        });
        Assertions.assertEquals("Amount of nodes must be more than 0", exception.getMessage());
    }

    @Test
    @DisplayName("Test generation with wrong min edge amount")
    void testWrongMinEdgeAmount(){
        Exception exception = assertThrows(GenerationException.class, () -> {
            WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(6, 4, 10, 1, 10);
        });
        Assertions.assertEquals("Minimal edge amount can't be less than (node amount - 1)", exception.getMessage());
    }

    @Test
    @DisplayName("Test generation with max edge amount less than min")
    void testMaxEdgeAmountLessThanMin(){
        Exception exception = assertThrows(GenerationException.class, () -> {
            WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(6, 5, 3, 1, 10);
        });
        Assertions.assertEquals("Maximum edge amount can't be less than minimum", exception.getMessage());
    }

    @Test
    @DisplayName("Test generation with wrong max edge amount")
    void testWrongMaxEdgeAmount(){
        Exception exception = assertThrows(GenerationException.class, () -> {
            WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(5, 5, 11, 1, 10);
        });
        Assertions.assertEquals("Maximum edge amount can't be more than ((node amount)(node amount - 1)/2)", exception.getMessage());
    }

    @Test
    @DisplayName("Test generation with negative min weight")
    void testNegativeMinWeight(){
        Exception exception = assertThrows(GenerationException.class, () -> {
            WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(5, 5, 9, -2, 10);
        });
        Assertions.assertEquals("Weight must be a positive number", exception.getMessage());
    }

    @Test
    @DisplayName("Test generation with max weight less than min")
    void testMaxWeightLessThanMin(){
        Exception exception = assertThrows(GenerationException.class, () -> {
            WeightedConnectedGraph graph = RandomGraphGenerator.createRandomGraph(5, 6, 9, 6, 4);
        });
        Assertions.assertEquals("Maximum weight can't be less than minimum", exception.getMessage());
    }

}
