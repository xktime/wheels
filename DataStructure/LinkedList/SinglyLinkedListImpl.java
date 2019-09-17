package LinkedList;

public class SinglyLinkedListImpl<T> implements LinkedList<T> {
    class Node {
        Node next;
        T element;
    }

    private Node head = new Node();//头节点
    private int size = 0;

    @Override
    public void add(T e) {
        Node node = head;
        //找到最后一个节点
        while (node.next != null) {
            node = node.next;
        }
        //创建新的节点
        Node newNode = new Node();
        newNode.element = e;
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
        Node beforeNode = new Node();
        for (int i = 0; i < index; i++) {
            if (oldNode.next == null) {
                //异常返回
                return;
            }
            if (i == index - 1) {
                //插入节点的前一个节点
                beforeNode = oldNode;
            }
            //被插入节点
            oldNode = oldNode.next;
        }
        Node newNode = new Node();
        newNode.element = e;
        //将新节点插到被插入节点前
        newNode.next = oldNode;
        //将前一个节点指向新节点
        beforeNode.next = newNode;
        size++;
    }

    @Override
    public T delete(int index) {
        if (isEmpty()) {
            System.out.println("空表不能删除元素");
            return null;
        }
        if (index > size) {
            //如果index大于size删除最后一个元素
            return delete(size);
        }
        Node oldNode = head;//被删除的节点
        Node beforeNode = new Node();
        for (int i = 0; i < index; i++) {
            if (oldNode.next == null) {
                //异常返回
                return null;
            }
            if (i == index - 1) {
                //被删除节点的前一个节点
                beforeNode = oldNode;
            }
            oldNode = oldNode.next;
        }
        beforeNode.next = oldNode.next;
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
