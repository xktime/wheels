package DataStructure.Queue;

import Queue.CircularQueueImpl;

public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueueImpl<Integer> queue = new CircularQueueImpl<Integer>(5);
        System.out.println("=============入队===================");
        for (int i = 0; i < 5; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
        System.out.println("=============出队===================");
        for (int i = 0; i < 3; i++) {
            queue.deQueue();
        }
        System.out.println(queue);
        System.out.println("============再入队==================");
        for (int i = 0; i < 3; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);
    }
}
