package Funciton;

import List.*;
import Sort.*;

import java.util.Random;

public class Collections {

	//排序
	public static void sort(List<? extends Comparable> list) {
//		Sort sort = new SelectionsSort();
//		Sort sort = new BubbleSort();
//		Sort sort = new InsertSort();
		Sort sort = new MergeSort();
		sort.sort(list);
	}

	//反转
	public static void reverse(List list) {
		if (list == null || list.isEmpty()) {
			return;
		}
		Object[] newList = list.toArray();
		list.clear();
		//倒叙遍历添加进原List
		for (int i = newList.length - 1; i >= 0; i--) {
			list.add(newList[i]);
		}
	}

	//随机打乱
	public static void shuffle(List list) {
		if (list == null || list.isEmpty()) {
			return;
		}
		int size = list.size();
		Random random = new Random();
		//随机交换次序
		for (int i = 0; i < size; i++) {
			swap(list, i, random.nextInt(size));
		}
	}

	//交换List下标为j和k的元素
	public static void swap(List list, int j, int k) {
		if (list == null
				|| j == k
				|| j < 0
				|| k < 0
				|| j >= list.size()
				|| k >= list.size()) {
			return;
		}
		//将list转换陈成数组
		Object[] arr = list.toArray();
		//交换元素
		Object temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
		//清空list后将交换过元素之后的数组放进list
		list.clear();
		list.addAll(arr);
	}
}
