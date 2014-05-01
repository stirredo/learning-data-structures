package App;

import Graph.Edge;

import java.util.Comparator;

/**
 * Created by stirredo on 20/4/2014.
 */
public class PriorityQueueComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.weight - o2.weight;
    }
}
