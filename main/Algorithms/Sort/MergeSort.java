package Algorithms.Sort;

import Util.Collection.List.List;

public class MergeSort<T extends Comparable<? super T>> implements Sort<T> {


    @Override
    public void sort(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        sort(list, 0, list.size() - 1);
    }

    /**
     * 对list[low..high]进行排序
     */
    private void sort(List<T> list, int low, int high) {
        if (list == null || low < 0 || high < 0) {
            //异常跳出
            return;
        }
        if (low >= high) {
            //递归跳出条件
            return;
        }
        int mid = low + (high - low) / 2;
        sort(list, low, mid);//对左边排序
        sort(list, mid + 1, high);//对右边排序
        merger(list, low, mid, high);//归并
    }

    /**
     * 将list[low..mid]和list[mid+1..high]归并
     */
    private void merger(List<T> list, int low, int mid, int high) {
        if (list == null
                || low < 0
                || mid < 0
                || high < 0
                || low > mid
                || low > high
                || mid > high) {
            return;
        }
        int j = low;//前一个有序数组的初始下标
        int k = mid + 1;//后一个有序数组的初始下标
        Object[] temArr = list.toArray();//保存数据的临时数组
        for (int i = low; i <= high; i++) {
            if (j > mid) {
                //如果前一个有序数组的数据已经全部放入
                temArr[i] = list.get(k++);
            } else if (k > high) {
                //如果后一个有序数组的数据已经全部放入
                temArr[i] = list.get(j++);
            } else if (list.get(j).compareTo(list.get(k)) < 0) {
                temArr[i] = list.get(j++);
            } else {
                temArr[i] = list.get(k++);
            }
        }
        list.clear();
        for (Object t : temArr) {
            list.add((T)t);
        }
    }
}
