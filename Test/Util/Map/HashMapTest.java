package Util.Map;

import Map.*;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMapImpl<String, Integer>();
        map.put("luo", 1);
        map.put("li", 2);
        map.put("wen", 3);
        map.put("luo", 4);
        map.put("oul", 4);
        map.put(null, 4);
        map.put(null, 7);
    }
}
