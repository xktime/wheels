package Queue;

public class CircularQueueImpl<T> implements Queue<T> {
    private T[] array;
    private int front = 0;//队头指针
    private int rear = -1;//队尾指针

    public CircularQueueImpl(int size) {
        if (size > 0) {
            array = (T[]) new Object[size];
        } else {
            System.out.println("初始容量错误");
        }
    }

    @Override
    public void enQueue(T e) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        int index = getRear();
        array[index] = e;
    }

    @Override
    public T deQueue() {
        if (isEmpty()) {
            System.out.println("空队列,无法执行出队操作");
            return null;
        }
        int index = getFront();
        T element = array[index];
        front++;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return (rear - front) % array.length + 1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('[');
        if (getRear() >= getFront()) {
            for (int i = getFront(); i <= getRear(); i++) {
                if (i != getRear()) {
                    str.append(array[i]).append('、');
                } else {
                    str.append(array[getRear()]);
                }
            }
        } else {
            //尾指针走到头指针前面后的处理
            for (int i = getFront(); i <= (getRear() + array.length); i++) {
                int index = i % array.length;
                if (i != (getRear() + array.length)) {
                    str.append(array[index]).append('、');
                } else {
                    str.append(array[index]);
                }
            }
        }
        str.append(']');
        return str.toString();
    }

    private int getFront() {
        return front % array.length;
    }

    private int getRear() {
        return rear % array.length;
    }

    private boolean isFull() {
        return (rear - front) % array.length + 1 == array.length;
    }
}
