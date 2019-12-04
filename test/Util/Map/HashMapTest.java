package Util.Map;

import Util.Collection.Set.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMapImpl<>();
        System.out.println("=============添加元素===================");
        //测试添加和正常扩容
        for (int i = 0; i < 20; i++) {
            map.put(i, i);
        }
        System.out.println(map);
        System.out.println("Map的元素个数为：" + map.size());
        System.out.println("=============覆盖KEY===================");
        //测试是否正常覆盖value
        for (int i = 0; i < 10; i++) {
            map.put(i, i + 1);
        }
        System.out.println(map);
        System.out.println("Map的元素个数为：" + map.size());
        System.out.println("=============分别插入KEY和VALUE为NULL===================");
        map.put(null, 1);
        map.put(11, null);
        System.out.println(map);
        System.out.println("key为null的value为" + map.get(null));
        System.out.println("Map的元素个数为：" + map.size());
        System.out.println("=============删除元素===================");
        for (int i = 0; i <= 11; i++) {
            map.remove(i);
        }
        map.remove(null);
        System.out.println(map);
        System.out.println("Map的元素个数为：" + map.size());
        System.out.println("====================================");
        System.out.println("Map是否包含Key为" + "12:" + map.containsKey(12));
        System.out.println("Map是否包含Key为" + "null:" + map.containsKey(null));
        System.out.println("Map是否包含Value为" + "12:" + map.containsValue(12));
        System.out.println("Map是否包含Value为" + "null:" + map.containsValue(null));
        System.out.println("=============迭代器测试===================");
        Set<Map.Entry<Integer, Integer>> set = ((HashMapImpl<Integer, Integer>) map).entrySet();
        System.out.println(map);
        for (Map.Entry<Integer, Integer> e : set) {
            System.out.println(e);
        }
    }
}
