package Util.Function;

import Algorithms.Enums.SortType;
import Util.Funciton.Collections;
import Util.Collection.List.LinkedListImpl;
import Util.Collection.List.List;

public class CollectionsTest {
	public static void main(String[] args) {
		List<Character> list = new LinkedListImpl<Character>();
		list.addAll('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');
		System.out.println("=============打乱前===================");
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println("=============打乱后===================");
		System.out.println(list);
		Collections.sort(list, SortType.INSERT_SORT);
		System.out.println("=============排序后===================");
		System.out.println(list);
		System.out.println("=============反转后===================");
		Collections.reverse(list);
		System.out.println(list);
	}
}