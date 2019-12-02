package Util.Map;

import Util.Collection.List.*;
import Util.Collection.Set.Set;

public interface Map<K, V> {
    void put(K key, V value); //放入键值

    V get(K key);//根据key取所对应的value

    Set<Entry<K, V>> entrySet();

    Set<K> keySet();

    List<V> values();

    void remove(K key);//删除指定键的键值

    boolean containsKey(K key);//Map是否包含该键

    boolean containsValue(V value);//Map是否包含该值

    int size();//Map大小

    void clear();

    boolean isEmpty();//Map是否为空

    interface Entry<K, V> {
        K getKey();

        V getValue();

        void setKey(K k);

        void setValue(V v);

    }
}
