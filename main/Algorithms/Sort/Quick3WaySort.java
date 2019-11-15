package Algorithms.Sort;

import Util.Collection.List.List;
import Util.Funciton.Collections;

/**
 * 3向切分快速排序
 */
public class Quick3WaySort implements Sort {
    @Override
    public void sort(List<? extends Comparable> list) {
        Collections.shuffle(list);//打乱，
        quick3way(list, 0, list.size() - 1);//3向快速排序
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
