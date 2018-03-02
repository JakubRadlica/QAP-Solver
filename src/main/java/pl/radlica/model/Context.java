package pl.radlica.model;


import lombok.Getter;

public class Context {

    @Getter private final int contextSize;
    @Getter private final int distance[][];
    @Getter private final int flow[][];

    public Context(final int ctxSize, final int[][] distance, final int[][] flow){
        this.contextSize=ctxSize;
        this.distance=distance;
        this.flow=flow;
    }
}
