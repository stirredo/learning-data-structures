package Dijsktra.App;

import Graph.Vertex;


public class dijsktraAlgo {
    final int INFINITY = 10000;
    Vertex[] vertexList;
    int[][] adjacencyMatrix;
    int vertexCount;
    int maxVertex;
    DistanceParent[] path;

    public dijsktraAlgo(int count) {
        maxVertex = count;
        vertexList = new Vertex[count];
        adjacencyMatrix = new int[count][count];
        vertexCount = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                adjacencyMatrix[i][j] = INFINITY;

            }
        }
        path = new DistanceParent[count];
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyMatrix[source][destination] = weight;
        //adjacencyMatrix[destination][source] = weight;
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

    public void addVertex(char label) {
        vertexList[vertexCount] = new Vertex(label);
        vertexCount++;
    }

    public int getMinimumVertexIndex() {
        //gets the vertex with minimum cost from the DistanceParent array
        int minDist = INFINITY;
        int indexMin = 0;
        for (int i = 0; i < vertexCount; i++) {
            if (!vertexList[i].isInTree && path[i].distance < minDist) {
                minDist = path[i].distance;
                indexMin = i;
            }

        }
        return indexMin;

    }

    public void adjustPath(int fromVertex) {
        int previousWeight = path[fromVertex].distance;

        for (int i = 0; i < vertexCount; i++) {
            int distance;
            if (adjacencyMatrix[fromVertex][i] != INFINITY) {
                distance = previousWeight + adjacencyMatrix[fromVertex][i];
            } else {
                continue;
            }

            if (distance < path[i].distance) {
                path[i].distance = distance;
                path[i].parentVertex = fromVertex;
            }
        }
    }

    public void runAlgo(int fromIndex) {
        vertexList[fromIndex].isInTree = true;


        //Get all the distances from the beginning endpoint
        for (int i = 0; i < vertexCount; i++) {
               path[i] = new DistanceParent(adjacencyMatrix[fromIndex][i], fromIndex);
//            path[i].distance = adjacencyMatrix[fromIndex][i];
//            path[i].parentVertex = fromIndex;
        }
        int count = 0;


        //Continue loop until all the vertex are not in the path array
        while (count < vertexCount) {
            int minDistanceVertex = getMinimumVertexIndex();
            if (path[minDistanceVertex].distance == INFINITY) {
                System.out.println("There are unreachable Vertices. ");
                break;
            } else {
                vertexList[minDistanceVertex].isInTree = true;
                adjustPath(minDistanceVertex);
                count++;
            }
        }

        displayPathArray();
        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].isInTree = false;

        }


    }
    public void displayPathArray()
    {
        for(int j=0; j<vertexCount; j++) // display contents of sPath[]
        {
            System.out.print(vertexList[j].label + "="); // B=
            if(path[j].distance == INFINITY)
                System.out.print("inf");                  // inf
            else
                System.out.print(path[j].distance);      // 50
            char parent = vertexList[path[j].parentVertex].label;
            System.out.print("(" + parent + ") ");       // (A)
        }
        System.out.println("");
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
        dijsktraAlgo graph = new dijsktraAlgo(5);
        graph.addVertex('A');     // 0
        graph.addVertex('B');     // 1
        graph.addVertex('C');     // 2
        graph.addVertex('D');     // 3
        graph.addVertex('E');     // 4

        graph.addEdge(0, 1, 50);  // AB 50
        graph.addEdge(0, 3, 80);  // AD 80
        graph.addEdge(1, 2, 60);  // BC 60
        graph.addEdge(1, 3, 90);  // BD 90
        graph.addEdge(2, 4, 40);  // CE 40
        graph.addEdge(3, 2, 20);  // DC 20
        graph.addEdge(3, 4, 70);  // DE 70
        graph.addEdge(4, 1, 50);  // EB 50
        //graph.printMatrix();
        graph.runAlgo(0);

    }

}
