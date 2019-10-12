package LinkedList;

/**
 * 链表实在不知道用接口还是用抽象类。
 * 接口不能重写内部类，用抽象类又都没有具体实现。
 * 于是想着反正都要重写Node，就暂时先用接口了。后面去看一下Java的API
 */
interface LinkedList<T> {
    void add(T e);//在链尾添加元素

    void insert(T e, int index);//插入元素

    T remove(int index);//根据下标删除元素，返回被删除的节点的值

    T get(int index);//根据下标获取元素

    int find(T e);//元素在链表中首次出现的位置。返回值为0表示没有找到元素

    int size();//返回链表大小

    boolean isEmpty();//是否为空
}
