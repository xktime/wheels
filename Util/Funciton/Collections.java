package Funciton;

import List.List;
import Sort.*;

public class Collections {

    //排序
    public static void sort(List<? extends Comparable> list) {
        Sort sort = new BubbleSort();
        sort.sort(list);
    }

    //反转
    public static void reverse(List list) {

    }

    //随机打乱
    public static void shuffle(List list) {

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
