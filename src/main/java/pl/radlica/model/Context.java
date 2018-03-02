package pl.radlica.model;

public class Context {

    private int contextSize;
    private int distance[][];
    private int flow[][];

    public Context(int ctxSize, int[][] distance, int[][] flow){
        this.contextSize=ctxSize;
        this.distance=distance;
        this.flow=flow;
    }

    private int getContextSize(){
        return this.contextSize;
    }

    public int[][] getDistance() {
        return distance;
    }

    public int[][] getFlow() {
        return flow;
    }
}
