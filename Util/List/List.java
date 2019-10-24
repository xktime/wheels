package List;

public interface List<T> {
    boolean add(T e);//添加元素

    void addAll(T...e);//添加所有元素

    boolean remove(T e);//删除元素

    void clear();//清空List

    T get(int index);//获取参数下标元素

    int indexOf(T e);////元素在List中首次出现的下标。返回值为-1表示没有找到元素

    boolean contains(T e);//是否包含元素

    boolean isEmpty();

    int size();//List大小
}
