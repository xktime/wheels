package Util.Map;

import Util.Collection.Set.Set;
import Util.Collection.List.List;

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
        for (int i = 0; i <= 16; i++) {
            map.remove(i);
        }
        map.remove(null);
        System.out.println(map);
        System.out.println("Map的元素个数为：" + map.size());
        System.out.println("====================================");
        System.out.println("Map是否包含Key为" + "18:" + map.containsKey(18));
        System.out.println("Map是否包含Key为" + "null:" + map.containsKey(null));
        System.out.println("Map是否包含Value为" + "18:" + map.containsValue(18));
        System.out.println("Map是否包含Value为" + "null:" + map.containsValue(null));
        System.out.println("=============迭代器测试===================");
        System.out.println("-------------entrySet-------------------");
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        System.out.println(map);
        for (Map.Entry<Integer, Integer> e : entrySet) {
            System.out.println(e);
        }
        System.out.println("-------------keySet-------------------");
        Set<Integer> keySet = map.keySet();
        for (int k : keySet) {
            System.out.println(k);
        }
        System.out.println("-------------values-------------------");
        List<Integer> values = map.values();
        for (int v : values) {
            System.out.println(v);
        }
        System.out.println("-------------values的方法-------------------");
        System.out.println("元素:"+ null +" 在values的下标：" + values.indexOf(null) + "处");
        System.out.println("元素:"+ 18 +" 在values的下标：" + values.indexOf(18) + "处");
        System.out.println("values的下标：" + 0 + "处是元素：" + values.get(0));
    }
}
