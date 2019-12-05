package DataStructure.Stack;

import Util.Funciton.ArrayDynamic;

public class ArrayStackImpl<T> extends ArrayDynamic<T> implements Stack<T> {
    private T[] array;
    private static final Object[] empty_array = {}; //用于空实例
    private int topPoint = 0;//栈顶指针
    private final int DEFAULT_CAPACITY = 10;//默认大小

    public ArrayStackImpl() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }


    public ArrayStackImpl(int size) {
        if (size > 0) {
            array = (T[]) new Object[size];
        } else if (size == 0) {
            array = (T[]) empty_array;
        } else {
            throw new IllegalArgumentException("初始容量错误");
        }
    }

    @Override
    public void push(T element) {
        array[topPoint++] = element;
        //扩大容量
        array = expandCapacity(array, size());
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("空栈不能执行pop操作");
            return null;
        }
        T element = array[--topPoint];
        //缩小容量
        array = trimCapacity(array, size());
        return element;
    }

    /**
     * @return 栈内当前元素的个数
     */
    @Override
    public int size() {
        return topPoint;
    }

    @Override
    public String toString() {
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            str1.append(array[i]).append('、');
        }
        int index = str1.lastIndexOf("、");
        //如果有顿号，则删除最后一个顿号
        if (index != -1) {
            str1.delete(index, index + 1);
        }
        str1.insert(0, '[').append(']');
        return str1.toString();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

}
