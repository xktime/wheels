package Algorithms.Sort;

import Util.Funciton.Collections;
import Util.Collection.List.List;

/**
 * 插入排序
 */
public class InsertSort<T extends Comparable<? super T>> implements Sort<T> {
    @Override
    public void sort(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int j = 1; j < list.size(); j++) {
            for (int k = j; k > 0; k--) {
                if (list.get(k).compareTo(list.get(k - 1)) < 0) {
                    Collections.swap(list, k, k - 1);
                } else {
                    break;
                }
            }
        }
    }
}
