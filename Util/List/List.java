package List;

public interface List<T> {
    boolean add(T e);//添加元素

    boolean remove(T e);//删除元素

    void clear();//清空List

    T get(int index);//获取参数下标元素

    int indexOf(T e);//获取元素第一次出现位置处的索引

    boolean contains(T e);//是否包含元素

    boolean isEmpty();

    int size();//List大小
}
