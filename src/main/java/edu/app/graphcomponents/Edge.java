package edu.app.graphcomponents;

public class Edge {
    private final int weight;
    private Status status = Status.NOT_VISITED;
    private boolean isPrinted = false;

    public Edge(int weight) {
        this.weight = weight;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean isVisited() {
        return this.status == Status.VISITED;
    }

    public boolean isPrinted() {
        return isPrinted;
    }

    public void setPrinted(boolean printed) {
        isPrinted = printed;
    }
}