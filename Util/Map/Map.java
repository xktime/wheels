package Map;

public interface Map<K, V> {
    void put(K key, V value); //放入键值

    V get(K key);//根据key取所对应的value

    void remove(K key);//删除指定键的键值

    boolean containsKey(K key);//Map是否包含该键

    boolean containsValue(V value);//Map是否包含该值

    int size();//Map大小

    boolean isEmpty();//Map是否为空
}
