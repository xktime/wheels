package Algorithms.Search;

import Util.Collection.List.ArrayListImpl;
import Util.Collection.List.List;

public class CommonSearchTest {
    public static void main(String[] args) {
        Search b = new CommonSearch();
        List list = new ArrayListImpl<>();
        list.addAll("a", 1, 2, 'd', "e", "f", "d", "h");
        System.out.println(list);
        System.out.println("元素" + "【1】" + "所在下标为：" + b.search(list, 1));
        System.out.println("元素" + "【d】" + "所在下标为：" + b.search(list, "d"));
    }
}
