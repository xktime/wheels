package Algorithms.Sort;

import Util.Collection.List.List;
import Util.Funciton.Collections;

public class QuickSort implements Sort {
    @Override
    public void sort(List<? extends Comparable> list) {
        Collections.shuffle(list);//打乱，
        quickSort(list, 0, list.size() - 1);
    }

    private void quickSort(List<? extends Comparable> list, int low, int high) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (low >= high) {
            return;
        }
        int partition = partition(list, low, high);
        quickSort(list, low, partition - 1);
        quickSort(list, partition + 1, high);
    }

    private int partition(List<? extends Comparable> list, int low, int high) {
        int partition = high;
        int lo = low + 1;
        while (true) {
            //从后找到比第一位小的值
            while (list.get(low).compareTo(list.get(partition)) < 0) {
                partition--;
                if (partition == low) {
                    break;
                }
            }
            //从前面找到比第一位大的值
            while (list.get(low).compareTo(list.get(lo)) > 0) {
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
}
