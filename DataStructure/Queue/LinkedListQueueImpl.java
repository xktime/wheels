package Queue;

public class LinkedListQueueImpl<T> implements Queue<T> {
    private class Node {
        Node next;
        T element;
    }

    private Node front = new Node();//队头指针
    private Node rear = front;//队尾指针，指向队尾的后一个元素
    private int size;//队内元素个数

    @Override
    public void enQueue(T e) {
        rear.element = e;
        Node newRear = new Node();
        rear.next = newRear;
        rear = newRear;
        size++;
    }

    @Override
    public T deQueue() {
        Node newFront = front.next;
        if (isEmpty() || newFront == null) {
            System.out.println("空队列,无法执行出队操作");
            return null;
        }
        T element = front.element;
        front = newFront;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            return str.append('[').append(']').toString();
        }
        Node temp = front;
        str.append('[');
        while (temp.next != rear) {
            str.append(temp.element).append('、');
            temp = temp.next;
        }
        //最后一个元素不加顿号
        str.append(temp.element);
        str.append(']');
        return str.toString();
    }
}
