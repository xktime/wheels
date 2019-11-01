package Sort;

import List.*;

public class MergeSort implements Sort {


    @Override
    public void sort(List<? extends Comparable> list) {
        sort(list, 0, list.size() - 1);
    }

    /**
     * 对list[low..high]进行排序
     */
    private void sort(List<? extends Comparable> list, int low, int high) {
        if (list == null || low < 0 || high < 0) {
            //异常返回
            return;
        }
        if (low >= high) {
            //递归跳出条件
            return;
        }
        int mid = low + (high - low) / 2;
        sort(list, low, mid);//对左边排序
        sort(list, mid + 1, high);//对右边排序
        merger(list, low, mid, high);
    }

    /**
     * 将list[low..mid]和list[mid+1..high]归并
     */
    private void merger(List list, int low, int mid, int high) {
        if (list == null
                || low < 0
                || mid < 0
                || high < 0
                || low > mid
                || low > high
                || mid > high) {
            return;
        }
        //被归并的初始下标
        int j = low;
        int k = mid + 1;
        Object[] arr = list.toArray();
        for (int i = low; i <= high; i++) {
            if (j > mid) {
                arr[i] = list.get(k++);
            } else if (k > high) {
                arr[i] = list.get(j++);
            } else if (list.get(j).hashCode() < list.get(k).hashCode()) {
                arr[i] = list.get(j++);
            } else {
                arr[i] = list.get(k++);
            }
        }
        list.clear();
        list.addAll(arr);
    }
}
