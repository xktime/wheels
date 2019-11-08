package Util.Map;

import Map.*;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMapImpl<Integer, Integer>();
        System.out.println("=============添加元素===================");
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        System.out.println(map);
        System.out.println("=============覆盖KEY===================");
        for (int i = 0; i < 10; i++) {
            map.put(i, i+1);
        }
        System.out.println(map);
        System.out.println("=============分别插入KEY和VALUE为NULL===================");
        map.put(null, 1);
        map.put(11,null);
        System.out.println(map);
        System.out.println("=============删除元素===================");
        for (int i = 0; i <= 11; i++) {
            map.remove(i);
        }
        map.remove(null);
        System.out.println(map);
    }
}
