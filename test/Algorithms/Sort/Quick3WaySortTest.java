package Algorithms.Sort;

import Algorithms.Enums.SortType;
import Util.Collection.List.ArrayListImpl;
import Util.Collection.List.List;
import Util.Funciton.Collections;

public class Quick3WaySortTest {
    public static void main(String[] args) {
        List<String> list = new ArrayListImpl<>();
        list.addAll("c","b","e","a","e","d","f","g","e","f","f","e","f","h");
        Collections.sort(list, SortType.QUICK_3_WAY_SORT);
        System.out.println(list);
    }
}
