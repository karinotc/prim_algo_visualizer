//package test;

import edu.app.algorithm.PrimAlgo;
import edu.app.exceptions.PrimException;
import edu.app.graph.WeightedConnectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimTest {
    PrimAlgo algo;
    WeightedConnectedGraph graph;

    @BeforeEach
    void setUp() {
        algo = new PrimAlgo();
        graph = new WeightedConnectedGraph();
    }

    @Test
    @DisplayName("Graph with one node")
    void testPrimAlgoOne() {
        graph.addNode();
        algo.runAlgorithm(graph, 1);

        assertTrue(graph.getNode(0).isVisited());
    }

    @Test
    @DisplayName("Graph with two nodes (start in first node)")
    void testPrimAlgoTwo1() {
        graph.addNode();
        graph.addNode();
        graph.addWeightedEdge(1, 2, 2);
        algo.runAlgorithm(graph, 1);

        assertTrue(graph.getNode(0).isVisited());
        assertTrue(graph.getNode(1).isVisited());
        assertTrue(graph.getNode(0).getEdge(graph.getNode(1)).isIncluded());
    }

    @Test
    @DisplayName("Graph with two nodes (start in second node)")
    void testPrimAlgoTwo2() {
        graph.addNode();
        graph.addNode();
        graph.addWeightedEdge(1, 2, 2);
        algo.runAlgorithm(graph, 2);

        assertTrue(graph.getNode(0).isVisited());
        assertTrue(graph.getNode(1).isVisited());
        assertTrue(graph.getNode(1).getEdge(graph.getNode(0)).isIncluded());
    }

    @Test
    @DisplayName("Graph with edges of zero weight")
    void testPrimAlgoZeroWeight() {
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addWeightedEdge(1, 2, 0);
        graph.addWeightedEdge(2, 3, 0);
        graph.addWeightedEdge(1, 3, 0);

        algo.runAlgorithm(graph,1);
        assertTrue(graph.getNode(0).isVisited());
        assertTrue(graph.getNode(1).isVisited());
        assertTrue(graph.getNode(2).isVisited());
        assertTrue(graph.getNode(0).getEdge(graph.getNode(1)).isIncluded());
        assertTrue(graph.getNode(0).getEdge(graph.getNode(2)).isIncluded());

        assertFalse(graph.getNode(1).getEdge(graph.getNode(2)).isIncluded());
        assertFalse(graph.getNode(2).getEdge(graph.getNode(1)).isIncluded());
    }

    @Test
    @DisplayName("Graph with ten nodes")
    void testPrimAlgoTen() {
        for (int i = 0; i<10; i++) {
            graph.addNode();
        }
        graph.addWeightedEdge(1, 2, 4);
        graph.addWeightedEdge(2, 3, 2);
        graph.addWeightedEdge(3, 4, 1);
        graph.addWeightedEdge(1, 5, 10);
        graph.addWeightedEdge(2, 6, 1);
        graph.addWeightedEdge(3, 7, 5);
        graph.addWeightedEdge(4, 8, 5);
        graph.addWeightedEdge(5, 6, 6);
        graph.addWeightedEdge(6, 7, 3);
        graph.addWeightedEdge(7, 8, 4);
        graph.addWeightedEdge(6, 9, 7);
        graph.addWeightedEdge(7, 10, 2);
        graph.addWeightedEdge(9, 10, 1);

        algo.runAlgorithm(graph,4);
        assertTrue(graph.getNode(0).isVisited());
        assertTrue(graph.getNode(1).isVisited());
        assertTrue(graph.getNode(2).isVisited());
        assertTrue(graph.getNode(3).isVisited());
        assertTrue(graph.getNode(4).isVisited());
        assertTrue(graph.getNode(5).isVisited());
        assertTrue(graph.getNode(6).isVisited());
        assertTrue(graph.getNode(7).isVisited());
        assertTrue(graph.getNode(8).isVisited());
        assertTrue(graph.getNode(9).isVisited());
        assertTrue(graph.getNode(1).getEdge(graph.getNode(0)).isIncluded());
        assertTrue(graph.getNode(2).getEdge(graph.getNode(1)).isIncluded());
        assertTrue(graph.getNode(3).getEdge(graph.getNode(2)).isIncluded());
        assertTrue(graph.getNode(1).getEdge(graph.getNode(5)).isIncluded());
        assertTrue(graph.getNode(5).getEdge(graph.getNode(4)).isIncluded());
        assertTrue(graph.getNode(5).getEdge(graph.getNode(6)).isIncluded());
        assertTrue(graph.getNode(6).getEdge(graph.getNode(7)).isIncluded());
        assertTrue(graph.getNode(6).getEdge(graph.getNode(9)).isIncluded());
        assertTrue(graph.getNode(9).getEdge(graph.getNode(8)).isIncluded());

        assertFalse(graph.getNode(0).getEdge(graph.getNode(4)).isIncluded());
        assertFalse(graph.getNode(4).getEdge(graph.getNode(0)).isIncluded());
        assertFalse(graph.getNode(2).getEdge(graph.getNode(6)).isIncluded());
        assertFalse(graph.getNode(6).getEdge(graph.getNode(2)).isIncluded());
        assertFalse(graph.getNode(3).getEdge(graph.getNode(7)).isIncluded());
        assertFalse(graph.getNode(7).getEdge(graph.getNode(3)).isIncluded());
        assertFalse(graph.getNode(5).getEdge(graph.getNode(8)).isIncluded());
        assertFalse(graph.getNode(8).getEdge(graph.getNode(5)).isIncluded());
    }

    @Test
    @DisplayName("Graph with zero nodes")
    void testPrimAlgoZero() {
        Exception exception = assertThrows(PrimException.class, () -> {
            algo.runAlgorithm(graph, 1);
        });
        Assertions.assertEquals("Graph can't be empty", exception.getMessage());
    }

    @Test
    @DisplayName("Disconnected graph")
    void testPrimAlgoDisconnected() {
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addWeightedEdge(1, 2, 2);
        Exception exception = assertThrows(PrimException.class, () -> {
            algo.runAlgorithm(graph, 1);
        });
        Assertions.assertEquals("Graph must be connected", exception.getMessage());
    }
}
