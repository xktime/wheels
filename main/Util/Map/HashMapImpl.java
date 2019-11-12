package Util.Map;

import Util.Funciton.ArrayDynamic;

/**
 * 简易HashMap实现
 */
public class HashMapImpl<K, V> extends ArrayDynamic implements Map<K, V> {

    private class Node<K, V> {
        Node next;
        K key;
        V value;
        int hash;

        Node(Node next, K key, V value, int hash) {
            this.next = next;
            this.key = key;
            this.value = value;
            this.hash = hash;
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
        if (size > length * EXPANSION_PROBABILITY) {
            table = (Node<K, V>[]) resize(table, size, length << 1);
        }
    }

    private void put(Node<K, V>[] arr, K key, V value) {
        int hash = hash(key);
        Node newNode = new Node(null, key, value, key == null ? 0 : key.hashCode());
        if (hash >= arr.length) {
            throw new IndexOutOfBoundsException();
        }
        Node oldNode = arr[hash];
        if (oldNode == null) {
            //如果桶内没有元素,直接放入
            arr[hash] = newNode;
            size++;
        } else {
            //如果桶内有元素,需要判定key是否相同
            while (oldNode != null) {
                //需要判断key为空的情况
                if (oldNode.hash == (key == null ? 0 : key.hashCode())
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
    }


    @Override
    public V get(K key) {
        Node<K, V> oldNode = getNode(hash(key), key);
        return oldNode == null ? null : oldNode.value;
    }

    @Override
    public void remove(K key) {
        int hash = hash(key);
        Node node = table[hash];
        if (node != null) {
            //如果链头就是要删除的元素
            if (node.hash == (key == null ? 0 : key.hashCode())
                    && (key == null ? node.key == null : key.equals(node.key))) {
                table[hash] = node.next;
                size--;
            } else {
                //如果要删除的元素在后面
                while (node.next != null) {
                    if (node.next.hash == (key == null ? 0 : key.hashCode())
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
        return oldNode == null;
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
    private int hash(K key) {
        if (key == null) {
            return 0;
        }
        return key.hashCode() % length;
    }

    private Node<K, V> getNode(int hash, K key) {
        Node<K, V> oldNode = table[hash];
        while (oldNode != null) {
            if (oldNode.hash == (key == null ? 0 : key.hashCode())
                    && (key == null ? oldNode.key == null : key.equals(oldNode.key))) {
                return oldNode;
            }
            oldNode = oldNode.next;
        }
        return null;
    }
}
