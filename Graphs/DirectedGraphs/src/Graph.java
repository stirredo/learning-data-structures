import BookExample.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by stirredo on 19/3/2014.
 * Topological sorting works only on non cyclic graphs. If the graphs is non-directed then it means has cycles.
 */
public class Graph {
    public int[][] adjacencyMatrix;
    public int maxVertices;
    public Vertex[] vertexList;
    public int vertexCount;

    public Graph(int maxVertices) {
        this.maxVertices = maxVertices;
        adjacencyMatrix = new int[maxVertices][maxVertices];
        vertexList = new Vertex[maxVertices];
        vertexCount = 0;
    }

    public void addVertex(char label) {
        vertexList[vertexCount] = new Vertex(label);
        vertexCount++;

    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
    }

    public void addEdge(char vertexFrom, char vertexTo) {
        int start = getVertexIndexFromLabel(vertexFrom);
        int end = getVertexIndexFromLabel(vertexTo);
        addEdge(start, end);
    }

    public int getVertexIndexFromLabel(char label) {
        for (int i = 0; i < vertexCount; i++) {
            if(vertexList[i].label == label) {
                return i;
            }
        }
        return -1;
    }


    public void moveRowUp(int row, int length) {
        //deletes a row from adjacency matrix to delete a vertex.
        for (int column = 0; column < length; column++) {
            adjacencyMatrix[row][column] = adjacencyMatrix[row + 1][column];
        }
    }

    public void moveColumnLeft(int column, int length) {
        //deletes a column from the adjacency matrix to delete a vertex
        for (int row = 0; row < length; row++) {
            adjacencyMatrix[row][column] = adjacencyMatrix[row][column + 1];
        }
    }

    public void deleteVertex(int vertexIndex) {
        System.out.println("Deleting vertex: "+ vertexList[vertexIndex].label);
        if(vertexIndex != vertexCount - 1) {
            for (int i = vertexIndex; i < vertexCount - 1; i++) {
                vertexList[i] = vertexList[i + 1];
            }
            for (int i = vertexIndex; i < vertexCount - 1; i++) {
                moveRowUp(i, vertexCount);

            }
            for (int i = vertexIndex; i < vertexCount - 1; i++) {
                moveColumnLeft(i, vertexCount);

            }
        }
        vertexCount--;
        displayMatrix();
    }
    public void topologicalSorting() {
        Stack<Character> stack = new Stack<Character>();
        do {
            int vertexIndex = getVertexWithNoSuccessor();
            if (vertexIndex == -1) {
                System.out.println("Error: Graph cannot contain cycles");
            } else {
                stack.push(vertexList[vertexIndex].label);
                deleteVertex(vertexIndex);
            }

        } while (vertexCount > 0);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }

    public int getVertexWithNoSuccessor() {

        for (int i = 0; i < vertexCount; i++) {
            boolean hasSuccessor = false;
            for (int j = 0; j < vertexCount; j++) {
                if(adjacencyMatrix[i][j] > 0) {
                    hasSuccessor = true;
                    break;
                }
            }
            if(!hasSuccessor) {
                return i;
            }

        }
        return -1;


    }

    public void displayMatrix() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(20);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');

        graph.addEdge('A', 'D');
        graph.addEdge('A', 'E');
        graph.addEdge('D', 'G');
        graph.addEdge('E', 'G');
        graph.addEdge('B', 'E');
        graph.addEdge('G', 'H');
        graph.addEdge('C', 'F');
        graph.addEdge('F', 'H');

        System.out.println("Topological sorting: ");
        graph.topologicalSorting();




    }


}
