package Algorithms.Sort;

import Util.Collection.List.List;
import Util.Funciton.Collections;

public class QuickSort implements Sort {
    @Override
    public void sort(List<? extends Comparable> list) {
        Collections.shuffle(list);//打乱，
//        quickSort(list, 0, list.size() - 1); //普通快速排序
        quick3way(list, 0, list.size() - 1);//3向快速排序
    }

    /**
     * 快速排序
     */
    private void quickSort(List<? extends Comparable> list, int low, int high) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (low >= high) {
            return;
        }
        //list[partition]左边的值都小于list[partition]，右边的值都大于
        int partition = partition(list, low, high);
        quickSort(list, low, partition - 1);//将左边排序
        quickSort(list, partition + 1, high);//将右边排序
    }

    private int partition(List<? extends Comparable> list, int low, int high) {
        int partition = high;
        int lo = low + 1;
        //基准元素
        Comparable c = list.get(low);
        while (true) {
            //从后找到比第一位小的值
            while (c.compareTo(list.get(partition)) < 0) {
                partition--;
                if (partition == low) {
                    break;
                }
            }
            //从前面找到比第一位大的值
            while (c.compareTo(list.get(lo)) > 0) {
                lo++;
                if (lo == high) {
                    break;
                }
            }
            if (lo >= partition) {
                break;
            }
            Collections.swap(list, lo, partition);
        }
        Collections.swap(list, low, partition);
        return partition;
    }

    /**
     * 3向快速排序（适用于相同元素较多的情况）
     */
    private void quick3way(List<? extends Comparable> list, int low, int high) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (low >= high) {
            return;
        }
        int lo = low;//list[low..lo]都小于基准元素
        int mid = low + 1;//list[lo..mid]都等于基准元素
        int hi = high;//list[hi..high]都大于基准元素
        //基准元素
        Comparable c = list.get(low);
        while(mid <= hi) {
            if (c.compareTo(list.get(mid)) > 0) {
                Collections.swap(list, lo++, mid++);
            } else if (c.compareTo(list.get(mid)) < 0) {
                Collections.swap(list, mid, hi--);
            } else {
                mid++;
            }
        }
        quick3way(list, low, lo);//将小于基准元素的list排序
        quick3way(list, mid, high);//将大于基准元素的list排序
    }
}
