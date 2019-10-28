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
        int mid = low + (low + high) / 2;
        sort(list, low, mid);//对左边排序
        sort(list, mid + 1, high);//对邮编排序
        merger(list, low, mid, high);
    }

    /**
     * 将list[low..mid]和list[mid+1..high]归并
     */
    private void merger(List<? extends Comparable> list, int low, int mid, int high) {
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
        List temList = new ArrayListImpl();
        for (int i = 0; i < list.size(); i++) {
            temList.add(list.get(i));
        }
        list.clear();
        for (int i = low; i <= high; i++) {
            if (j > mid) {
                list.add(temArr[k++]);
            } else if (k > high) {
                list.add(temArr[j++]);
            } else if (temArr[j].compareTo(temArr[k]) < 0) {
                list.add(temArr[j++]);
            } else {
                list.add(temArr[k++]);
            }
        }
    }
}
