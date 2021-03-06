package Util.Function;

import Util.Collection.List.ArrayListImpl;

public class ArrayDynamicTest {
    public static void main(String[] args) {
        ArrayListImpl<Integer> list = new ArrayListImpl<>(5);
        System.out.println("=============添加元素===================");
        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println("List的元素个数为：" + list.size() + ";List的实际大小为：" + list.length());
        }
        System.out.println(list);
        System.out.println("=============删除元素===================");
        for (int i = 0; i < 11; i++) {
            list.remove(i);
            System.out.println("List的元素个数为：" + list.size() + ";List的实际大小为：" + list.length());
        }
        System.out.println(list);
        System.out.println("=============再添加元素===================");
        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println("List的元素个数为：" + list.size() + ";List的实际大小为：" + list.length());
        }
        System.out.println(list);
    }
}
