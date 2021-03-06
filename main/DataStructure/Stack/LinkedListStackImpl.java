package DataStructure.Stack;

public class LinkedListStackImpl<T> implements Stack<T> {
    private class Node {
        Node next;
        T element;
    }

    private Node top;//栈顶元素
    private int size = 0;

    @Override
    public void push(T element) {
        Node newTop = new Node();
        newTop.element = element;
        newTop.next = top;
        top = newTop;
        size++;
    }

    @Override
    public T pop() {
        if (size == 0) {
            System.out.println("空栈不能执行pop操作");
            return null;
        }
        size--;
        T element = top.element;
        top = top.next;
        return element;
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
        //按入栈顺序打印
        StringBuilder str = new StringBuilder();
        if (isEmpty()) {
            return str.append('[').append(']').toString();
        }
        Node tempTop = top;
        str.append('[');
        //按出栈顺序将元素放入数组
        T[] tempArr = (T[])new Object[size];
        for (int i = 0; i < size; i++) {
            tempArr[i] = tempTop.element;
        }
        //将数组倒序输出
        for (int i = tempArr.length - 1; i >= 0; i--) {
            if (i != 0) {
                str.append(tempArr[i]).append('、');
            } else {
                //最后一个元素后面不加顿号
                str.append(tempArr[i]);
            }
        }
        str.append(']');
        return str.toString();
    }
}
