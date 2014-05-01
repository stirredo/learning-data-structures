package App;

import Graph.Edge;
import Graph.Vertex;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stirredo on 20/4/2014.
 */
public class Mst {
    public Vertex[] vertexList;
    public PriorityQueue<Edge> pq;
    public int vertexCount;
    public final int INFINITY = 100000;
    public int adjacencyMatrix[][];

    public Mst(int maxVertices) {
        vertexList = new Vertex[maxVertices];
        adjacencyMatrix = new int[maxVertices][maxVertices];
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                adjacencyMatrix[i][j] = INFINITY;
            }
        }
        Comparator<Edge> comparator = new PriorityQueueComparator();
        pq = new PriorityQueue<Edge>(maxVertices, comparator);

        vertexCount = 0;

    }
    public void runMst(int startingIndex) {
        int count = 0;
        int index = startingIndex;
        while (count != vertexCount - 1) {
            vertexList[index].isInTree = true;
            count++;
            for (int i = 0; i < vertexCount; i++) {
                if (i == index) {
                    continue;
                }
                if (vertexList[i].isInTree) {
                    continue;
                }
                if (adjacencyMatrix[index][i] == INFINITY) {
                    continue;
                } else if (adjacencyMatrix[index][i] != INFINITY) {
                    Edge foundEdge = find(i);
                    if (foundEdge != null) {
                        if (adjacencyMatrix[index][i] < foundEdge.weight) {
                            pq.remove(foundEdge);
                            pq.add(new Edge(index, i, adjacencyMatrix[index][i]));
                        }
                    } else {
                        pq.add(new Edge(index, i, adjacencyMatrix[index][i]));
                    }

                }
            }
            /*if(pq.size() != 0) {
                Object[] array = pq.toArray();
                System.out.println("PQ contents: ");
                for (Object obj : array) {
                    Edge edge = (Edge)obj;
                    String str = vertexList[edge.source].label + "" + vertexList[edge.destination].label + edge.weight + " ";
                    System.out.print(str);
                }
                System.out.println();
            }*/
            if (pq.size() != 0) {

                Edge newPathEdge = pq.remove();
                int source = newPathEdge.source;
                int destination = newPathEdge.destination;
                int weight = newPathEdge.weight;
                String string = vertexList[source].label + "" + vertexList[destination].label + weight + " ";
                System.out.println(string);


                index = destination;
            }



        }

    }




    public Edge find(int index) {
        Object[] array = pq.toArray();
        for (Object obj : array) {
            Edge edge = (Edge)obj;
            if (edge.destination == index) {
                return edge;
            }
        }
        return null;
    }

    public void addVertex(char label) {
        vertexList[vertexCount] = new Vertex(label);
        vertexCount++;
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public void addEdge(char source, char destination, int weight) {
        int sourceIndex = getIndexFromLabel(source);
        int destinationIndex = getIndexFromLabel(destination);
        if (sourceIndex > -1 && destinationIndex > -1) {
            addEdge(sourceIndex, destinationIndex, weight);

        }
    }

    public int getIndexFromLabel(char label) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertexList[i].label == label) {
                return i;
            }
        }
        return -1;
    }

    public void printMatrix() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + "   ");

        }
        System.out.println();
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j < vertexCount; j++) {
                if (adjacencyMatrix[i][j] == INFINITY) {
                    System.out.print("INF" +" ");

                } else {
                    System.out.print(adjacencyMatrix[i][j] + " ");

                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Mst mst = new Mst(6);
        mst.addVertex('A');
        mst.addVertex('B');
        mst.addVertex('C');
        mst.addVertex('D');
        mst.addVertex('E');
        mst.addVertex('F');

        mst.addEdge('A', 'B', 6);
        mst.addEdge('A', 'D', 4);
        mst.addEdge('B', 'C', 10);
        mst.addEdge('B', 'D', 7);
        mst.addEdge('B', 'E', 7);
        mst.addEdge('C', 'D', 8);
        mst.addEdge('C', 'E', 5);
        mst.addEdge('C', 'F', 6);
        mst.addEdge('D', 'E', 12);
        mst.addEdge('E', 'F', 7);
        //mst.printMatrix();
        mst.runMst(0);
        //Minimum spanning tree: AD AB BE EC CF
    }
}
