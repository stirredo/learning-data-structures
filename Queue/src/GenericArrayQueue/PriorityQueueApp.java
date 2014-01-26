package GenericArrayQueue;

/**
 * Created by stirredo on 1/25/14.
 */
public class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.insert(10);
        priorityQueue.insert(30);
        priorityQueue.insert(20);
        priorityQueue.insert(40);
        priorityQueue.insert(50);
        priorityQueue.delete();
        priorityQueue.insert(60);
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.delete());
        }


    }

}
