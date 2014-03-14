package Graphs;

/**
 * Created by stirredo on 3/12/14.
 */
public class Vertex {
    private char label;
    public boolean wasVisited;
    public Vertex(char label) {
        this.label = label;
        wasVisited = false;

    }
    public char getVertexLabel() {
        return this.label;
    }
}
