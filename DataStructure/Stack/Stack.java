package Stack;

public interface Stack<T> {
    void push(T e);//进栈

    T pop();//出栈

    int size();//栈内元素个数

    boolean isEmpty();//是否为空
}
