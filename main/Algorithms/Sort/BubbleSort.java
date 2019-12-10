package Algorithms.Sort;

import Util.Funciton.Collections;
import Util.Collection.List.List;

/**
 * 冒泡排序
 */
public class BubbleSort<T extends Comparable<? super T>> implements Sort<T> {
    @Override
    public void sort(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int j = 0; j < list.size() - 1; j++) {
            for (int k = j + 1; k < list.size(); k++) {
                if (list.get(j).compareTo(list.get(k)) > 0) {
                    Collections.swap(list, j, k);
                }
            }
        }
    }
}
