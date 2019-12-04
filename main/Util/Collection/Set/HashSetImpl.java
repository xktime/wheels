package Util.Collection.Set;

import Util.Map.HashMapImpl;

import java.util.Iterator;

public class HashSetImpl<T> implements Set<T> {

    private HashMapImpl<T, Object> map;

    private Object PRESENT = new Object();

    public HashSetImpl() {
        map = new HashMapImpl<>();
    }

    @Override
    public boolean add(T element) {
        return map.put(element, PRESENT) == null;
    }

    @Override
    public void addAll(T... elements) {
        for (T t : elements) {
            map.put(t, PRESENT);
        }
    }

    @Override
    public boolean remove(T element) {
        return map.remove(element) == null;
    }

    @Override
    public boolean contains(T element) {
        return map.containsKey(element);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public T[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public String toString() {
        return map.keySet().toString();
    }
}
