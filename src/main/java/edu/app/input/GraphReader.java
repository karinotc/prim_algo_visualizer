package edu.app.input;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import edu.app.graph.WeightedConnectedGraph;

public class GraphReader {
    public GraphReader() {
    }

    public static WeightedConnectedGraph readFromJSON(String filePath) {
        WeightedConnectedGraph graph = new WeightedConnectedGraph();

        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            GraphInfo info = gson.fromJson(reader, GraphInfo.class);

            for (int i = 0; i < info.nodeNumber; i++) {
                graph.addNode();
            }

            for (int i = 0; i < info.edges.length; i++) {
                graph.addWeightedEdge(info.edges[i][0], info.edges[i][1], info.edges[i][2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return graph;
    }

    private static class GraphInfo {
        public int nodeNumber = 0;
        public int[][] edges;
    }
}
