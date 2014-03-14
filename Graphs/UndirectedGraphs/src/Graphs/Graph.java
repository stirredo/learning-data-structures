package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by stirredo on 3/12/14.
 */
public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjacencyMatrix[][];
    private int vertexCount;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjacencyMatrix = new int[MAX_VERTS][MAX_VERTS];
        vertexCount = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }
    public void addVertex(char label) {
        vertexList[vertexCount] = new Vertex(label);
        vertexCount++;
    }
    public void addEdge(int start, int end) {
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }
    public void addEdge(char vertexA,char vertexB) {
        int start = getVertexLabelIndex(vertexA);
        int end = getVertexLabelIndex(vertexB);
        if (start != -1 && end != -1) {
            addEdge(start,end);
        }
    }
    public int getVertexLabelIndex(char label) {
        for (int i = 0; i < vertexCount; i++) {
            if(vertexList[i].getVertexLabel() == label) {
                return i;
            }
            
        }
        return -1;
    }
    public void displayVertex(int vertexIndex) {
        System.out.print(vertexList[vertexIndex].getVertexLabel());
    }
    public int getAdjacentUnvisitedVertexIndex(int vertexIndex) {
        for (int i = 0; i < MAX_VERTS; i++) {
            if(adjacencyMatrix[vertexIndex][i] == 1 && vertexList[i].wasVisited == false) {
                return i;
            }

        }
        return -1;
    }
    public void depthFirstSearch(int vertexIndex) {
        /*
        *  Rules:
        *  1. If possible, visit adjacent unvisited vertex, mark it, and push it on to the stack.
        *  2. If you can't follow Rule 1, if possible, pop a vertex off a stack.
        *  3. If you can't follow Rule 1 or Rule 2, you're done.
        * */
        Stack<Integer> stack = new Stack<Integer>();
        vertexList[vertexIndex].wasVisited = true;
        displayVertex(vertexIndex);
        stack.push(vertexIndex);
        while (!stack.isEmpty()) {
            int unvistedVertexIndex = getAdjacentUnvisitedVertexIndex(stack.peek());
            if(unvistedVertexIndex == -1) {
                stack.pop();
            } else {
                vertexList[unvistedVertexIndex].wasVisited = true;
                displayVertex(unvistedVertexIndex);
                stack.push(unvistedVertexIndex);
            }
        }
        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].wasVisited = false;

        }
    }
    public void breadthFirstSearch(int vertexIndex) {
        /*
        * Rules:
        * 1. Visit the next unvisited vertex (if there is one) that's adjacent to the current vertex, mark it, and
        *    and insert it into the queue.
        * 2. If you can't carry out Rule 1 because there are no more unvisited vertices, remove a vertex from the queue (if possible)
        *    and make it the current vertex.
        * 3. If you can't carry out Rule 2 because the queue is empty, you're done.
        *
        * */
        Queue<Integer> queue = new LinkedList<Integer>();
        vertexList[vertexIndex].wasVisited = true;
        displayVertex(vertexIndex);
        int unvisitedIndex;
        do {

            do  {
                unvisitedIndex = getAdjacentUnvisitedVertexIndex(vertexIndex);
                if(unvisitedIndex != -1) {
                    vertexList[unvisitedIndex].wasVisited = true;
                    displayVertex(unvisitedIndex);
                    queue.add(unvisitedIndex);

                }
            } while(unvisitedIndex != -1);
            if(!queue.isEmpty()) {
                vertexIndex = queue.remove();

            }

        } while(!queue.isEmpty());

        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].wasVisited = false;

        }
    }
    public void minimumSpanningTree(int vertexIndex) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(vertexIndex);
        do {
            vertexIndex = stack.peek();
            int unvisitedVertexIndex = getAdjacentUnvisitedVertexIndex(stack.peek());
            if(unvisitedVertexIndex == -1) {
                vertexIndex = stack.pop();
            } else {
                vertexList[vertexIndex].wasVisited = true;
                displayVertex(vertexIndex);
                displayVertex(unvisitedVertexIndex);
                vertexList[unvisitedVertexIndex].wasVisited = true;
                System.out.print(" ");
                stack.push(unvisitedVertexIndex);
            }

        } while (!stack.isEmpty());
        for (int i = 0; i < vertexCount; i++) {
            vertexList[i].wasVisited = false;

        }

    }


    public static void main(String[] args) {
        Graph graph = new Graph();
        //http://i.imgur.com/uZh7i62.png
        /*graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addVertex('J');
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('C', 'D');
        graph.addEdge('C', 'J');
        graph.addEdge('A', 'E');
        graph.addEdge('A', 'E');
        graph.addEdge('A', 'F');
        graph.addEdge('F', 'H');
        graph.addEdge('H', 'I');
        graph.addEdge('A', 'G');*/

        //http://i.imgur.com/eIzBa6s.png
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addEdge(0, 1); // AB
        graph.addEdge(0, 2); // AC
        graph.addEdge(0, 3); // AD
        graph.addEdge(0, 4); // AE
        graph.addEdge(1, 2); // BC
        graph.addEdge(1, 3); // BD
        graph.addEdge(1, 4); // BE
        graph.addEdge(2, 3); // CD
        graph.addEdge(2, 4); // CE
        graph.addEdge(3, 4); // DE



        System.out.print("DFS Visited: ");
        graph.depthFirstSearch(graph.getVertexLabelIndex('A'));
        System.out.println("");



        /*//http://i.imgur.com/dks25yj.png
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addVertex('I');
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('A', 'E');
        graph.addEdge('B', 'F');
        graph.addEdge('F', 'H');
        graph.addEdge('D', 'G');
        graph.addEdge('G', 'I');*/
        System.out.print("BFS Visited: ");
        graph.breadthFirstSearch(graph.getVertexLabelIndex('A'));
        System.out.println();

        System.out.print("MST: ");
        graph.minimumSpanningTree(graph.getVertexLabelIndex('A'));
        System.out.println("");
    }
}
