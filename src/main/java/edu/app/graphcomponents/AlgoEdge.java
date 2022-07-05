package edu.app.graphcomponents;

public class AlgoEdge extends Edge{
    private int weight = 0;
    private boolean isIncluded = false;

    public AlgoEdge() {
    }

    public AlgoEdge(int weight) {
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public void include() {
        isIncluded = true;
    }

    public boolean isIncluded() {
        return isIncluded;
    }
}