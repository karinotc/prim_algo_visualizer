package edu.app.graph;

public interface Weighted {
    void setWeight(int from, int to, int weight);
    int getWeight(int from, int to);
}
