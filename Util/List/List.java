package List;

public interface List<T> {
    boolean add(T element);//添加元素

    void addAll(T...elements);//添加所有元素

    boolean remove(T element);//删除元素

    void clear();//清空List

    T get(int index);//获取参数下标元素

    int indexOf(T element);////元素在List中首次出现的下标。返回值为-1表示没有找到元素

    boolean contains(T element);//是否包含元素

    boolean isEmpty();

    int size();//List大小

    T[] toArray();//返回数组
}
