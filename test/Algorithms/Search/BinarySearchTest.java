package Algorithms.Search;

import Util.Collection.List.ArrayListImpl;
import Util.Collection.List.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        Search<String> b = new BinarySearch<>();
        List<String> list = new ArrayListImpl<>();
        list.addAll("a","b","c","d","e","f","g","h");
        System.out.println(list);
        System.out.println("元素" + "【i】" + "所在下标为：" + b.search(list, "i"));
        System.out.println("元素" + "【d】" + "所在下标为：" + b.search(list, "d"));
    }
}
