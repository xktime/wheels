package List;

import Funciton.ArrayDynamic;

public class ArrayListImpl<T> extends ArrayDynamic implements List<T> {
    private T[] array;
    private static final Object[]  empty_array = {}; //用于空实例
    private int rear = 0;//队尾指针
    private final int DEFAULT_CAPACITY = 10;//List默认大小

    public ArrayListImpl() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayListImpl(int size) {
        if (size > 0) {
            array = (T[]) new Object[size];
        } else if (size == 0) {
            array = (T[])empty_array;
        } else {
            System.out.println("初始容量错误");
        }
    }

    @Override
    public boolean add(T e) {
        if (e == null) {
            return false;
        }
        if (size() > (array.length - 1)) {
            System.out.println("数组已满，EXPANSION_PROBABILITY不能大于100");
            return false;
        }
        array[rear++] = e;
        array = (T[]) expationCapacity(array, size());
        return true;
    }

    @Override
    public boolean remove(T e) {
        //List没有这个元素或者List为空，返回false
        if (e == null || isEmpty() || !contains(e)) {
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
                array = (T[]) trimCapacity(array, size());
                return true;
            }
        }
        return false;
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
        if (e == null || isEmpty()) {
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
        return indexOf(e) >= 0;
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

    /**
     * List数组的大小，测试用
     * @return
     */
    public int length() {
        return array.length;
    }
}
