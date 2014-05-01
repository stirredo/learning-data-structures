package Graph;

/**
 * Created by stirredo on 1/5/2014.
 */
public class Edge {
    public int source;
    public int destination;
    public int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}
