package Util.Map;

import Util.Collection.Set.Set;
import Util.Funciton.ArrayDynamic;

import java.util.Iterator;

/**
 * 简易HashMap实现
 */
public class HashMapImpl<K, V> extends ArrayDynamic implements Map<K, V> {

    private class Node<K, V> implements Entry<K, V> {
        private Node next;
        private K key;
        private V value;
        private int hash;

        Node(Node next, K key, V value, int hash) {
            this.next = next;
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int DEFAULT_SIZE = 16;//默认大小
    private static final float EXPANSION_PROBABILITY = 0.75f;//负载因子
    private int length = 16;
    private Node<K, V>[] table;//桶表
    private int size = 0;

    public HashMapImpl() {
        table = new Node[DEFAULT_SIZE];
    }

    @Override
    public void put(K key, V value) {
        put(table, key, value);
    }

    private void put(Node<K, V>[] arr, K key, V value) {
        int hash = hash(key);
        Node newNode = new Node(null, key, value, key == null ? 0 : hash);
        int index = hash & (length - 1);
        Node oldNode = arr[index];
        if (oldNode == null) {
            //如果桶内没有元素,直接放入
            arr[index] = newNode;
            size++;
        } else {
            //如果桶内有元素,需要判定key是否相同
            while (oldNode != null) {
                //需要判断key为空的情况
                if (oldNode.hash == (key == null ? 0 : hash)
                        && (key == null ? oldNode.key == null : key.equals(oldNode.key))) {
                    //Map中有Key的情况
                    oldNode.value = value;
                    break;
                }
                if (oldNode.next != null) {
                    oldNode = oldNode.next;
                } else {
                    //如果没有相同的key在链表末尾放入
                    oldNode.next = newNode;
                    size++;
                    break;
                }
            }
        }
        if (size > length * EXPANSION_PROBABILITY) {
            table = (Node<K, V>[]) resize(table, size, length << 1);
        }
    }


    @Override
    public V get(K key) {
        Node<K, V> oldNode = getNode(hash(key), key);
        return oldNode == null ? null : oldNode.value;
    }

    @Override
    public void remove(K key) {
        int hash = hash(key);
        int index = hash & (length - 1);
        Node node = table[index];
        if (node != null) {
            //如果链头就是要删除的元素
            if (node.hash == (key == null ? 0 : hash)
                    && (key == null ? node.key == null : key.equals(node.key))) {
                table[index] = node.next;
                size--;
            } else {
                //如果要删除的元素在后面
                while (node.next != null) {
                    if (node.next.hash == (key == null ? 0 : hash)
                            && (key == null ? node.next.key == null : key.equals(node.next.key))) {
                        node.next = node.next.next;
                        size--;
                        break;
                    }
                    node = node.next;
                }
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        Node<K, V> oldNode = getNode(hash(key), key);
        return oldNode != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < table.length; i++) {
            for (Node node = table[i]; node != null; node = node.next) {
                if (value == null ? node.value == null : value.equals(node.value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str1 = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            for (Node node = table[i]; node != null; node = node.next) {
                str1.append(node.key).append('=').append(node.value).append("、");
            }
        }
        int index = str1.lastIndexOf("、");
        //如果有顿号，则删除最后一个顿号
        if (index != -1) {
            str1.delete(index, index + 1);
        }
        str1.insert(0, '[').append(']');
        return str1.toString();
    }

    @Override
    protected Object[] resize(Object[] array, int size, double resizedSize) {
        length = (int) resizedSize;
        this.size = 0;//先给size置0
        Node[] tempArr = new Node[length];
        for (int i = 0; i < table.length; i++) {
            for (Node node = table[i]; node != null; node = node.next) {
                put(tempArr, (K) node.key, (V) node.value);
            }
        }
        return tempArr;
    }

    /**
     * 获取key的散列值
     */
    private int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        //混合高位和低位，确保计算散列时高位和低位都起到作用
        return h ^ (h >> 16);
    }

    private Node<K, V> getNode(int hash, Object key) {
        Node<K, V> oldNode = table[hash & (length - 1)];
        while (oldNode != null) {
            if (oldNode.hash == (key == null ? 0 : hash)
                    && (key == null ? oldNode.key == null : key.equals(oldNode.key))) {
                return oldNode;
            }
            oldNode = oldNode.next;
        }
        return null;
    }

    public Set<Entry<K, V>> entrySet(){
        return new EntrySet();
    }

    private class EntrySet implements Set {

        @Override
        public boolean add(Object element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addAll(Object[] elements) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object element) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            HashMapImpl.this.clear();
        }

        @Override
        public boolean contains(Object element) {
            if (!(element instanceof Entry)) {
                return false;
            }
            Entry e = (Entry)element;
            Node n = getNode(hash(e.getKey()), e.getKey());
            if (n != null) {
                return e.getValue() == null ? n.getValue() == null : e.getValue().equals(n.getValue());
            }
            return false;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public Iterator iterator() {
            return null;
        }
    }
    private class HashItr{

    }
}
