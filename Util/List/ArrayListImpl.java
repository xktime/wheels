package List;

import Funciton.ArrayDynamicEx;

public class ArrayListImpl<T> extends ArrayDynamicEx implements List<T> {
    private T[] array;
    private int rear = 0;//队尾指针
    //容量达到最大容量的百分比之后，进行扩容或缩小
    private int EXPANSION_PROBABILITY = 80;//不能大于100，大于100会导致数组无法扩容
    private int REDUCTION_PROBABILITY = 50;//不能大于REDUCTION_SIZE，否则会导致当前的栈内元素个数多于缩小后的数组大小，引起越界异常
    //扩大或缩小成当前最大容量的百分比
    private int EXPANSION_SIZE = 150;
    private int REDUCTION_SIZE = 70;
    private double MAX_PROBABILITY = 100;//类型为double是为了计算的时候不需要再转换类型

    public ArrayListImpl(int size) {
        array = (T[]) new Object[size];
    }

    @Override
    public boolean add(T e) {
        if (size() > (array.length - 1)) {
            System.out.println("数组已满，EXPANSION_PROBABILITY不能大于100");
            return false;
        }
        array[rear++] = e;
        //数组需要扩容的阈值
        double expansion = size() * (EXPANSION_PROBABILITY / MAX_PROBABILITY);
        if (size() >= expansion) {
            double size = size() * (EXPANSION_SIZE / MAX_PROBABILITY);
            array = (T[]) resize(array, size(), size);
        }
        return true;
    }

    @Override
    public boolean remove(T e) {
        //List没有这个元素或者List为空，返回false
        if (isEmpty() || !contains(e)) {
            return false;
        }
        for (int j = 0; j < size(); j++) {
            if (array[j].equals(e)) {
                //如果删除的值是最后一个元素，直接修改队尾指针就可以了
                //如果删除的值在中间，需要将后面的值向前移
                if (j != (size() - 1)) {
                    for (int k = j; k < (size() - 1); k++) {
                        array[k] = array[k + 1];
                    }
                }
                rear--;
                //数组需要缩小的阈值
                double reduction = array.length * (REDUCTION_PROBABILITY / MAX_PROBABILITY);
                if (size() < reduction) {
                    double size = array.length * (REDUCTION_SIZE / MAX_PROBABILITY);
                    if (size() > size) {
                        System.out.println("调整数组大小失败，REDUCTION_SIZE不能小于REDUCTION_PROBABILITY");
                        return false;
                    }
                    array = (T[]) resize(array, size(), size);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void sort() {

    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            array[i] = null;
        }
        rear = 0;
    }

    @Override
    public T get(int index) {
        if (index > size()) {
            return null;
        }
        return array[index];
    }

    @Override
    public int indexOf(T e) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T e) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return rear == 0;
    }

    @Override
    public int size() {
        return rear;
    }

    @Override
    public String toString() {
        StringBuilder str1 = new StringBuilder();
        str1.append('[');
        for (int i = 0; i < size(); i++) {
            if (i != (size() - 1)) {
                str1.append(array[i]).append('、');
            } else {
                str1.append(array[i]);
            }
        }
        str1.append(']');
        return str1.toString();
    }
}
