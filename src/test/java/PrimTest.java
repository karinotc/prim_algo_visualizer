import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.app.algorithm.PrimAlgo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimTest {
    PrimAlgo algo;

    @BeforeEach
    void setUp() {
        algo = new PrimAlgo();
    }

    @Test
    @DisplayName("Graph with one nodes")
    void testPrimAlgoOne() {
        algo.addNode();
        algo.runAlgorithm(1);

        String answer = algo.minimumSpanningTree();
        assertEquals(answer, "", "wrong answer");
    }

    @Test
    @DisplayName("Graph with two nodes (first node)")
    void testPrimAlgoTwo1() {
        algo.addNode();
        algo.addNode();
        algo.addEdge(1, 2, 2);
        algo.runAlgorithm(1);

        String answer = algo.minimumSpanningTree();
        assertEquals(answer, "1 2 2\n", "wrong answer");
    }

    @Test
    @DisplayName("Graph with two nodes (second node)")
    void testPrimAlgoTwo2() {
        algo.addNode();
        algo.addNode();
        algo.addEdge(1, 2, 2);
        algo.runAlgorithm(2);

        String answer = algo.minimumSpanningTree();
        assertEquals(answer, "2 1 2\n", "wrong answer");
    }

    @Test
    @DisplayName("Graph with edges of zero weight")
    void testPrimAlgoZeroWeight() {
        algo.addNode();
        algo.addNode();
        algo.addNode();
        algo.addEdge(1, 2, 0);
        algo.addEdge(2, 3, 0);
        algo.addEdge(1, 3, 0);

        algo.runAlgorithm(2);
        String answer = algo.minimumSpanningTree();
        assertEquals(answer, "1 3 0\n2 1 0\n", "wrong answer");
    }

    //void testPrimAlgoDisconnected(){}

    @Test
    @DisplayName("Graph with ten nodes")
    void testPrimAlgoTen() {
        for (int i = 0; i < 10; i++) {
            algo.addNode();
        }
        algo.addEdge(1, 2, 4);
        algo.addEdge(2, 3, 2);
        algo.addEdge(3, 4, 1);
        algo.addEdge(1, 5, 10);
        algo.addEdge(2, 6, 1);
        algo.addEdge(3, 7, 5);
        algo.addEdge(4, 8, 5);
        algo.addEdge(5, 6, 6);
        algo.addEdge(6, 7, 3);
        algo.addEdge(7, 8, 4);
        algo.addEdge(6, 9, 7);
        algo.addEdge(7, 10, 2);
        algo.addEdge(9, 10, 1);

        algo.runAlgorithm(4);

        String answer = algo.minimumSpanningTree();
        assertEquals(answer, "2 6 1\n2 1 4\n3 2 2\n4 3 1\n6 5 6\n6 7 3\n7 10 2\n7 8 4\n10 9 1\n", "wrong answer");
    }
}
