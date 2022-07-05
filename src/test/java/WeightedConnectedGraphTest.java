import edu.app.graph.WeightedConnectedGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeightedConnectedGraphTest {
    WeightedConnectedGraph graph;

    @BeforeEach
    void setUp() {
        graph = new WeightedConnectedGraph();
    }

    @Test
    @DisplayName("Test addNode() method")
    void testAddNode(){
        assertEquals(graph.getListSize(), 0);
        graph.addNode();
        assertEquals(graph.getListSize(), 1);
    }

    @Test
    @DisplayName("Test addEdge() method")
    void testAddEdge(){
        graph.addNode();
        graph.addNode();
        graph.addEdge(1, 2);
        assertTrue(graph.getNode(0).getNeighbours().contains(graph.getNode(1)));
        assertTrue(graph.getNode(1).getNeighbours().contains(graph.getNode(0)));
    }


    @Test
    @DisplayName("Test addWeightedEdge() method")
    void testAddWeightedEdge(){
        graph.addNode();
        graph.addNode();
        graph.addWeightedEdge(1, 2, 10);
        assertTrue(graph.getNode(0).getNeighbours().contains(graph.getNode(1)));
        assertTrue(graph.getNode(1).getNeighbours().contains(graph.getNode(0)));
        assertEquals(graph.getNode(0).getEdge(graph.getNode(1)).getWeight(), 10);
    }

    @Test
    @DisplayName("Test clear() method")
    void testClear() {
        graph.addNode();
        graph.addNode();
        graph.addWeightedEdge(1, 2, 10);
        graph.clear();
        assertEquals(graph.getListSize(), 0);
    }

    @Test
    @DisplayName("Test setWeight() method")
    void testSetWeight(){
        graph.addNode();
        graph.addNode();
        graph.addEdge(1, 2);
        graph.setWeight(1, 2, 10);
        assertTrue(graph.getNode(0).getNeighbours().contains(graph.getNode(1)));
        assertTrue(graph.getNode(1).getNeighbours().contains(graph.getNode(0)));
        assertEquals(graph.getNode(0).getEdge(graph.getNode(1)).getWeight(), 10);
    }

    @Test
    @DisplayName("Test getEdgeAmount() method")
    void testGetEdgeAmount(){
        for (int i = 0; i < 10; i++){
            graph.addNode();
        }
        assertEquals(graph.getEdgeAmount(), 0);
        graph.addEdge(1, 2);
        assertEquals(graph.getEdgeAmount(), 1);
        graph.addEdge(3, 4);
        assertEquals(graph.getEdgeAmount(), 2);
        graph.addWeightedEdge(5, 6, 10);
        graph.addEdge(7, 6);
        assertEquals(graph.getEdgeAmount(), 4);

    }
}
