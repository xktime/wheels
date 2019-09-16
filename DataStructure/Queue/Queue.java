package Queue;

public interface Queue<T> {
    void enQueue(T e);//入队

    T deQueue();//出队,返回出队的元素

    boolean isEmpty();//队列是否为空

    int size();//队列元素个数
}
