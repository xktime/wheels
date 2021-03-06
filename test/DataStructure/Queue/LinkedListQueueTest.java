package DataStructure.Queue;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueueImpl<>();
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
