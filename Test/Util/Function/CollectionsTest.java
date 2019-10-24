package Util.Function;

import Funciton.Collections;
import List.ArrayListImpl;
import List.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<Character> list = new ArrayListImpl<Character>();
        list.addAll('b', 'a', 'f', 'd', 'c', 'e');
        System.out.println("=============排序前===================");
        System.out.println(list);
        Collections.sort(list);
        System.out.println("=============排序后===================");
        System.out.println(list);
    }
}
