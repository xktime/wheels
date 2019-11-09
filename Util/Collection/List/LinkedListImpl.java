package Collection.List;

public class LinkedListImpl<T> implements List<T> {

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

    private Node first;//头节点
    private Node last;//尾节点
    private int size = 0;//链表大小

    @Override
    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        if (first == null) {
            linkFirst(element);
        } else {
            linkLast(element);
        }
        return true;
    }

    @Override
    public void addAll(T... elements) {
        if (elements == null) {
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            add(elements[i]);
        }
    }

    @Override
    public boolean remove(T element) {
        if (isEmpty()) {
            return false;
        }
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.element.equals(element)) {
                if (i == 0) {
                    removeFirst();
                } else if (i == size - 1) {
                    removeLast();
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    size--;
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        for (Node node = first; node != null; ) {
            Node newNode = node.next;
            node.next = null;
            node.prev = null;
            node.element = null;
            node = newNode;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (!isPositionIndex(index)) {
            return null;
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            if (node.next == null) {
                return null;
            }
            node = node.next;
        }
        return node.element;
    }

    @Override
    public int indexOf(T element) {
        int index = 0;
        Node node = first;
        while (node != null) {
            if (node.element.equals(element)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
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
    public T[] toArray() {
        T[] arr = (T[]) new Object[size()];
        Node node = first;
        for (int i = 0; i < size(); i++) {
            arr[i] = node.element;
            node = node.next;
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (size == 0) {
            return str.append('[').append(']').toString();
        }
        str.append('[');
        Node temp = first;
        while (temp.next != null) {
            str.append(temp.element).append('、');
            temp = temp.next;
        }
        //最后一个元素不加顿号
        str.append(temp.element);
        str.append(']');
        return str.toString();
    }

    /**
     * 往头节点增加元素
     */
    private void linkFirst(T e) {
        Node oldFirst = first;
        Node newFirst = new Node(null, oldFirst, e);
        first = newFirst;
        if (oldFirst == null) {
            last = newFirst;
        } else {
            oldFirst.prev = newFirst;
        }
        size++;
    }

    /**
     * 往尾节点增加元素
     */
    private void linkLast(T e) {
        Node oldLast = last;
        Node newLast = new Node(oldLast, null, e);
        last = newLast;
        if (oldLast == null) {
            first = newLast;
        } else {
            oldLast.next = newLast;
        }
        size++;
    }

    /**
     * 删除头节点
     */
    private void removeFirst() {
        if (size == 0) {
            return;
        }
        if (size() == 1) {
            first.element = null;
            first = last = null;
        } else {
            first = first.next;
            first.prev.element = null;
            first.prev.next = null;
            first.prev = null;
        }
        size--;
    }

    /**
     * 删除尾节点
     */
    private void removeLast() {
        if (size == 0) {
            return;
        }
        if (size() == 1) {
            last.element = null;
            first = last = null;
        } else {
            last = last.prev;
            last.next.element = null;
            last.next.prev = null;
            last.next = null;
        }
        size--;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size();
    }
}
