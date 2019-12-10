package Algorithms.Sort;

import Util.Funciton.Collections;
import Util.Collection.List.List;

/**
 * 选择排序
 */
public class SelectionsSort<T extends Comparable<? super T>> implements Sort<T> {
    @Override
    public void sort(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int j = 0; j < list.size() - 1; j++) {
            int minIndex = j;//最小元素的下标
            for (int k = minIndex + 1; k < list.size(); k++) {
                if (list.get(k).compareTo(list.get(minIndex)) < 0) {
                    minIndex = k; //记下目前找到的最小值所在的下标
                }
            }
            Collections.swap(list, j, minIndex);
        }
    }
}
