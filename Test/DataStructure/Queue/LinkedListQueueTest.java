package DataStructure.Queue;

import Queue.LinkedListQueueImpl;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueueImpl<Integer> queue = new LinkedListQueueImpl<Integer>();
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
