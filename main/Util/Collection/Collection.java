package Util.Collection;

public interface Collection<T> {
    boolean add(T element);//添加元素

    void addAll(T...elements);//添加所有元素

    boolean remove(T element);//删除元素

    boolean contains(T element);//是否包含元素

    void clear();//清空容器

    boolean isEmpty();

    int size();//List大小

    T[] toArray();//返回数组
}
