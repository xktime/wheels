package Algorithms;

import Algorithms.Enums.SortType;
import Util.Collection.List.ArrayListImpl;
import Util.Collection.List.List;
import Util.Funciton.Collections;

public class QuickSortTest {
    public static void main(String[] args) {
        List<String> list = new ArrayListImpl<>();
        list.addAll("c","b","a","d","g","f","e","h");
        Collections.sort(list, SortType.QUICK_SORT);
        System.out.println(list);
    }
}
