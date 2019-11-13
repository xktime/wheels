package Util.Factory;

import Algorithms.Enums.SortType;
import Algorithms.Sort.*;

/**
 * 排序算法工厂
 */
public class SortFactory {

    public Sort createSort(SortType sortType) {
        switch (sortType) {
            case BUBBLE_SORT:
                return new BubbleSort();
            case INSERT_SORT:
                return new InsertSort();
            case MERGE_SORT:
                return new MergeSort();
            case SELECTIONS_SORT:
                return new SelectionsSort();
            case QUICK_SORT:
                return new QuickSort();

        }
        return null;
    }
}
