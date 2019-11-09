package Util.Funciton;

import Util.Collection.List.List;
import Algorithms.Enums.SortType;
import Util.Factory.SortFactory;
import Algorithms.Sort.BubbleSort;
import Algorithms.Sort.Sort;

import java.util.Random;

public class Collections {

    //排序(默认冒泡排序)
    public static void sort(List<? extends Comparable> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Sort sort = new BubbleSort();
        sort.sort(list);
    }

    //排序（根据排序枚举取排序算法）
    public static void sort(List<? extends Comparable> list, SortType sortType) {
        if (list == null || list.isEmpty() || sortType == null) {
            return;
        }
        SortFactory sortFactory = new SortFactory();
        Sort sort = sortFactory.createSort(sortType.getSortName());
        if (sort == null) {
            return;
        }
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
                || list.isEmpty()
                || j == k
                || j < 0
                || k < 0
                || j >= list.size()
                || k >= list.size()) {
            return;
        }
        //将list转换成数组
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
