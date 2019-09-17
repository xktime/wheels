package LinkedList;

public class DoublyLinkedListImpl<T> implements LinkedList<T> {
    class Node {
        Node prior;
        Node next;
        T element;
    }

    Node head = new Node();//头结点
    int size = 0;

    @Override
    public void add(T e) {

    }

    @Override
    public void insert(T e, int index) {

    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int find(T e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
