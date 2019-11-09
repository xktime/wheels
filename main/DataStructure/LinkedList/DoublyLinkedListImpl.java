package DataStructure.LinkedList;

public class DoublyLinkedListImpl<T> implements LinkedList<T> {
    private class Node {
        Node prev;
        Node next;
        T element;

        Node(Node prev, Node next, T element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }

    private Node head = new Node(null, null, null);//头结点
    private int size = 0;

    @Override
    public void add(T e) {
        Node node = head;
        //找到最后一个节点
        while (node.next != null) {
            node = node.next;
        }
        Node newNode = new Node(node, null, e);
        node.next = newNode;
        size++;
    }

    @Override
    public void insert(T e, int index) {
        if (index > size) {
            //如果index大于链表大小直接在链表末尾添加元素
            add(e);
            return;
        }
        Node oldNode = head;
        for (int i = 0; i < index; i++) {
            if (oldNode.next == null) {
                //异常返回
                return;
            }
            oldNode = oldNode.next;
        }
        Node priorNode = oldNode.prev;
        Node newNode = new Node(priorNode, oldNode, e);
        priorNode.next = newNode;
        oldNode.prev = newNode;
        size++;
    }

    @Override
    public T remove(int index) {
        if (isEmpty()) {
            System.out.println("空表不能删除元素");
            return null;
        }
        if (index > size) {
            //如果index大于size删除最后一个元素
//            return delete(size);
            index = size;
        }
        Node oldNode = head;
        for (int i = 0; i < index; i++) {
            if (oldNode.next == null) {
                //异常返回
                return null;
            }
            oldNode = oldNode.next;
        }
        oldNode.prev.next = oldNode.next;
        if (size != index) {
            //最后一个元素没有next
            oldNode.next.prev = oldNode.prev;
        }
        size--;
        return oldNode.element;
    }

    @Override
    public T get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.element;
    }

    @Override
    public int find(T e) {
        Node node = head;
        int index = 0;
        while (node.next != null) {
            node = node.next;
            index++;
            if (node.element.equals(e)) {
                return index;
            }
        }
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (size == 0) {
            return str.append('[').append(']').toString();
        }
        str.append('[');
        Node temp = head.next;
        while (temp.next != null) {
            str.append(temp.element).append('、');
            temp = temp.next;
        }
        //最后一个元素不加顿号
        str.append(temp.element);
        str.append(']');
        return str.toString();
    }

}
