package Sort;

import Funciton.Collections;
import List.List;

/**
 * 冒泡排序
 */
public class BubbleSort implements  Sort {
    @Override
    public void sort(List<? extends Comparable> list) {
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
