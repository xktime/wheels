package Algorithms.Sort;

import Util.Collection.List.List;
import Util.Funciton.Collections;

/**
 * 快速排序
 */
public class QuickSort<T extends Comparable<? super T>> implements Sort<T> {
    @Override
    public void sort(List<T> list) {
        Collections.shuffle(list);//打乱，
        quickSort(list, 0, list.size() - 1); //普通快速排序
    }

    private void quickSort(List<T> list, int low, int high) {
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

    private int partition(List<T> list, int low, int high) {
        int partition = high;
        int lo = low + 1;
        //基准元素
        T c = list.get(low);
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
            Collections.swap(list, lo++, partition--);
        }
        Collections.swap(list, low, partition);
        return partition;
    }
}
